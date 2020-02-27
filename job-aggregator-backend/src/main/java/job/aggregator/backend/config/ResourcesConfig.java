package job.aggregator.backend.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ResourcesConfig {

    @Bean(name = "meldungMessageSource")
    public MessageSource meldungMessageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:/i18n/meldung");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(-1);

        return messageSource;
    }

    @Bean(name = "problemsMessageSource")
    public MessageSource problemsMessageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:/i18n/problems");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(-1);

        return messageSource;
    }
}

