package com.example.demo

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface DemoRepository : ReactiveCrudRepository<Demo, String> {

    fun findByName(name: String): Flux<Demo>

}