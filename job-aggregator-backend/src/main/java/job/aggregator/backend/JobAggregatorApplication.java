package job.aggregator.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JobAggregatorApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(JobAggregatorApplication.class);
        application.setAddCommandLineProperties(true);
        application.run(args);
    }
}
