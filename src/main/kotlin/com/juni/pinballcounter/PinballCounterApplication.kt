package com.juni.pinballcounter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PinballCounterApplication

fun main(args: Array<String>) {
    runApplication<PinballCounterApplication>(*args)
}
