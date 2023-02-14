package com.example.testtask.controllers

import com.tej.JooQDemo.jooq.sample.model.Tables
import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.HttpServletResponse.SC_NOT_FOUND
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.jooq.impl.QOM
import org.jooq.impl.QOM.JSONObject
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/cars")
class CarController(private val DSLContext: DSLContext) {

    @GetMapping("/{id}")
    fun getCarInfo(@PathVariable("id") id: Int, response: HttpServletResponse): Any? {
        try {
            return DSLContext
            .select()
            .from(Tables.CARS)
            .innerJoin(Tables.TYPES)
            .on(Tables.TYPES.TYPE_ID.eq(Tables.CARS.TYPE_ID))
            .innerJoin(Tables.MARKS)
            .on(Tables.CARS.MARK_ID.eq(Tables.MARKS.MARK_ID))
            .innerJoin(Tables.MODELS)
            .on(Tables.MARKS.MODEL_ID.eq(Tables.MODELS.MODEL_ID))
            .where(Tables.CARS.CAR_ID.eq(id))
            .fetchInto(CarDto::class.java)[0]
        } catch (e: Exception){
            if (Exception::class.java.isAssignableFrom(e::class.java)){
                response.status = SC_NOT_FOUND
                return "Not Found"
            }
        }
        return null
    }

}