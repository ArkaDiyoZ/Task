package com.auto.task.service.impl

import com.auto.task.service.KafkaProducerService
import com.auto.task.dto.CarDto
import com.auto.task.loggers.WarningLogger

import com.auto.task.service.CarService
import com.auto.task.types.KafkaTopics
import com.google.gson.Gson
import com.tej.JooQDemo.jooq.sample.model.Tables
import jakarta.servlet.http.HttpServletResponse
import org.jooq.DSLContext
import org.jooq.JSON
import org.jooq.tools.json.JSONObject
import org.springframework.stereotype.Service

@Service
class CarServiceImpl (
    private val DSLContext: DSLContext,
    private val kafkaControl: KafkaProducerService
): CarService {

    override fun getById(id: Int): CarDto? {
        val carStr = DSLContext
            .select(
                Tables.CARS.CAR_ID, Tables.CARS.CAR_GOS_NUM,
                Tables.MARKS.MARK_NAME, Tables.MODELS.MODEL_NAME,
                Tables.MODELS.MODEL_HP, Tables.MODELS.MODEL_ENGINE_TYPE,
                Tables.MODELS.MODEL_ENGINE_VOLUME, Tables.MODELS.MODEL_TRANSMISSION_TYPE,
                Tables.MODELS.MODEL_STEERING_WHEEL, Tables.MODELS.EQUIPMENT_TYPE,
                Tables.TYPES.TYPE_NAME)
            .from(Tables.CARS)
            .join(Tables.TYPES)
            .on(Tables.TYPES.TYPE_ID.eq(Tables.CARS.TYPE_ID))
            .join(Tables.MARKS)
            .on(Tables.CARS.MARK_ID.eq(Tables.MARKS.MARK_ID))
            .join(Tables.MODELS)
            .on(Tables.MARKS.MODEL_ID.eq(Tables.MODELS.MODEL_ID))
            .where(Tables.CARS.CAR_ID.eq(id))
            .fetchOneInto(CarDto::class.java)

        val carJson = Gson().toJson(carStr)
        kafkaControl.produceMessage(KafkaTopics.CARS, carJson)
        return carStr
    }

}