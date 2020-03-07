package job.aggregator.commons.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SingleCodeException extends RuntimeException {

    private final int code;
    private final String[] replacements;
}
