package com.example.demo.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Класс с SQL командами
 */
@Data
@Component
@ConfigurationProperties("sqlquery")
@PropertySource("classpath:sql.properties")
public class SqlQuery {

    private String findAll;
    private String save;
    private String deleteById;
    private String updateUser;
    private String findById;
}
