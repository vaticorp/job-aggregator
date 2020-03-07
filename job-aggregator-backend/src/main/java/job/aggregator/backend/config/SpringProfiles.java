package job.aggregator.backend.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SpringProfiles {
    static final String SPRING_BOOT = "springBoot";
    static final String SPRING_CLASSIC = "!springBoot";
    static final String SPRING_LOCAL = "LOCAL";
    static final String SPRING_TEST = "integrationTest";
    static final String PRODUCTION = String.format("!%s", SPRING_TEST);
}
