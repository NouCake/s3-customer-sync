package de.kevfischer.s3customersync.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("#{environment.MARIA_HOST}")
    private String MARIA_HOST;
    @Value("#{environment.MARIA_USER}")
    private String MARIA_USER;
    @Value("#{environment.MARIA_PW}")
    private String MARIA_PW;
    @Value("#{environment.MARIA_DB}")
    private String MARIA_DB;

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.mariadb.jdbc.Driver")
                .url("jdbc:mariadb://"+MARIA_HOST+"/"+MARIA_DB)
                .username(MARIA_USER)
                .password(MARIA_PW)
                .build();
    }

}
