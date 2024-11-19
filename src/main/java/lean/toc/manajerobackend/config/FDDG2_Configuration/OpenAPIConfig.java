package lean.toc.manajerobackend.config.FDDG2_Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI springShopOpenAPI(){
        return new OpenAPI().info(infoAPI());
    }
    public Info infoAPI(){
        return new Info().title("\uD83C\uDFBF PI PROJECT \uD83D\uDEA0")
                .description("PI PROJECT")
                .contact(contactAPI());
    }
    public Contact contactAPI(){
        return new Contact().name("Mohamed aziz belaidi");
    }
}
