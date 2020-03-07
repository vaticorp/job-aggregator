package job.aggregator.backend.config;

import job.aggregator.commons.exceptions.TechnicalException;
import job.aggregator.commons.services.MessageService;
import job.aggregator.commons.services.ProblemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;

import static job.aggregator.commons.utils.ProblemCodes.TECHNICAL_PROBLEM;
import static org.zalando.problem.Status.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ProblemResponseEntityExceptionHandler implements SecurityAdviceTrait {

    private final ProblemService problemService;
    private final MessageService messageService;

    @ExceptionHandler(TechnicalException.class)
    protected ResponseEntity<Problem> handleTechnicalException(TechnicalException ex, NativeWebRequest webRequest) {
        log.error(ex.getMessage(), ex);
        return create(problemService.createProblem(TECHNICAL_PROBLEM, INTERNAL_SERVER_ERROR,
                messageService.createSingletonMessageList(ex.getCode(), ex.getReplacements())), webRequest);
    }
}
