package org.javastart.deposit.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// http://localhost:8083/deposits/swagger-ui/index.html
@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI accountServiceOpenApi() {
        return new OpenAPI().info(
                new Info()
                        .title("Deposit service API")
                        .description("Description of the methods for Deposit service")
                        .version("1.0.0")
        );
    }
}
