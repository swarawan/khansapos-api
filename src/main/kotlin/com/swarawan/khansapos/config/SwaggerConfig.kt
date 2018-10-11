package com.swarawan.khansapos.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.swarawan.khansapos.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(metaInfo())

    fun metaInfo(): ApiInfo = ApiInfo(
            "Khansa POS",
            "Created using Kotlin - Spring Boot",
            "v1",
            "none",
            Contact("Rio Swarawan",
                    "http://swarawan.com",
                    "swarawan.rio@gmail.com"),
            "none", "none",
            emptyList())

}