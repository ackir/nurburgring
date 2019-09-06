package com.aytunccankir.nurburgring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NurburgringApplication

fun main(args: Array<String>) {
	runApplication<NurburgringApplication>(*args)
}
