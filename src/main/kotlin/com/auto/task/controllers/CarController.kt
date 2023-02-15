package com.auto.task.controllers

import com.auto.task.dto.CarDto
import com.auto.task.loggers.WarningLogger
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
    @Autowired
    private val DSLContext: DSLContext,
    private val KafkaControl: KafkaController
    ) {

    val logger: WarningLogger = WarningLogger()

    @GetMapping("/{id}")
    fun getCarInfo(@PathVariable("id") id: Int, response: HttpServletResponse): CarDto? {

        val carStr = DSLContext
            .select(Tables.CARS.CAR_ID, Tables.CARS.CAR_GOS_NUM,
            Tables.MARKS.MARK_NAME,Tables.MODELS.MODEL_NAME,
            Tables.MODELS.MODEL_HP, Tables.MODELS.MODEL_ENGINE_TYPE,
            Tables.MODELS.MODEL_ENGINE_VOLUME, Tables.MODELS.MODEL_TRANSMISSION_TYPE,
            Tables.MODELS.MODEL_STEERING_WHEEL, Tables.MODELS.EQUIPMENT_TYPE,
            Tables.TYPES.TYPE_NAME)
            .from(Tables.CARS)
            .innerJoin(Tables.TYPES)
            .on(Tables.TYPES.TYPE_ID.eq(Tables.CARS.TYPE_ID))
            .innerJoin(Tables.MARKS)
            .on(Tables.CARS.MARK_ID.eq(Tables.MARKS.MARK_ID))
            .innerJoin(Tables.MODELS)
            .on(Tables.MARKS.MODEL_ID.eq(Tables.MODELS.MODEL_ID))
            .where(Tables.CARS.CAR_ID.eq(id))
            .fetchOneInto(CarDto::class.java)
        if (carStr == null) {
            response.status = SC_NOT_FOUND
            logger.log("Not found")
            return null
        }
        KafkaControl.produceMessage(carStr.toString())
        return carStr

    }

}