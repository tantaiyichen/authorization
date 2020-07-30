package com.admin.config;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Author: Caiqin
 * @Date: 2020/5/21 9:11
 * @Description: 集成Swagger接口文档
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        //添加请求参数，把token作为请求头部参数传入后端
        ParameterBuilder builder = new ParameterBuilder();
        ArrayList<Parameter> parameters = new ArrayList<>();
        builder.name( "token" ).description( "令牌" ).modelRef( new ModelRef( "string" ) )
                .parameterType( "header" ).required( false ).build();
        parameters.add( builder.build() );
        return new Docket( DocumentationType.SWAGGER_2 )
                .apiInfo( apiInfo() )
                .select()
                .apis( RequestHandlerSelectors.basePackage( "com.admin" ) )
                .paths( PathSelectors.any() )
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title( "权限管理API文档" )
                .description( "权限管理API文档" )
                .version( "1.0" )
                .build();
    }
}
