package job.aggregator.backend;

import job.aggregator.backend.config.ComponentScanConfig;
import job.aggregator.backend.config.ProblemResponseEntityExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.zalando.problem.ProblemModule;

import javax.sql.DataSource;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@Import({ComponentScanConfig.class})
@RequiredArgsConstructor
public class JobAggregatorApplication {

    final DataSource dataSource;
    final BuildProperties buildProperties;
    final ProblemResponseEntityExceptionHandler problemResponseEntityExceptionHandler;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(JobAggregatorApplication.class);
        application.setAddCommandLineProperties(true);
        application.run(args);
    }

    @Bean
    public ProblemModule problemModule() {
        return new ProblemModule();
    }
}
