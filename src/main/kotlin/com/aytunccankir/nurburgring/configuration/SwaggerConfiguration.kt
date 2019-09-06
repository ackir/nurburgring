package com.aytunccankir.nurburgring.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType.SWAGGER_2
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Bean
    fun pimReadApi(): Docket {
        return Docket(SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo("nurburgring"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aytunccankir.nurburgring.controller"))
                .build()
    }

    private fun apiInfo(appName: String): ApiInfo {
        return ApiInfoBuilder()
                .title(appName)
                .description(appName)
                .contact(contact())
                .version("1.0")
                .build()
    }

    private fun contact(): Contact {
        return Contact("Aytunç Can KIR", null, "aytunccankir@gmail.com")
    }
}