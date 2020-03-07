package job.aggregator.commons.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MessageCodes {

    /*Business logic*/
    public final static int VALIDATION_FAILURE_INPUT_GENERAL = 210000;
    public final static int VACATION_GENERAL_FAILURE = 210001;

    /*Technical*/
    public final static int INTERNAL_SERVER_ERROR = 216000;
    public final static int LOGGER_ERROR = 216002;
    public final static int UUID_REQUEST_HEADERS_FORMAT = 216003;
    public final static int DATATYPE_FACTORY_FAILURE = 216005;
    public final static int EXTERNAL_SYSTEM_ERROR = 216006;
    public final static int EXTERNAL_SYSTEM_CONNECTION_FAILURE = 216007;
}
