package com.example.springboot.configuration.flyway;

import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlyWayConfig {

	@Value("${spring.datasource-mysql.url}")
	String datasource_logicMysqlUrl;
	@Value("${spring.datasource-mysql.username}")
	String datasource_logicMysqlUser;
	@Value("${spring.datasource-mysql.password}")
	String datasource_logicMysqlPassword;
	
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

		Flyway flywayMysql = Flyway.configure()
				.cleanDisabled(true)
				.table("security_schema_history") //nombre de la tabla donde flyway guarda el histórico
				.baselineOnMigrate(true).baselineVersion("-1").encoding(StandardCharsets.UTF_8)
				.schemas("security") //nombre de la bbdd que flyway va a mantener
				.validateOnMigrate(true).dataSource(datasource_logicMysqlUrl, datasource_logicMysqlUser, datasource_logicMysqlPassword)
				.locations("filesystem:./src/main/resources/db/migration/mysql/security").load();

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

				
		flywayMysql.migrate();
		flywayPostgres.migrate();

	}
}

