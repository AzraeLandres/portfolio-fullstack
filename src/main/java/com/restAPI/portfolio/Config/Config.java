package com.restAPI.portfolio.Config;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



@Configuration
public class Config {


    private String jdbcUrl;
    private String username;
    private String password;

    public Config() throws URISyntaxException {
        String dbUrl = System.getenv("CLEARDB_PURPLE_URL");
        
        URI dbUri = new URI(dbUrl);

        username = dbUri.getUserInfo().split(":")[0];
        password = dbUri.getUserInfo().split(":")[1];
        String db = dbUri.getPath();
        String host = dbUri.getHost();

        jdbcUrl = "jdbc:mysql://" + host + db + "?reconnect=true&serverTimezone=Europe/Paris";
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
