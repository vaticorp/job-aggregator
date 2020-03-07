package job.aggregator.commons.exceptions;

import org.springframework.lang.NonNull;

public class TechnicalException extends SingleCodeException {

    public TechnicalException(int code, String... replacements) {
        super(code, replacements);
    }
}
