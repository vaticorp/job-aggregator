package job.aggregator.backend.rest.ping;

import io.swagger.annotations.Api;
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
        return version;
    }
}
