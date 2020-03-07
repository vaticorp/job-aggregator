package job.aggregator.backend.rest.ping;

import io.swagger.annotations.Api;
import job.aggregator.commons.exceptions.TechnicalException;
import job.aggregator.commons.utils.MessageCodes;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class PingController {

    @Value("${job-aggregator.version}")
    @Getter
    private String version;

    @GetMapping(path = "api/jobAggregator/ping")
    public String getVersion() {
        if (true) {
            throw new TechnicalException(MessageCodes.VACATION_GENERAL_FAILURE);
        }
        return version;
    }
}
