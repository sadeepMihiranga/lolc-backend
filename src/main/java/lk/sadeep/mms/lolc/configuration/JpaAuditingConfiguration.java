package lk.sadeep.mms.lolc.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // will enable the Spring Data JPA Auditing features for the application
public class JpaAuditingConfiguration
{
}
