package com.example.demo.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("sqlquery")
public class SqlQuery {
    private String findAll;
    private String save;
    private String deleteById;
    private String updateUser;
    private String findById;
}
