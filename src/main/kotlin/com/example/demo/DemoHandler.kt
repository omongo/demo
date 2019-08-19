package com.example.demo

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.json
import reactor.core.publisher.Mono

@Component
class DemoHandler(val repository: DemoRepository) {

    fun listDemos(request: ServerRequest): Mono<ServerResponse> {
        val name = request.queryParam("name")
        return if (name.isEmpty) {
            ok().json().body(repository.findAll())
        } else {
            ok().json().body(repository.findByName(name.get()))
        }
    }

    fun getDemo(request: ServerRequest): Mono<ServerResponse> =
        ok().json().body(repository.findById(request.pathVariable("id")))

}