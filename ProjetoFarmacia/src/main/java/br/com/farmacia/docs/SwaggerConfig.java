package br.com.farmacia.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author vinicius.montouro
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private final String basePackage = "br.com.farmacia";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Pharmacy Apontador")
                .description("API to consult the pharmacy register")
                .version("1.0")
                .contact(new Contact("Vinicius Martinez Montouro as the Jedi Master", "https://www.linkedin.com/in/vinicius-martinez-montouro/", "vinicius.mmontouro@gmail.com"))
                .build();
    }
}
