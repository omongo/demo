package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class DemoRouter {

    @Bean
    fun route(handler: DemoHandler): RouterFunction<ServerResponse> = router {
        accept(APPLICATION_JSON).nest {
            GET("/demos", handler::listDemos)
            GET("/demos/{id}", handler::getDemo)
        }
    }
}