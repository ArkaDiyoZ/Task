package com.example.testtask.controllers

import com.tej.JooQDemo.jooq.sample.model.Tables
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Cars
import com.tej.JooQDemo.jooq.sample.model.tables.records.CarsRecord
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.awt.print.Book


@RestController
@RequestMapping("/cars")
class BookController(
) {

    init {
        println("CONTROLL")
    }
    @Autowired
    val context: DSLContext? = null

    @PostMapping
    fun postBook(@RequestBody car: Cars) {
        println(car)
        println(context)
        context
            ?.insertInto(Tables.CARS, Tables.CARS.CAR_GOS_NUM)
            ?.values(car.carGosNum)
            ?.execute()
    }

    @GetMapping("/{id}")
    fun getCarInfo(): MutableList<Cars>? {
        return context
            ?.selectFrom(Tables.CARS)
            ?.fetchInto(Cars::class.java)
    }


}