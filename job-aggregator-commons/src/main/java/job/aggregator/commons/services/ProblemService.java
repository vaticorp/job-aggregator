package job.aggregator.commons.services;

import job.aggregator.common.models.so.Message;
import job.aggregator.commons.utils.MessageCodes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.ThrowableProblem;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class ProblemService {

    private static final String BASE_URI = "https://api/jobAggregator/errors/";
    private static final String DETAILS_RESOURCES_PROPERTY = ".details";
    private static final String TITLE_RESOURCES_PROPERTY = ".title";

    @Qualifier("problemsMessageSource")
    private final MessageSource problemsMessageSource;

    public ThrowableProblem createProblem(int problemCode, Status status, List<Message> messages) {
        return Problem.builder()
                .withType(getType(messages))
                .withTitle(getTitle(problemCode))
                .withStatus(status)
                .withDetail(getDetails(problemCode))
                .with("messages", messages)
                .build();
    }

    private URI getType(List<Message> messages) {
        int errorCode;

        switch (messages.size()) {
            case 0:
                errorCode = MessageCodes.INTERNAL_SERVER_ERROR;
                break;
            case 1:
                errorCode = messages.get(0).getCode();
                break;
            default:
                errorCode = getDefaultErrorCode(messages);
        }
        return URI.create(BASE_URI + errorCode);
    }

    private int getDefaultErrorCode(List<Message> messages) {
        if (messages.stream()
                .map(Message::getCode)
                .anyMatch(messageCode -> MessageCodes.VACATION_GENERAL_FAILURE == messageCode)) {

            return MessageCodes.EXTERNAL_SYSTEM_ERROR;
        }

        return MessageCodes.VALIDATION_FAILURE_INPUT_GENERAL;
    }

    private String getTitle(int problemCode) {
        return getMessage(problemCode + TITLE_RESOURCES_PROPERTY);
    }

    private String getDetails(int problemCode) {
        return getMessage(problemCode + DETAILS_RESOURCES_PROPERTY);
    }

    private String getMessage(String problemCode) {
        return problemsMessageSource.getMessage(problemCode, null, Locale.GERMAN);
    }
}
