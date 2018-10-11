package com.swarawan.khansapos.config

import com.swarawan.khansapos.ext.readFile
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.ResourceUtils
import org.springframework.web.bind.annotation.RequestMethod
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.builders.ResponseMessageBuilder
import springfox.documentation.schema.ModelRef
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
            .paths(PathSelectors.ant("/api/v1/**"))
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

    private fun getMockResponse(resourceLocation: String): ModelRef =
            ModelRef(ResourceUtils.getFile(resourceLocation).readFile())

}