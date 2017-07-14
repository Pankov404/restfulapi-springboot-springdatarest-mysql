package com.hellokoding.restfulapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Alexander Pankov on 14.07.2017.
 */
@Configuration
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hellokoding.restfulapi.repository"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Alexander Pankov",
                "https://github.com/Pankov404/restfulapi-springboot-springdatarest-mysql",
                "pankov404@yandex.com");
        VendorExtension vendorExtension = new VendorExtension() {
            @Override
            public String getName() {
                return "Alexander Pankov";
            }

            @Override
            public Object getValue() {
                return "Value";
            }
        };

        return new ApiInfo(
                "Spring Data Rest with Swagger",
                "",
                "1.0",
                "",
                contact,
                "",
                "",
                new ArrayList<VendorExtension>(Collections.singletonList(vendorExtension))
        );
    }

}
