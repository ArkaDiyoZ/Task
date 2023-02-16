package com.auto.task.controllers

import com.auto.task.dto.CarDto
import com.auto.task.loggers.WarningLogger
import com.auto.task.service.CarService
import com.google.gson.Gson
import com.tej.JooQDemo.jooq.sample.model.Tables
import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.HttpServletResponse.SC_NOT_FOUND
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.math.log


@RestController
@RequestMapping("/cars")
class CarController(
    private val carService: CarService
    ) {

    val logger: WarningLogger = WarningLogger()

    @GetMapping("/{id}")
    fun getCarInfo(@PathVariable("id") id: Int, response: HttpServletResponse): CarDto? {
        val car = carService.getById(id)

        if (car == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            logger.log("Not found")
            return null
        }
        return car
    }

}