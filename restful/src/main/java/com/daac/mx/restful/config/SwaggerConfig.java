package com.daac.mx.restful.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    static List<VendorExtension> vendorExtensions = new ArrayList<>();

    private static final Contact DEFAULT_CONTACT = new Contact("Dante","www.daac.com", "daac_99@yahoo.com.mx");
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Photo app RESTful Web Service documentation",
            "This pages documents Photo app RESTful Web Service endpoints", "1.0",
            "http://www.appsdeveloperblof.com/service.html", DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", vendorExtensions);

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO);
    }

}
