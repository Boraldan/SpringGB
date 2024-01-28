package boraldan.rikkyandmorty.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Адреса url для запросов JSON
 */
@Data
@Component
@ConfigurationProperties("url")
@PropertySource("classpath:api.properties")
public class Url {

    private String CHARACTER_API;
    private String CHAR_ID_API;
}
