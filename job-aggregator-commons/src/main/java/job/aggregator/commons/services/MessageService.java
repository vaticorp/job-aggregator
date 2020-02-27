package job.aggregator.commons.services;

import job.aggregator.common.models.so.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MessageService {

    public Message createMessage(Integer code, @Nullable String... replacements) {
        Objects.requireNonNull(code);
        final Message message = new Message();

        /*message.setDescription(meldungMessageSource.getMessage(
                getTextPropertyName(code), replacements, Locale.GERMAN));*/
        /*message.setType(MessageCategory.valueOf(meldungMessageSource.getMessage(
                getLevelPropertyName(code), null, Locale.GERMAN)));*/
        message.setTimestamp(LocalDateTime.now());
        message.setCode(code);

        return message;
    }

}
