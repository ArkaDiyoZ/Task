package com.auto.task

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestTaskApplication

fun main(args: Array<String>) {
	runApplication<TestTaskApplication>(*args)
}
