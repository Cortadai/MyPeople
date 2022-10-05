package com.example.springboot.configuration.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

@Configuration
public class FlywayConfig {
    
    @Value("${spring.datasource-postgres.url}")
    String datasourcePostgresUrl;
    @Value("${spring.datasource-postgres.username}")
    String datasourcePostgresUser;
    @Value("${spring.datasource-postgres.password}")
    String datasourcePostgresPassword;
    @Value("${spring.datasource-postgres.schema}")
    String datasourcePostgresSchema;

    @PostConstruct
    public void migrateFlyway() {

        Flyway flywayPostgres = Flyway.configure()
                .cleanDisabled(true)
                .table("my_people_schema_history")
                .baselineOnMigrate(true)
                .baselineVersion("-1")
                .encoding(StandardCharsets.UTF_8)
                .schemas(datasourcePostgresSchema)
                .validateOnMigrate(true)
                .dataSource(datasourcePostgresUrl, datasourcePostgresUser, datasourcePostgresPassword)
                .locations("filesystem:./src/main/resources/db/migration/postgres")
                .load();

        flywayPostgres.migrate();

    }

}
