package com.auto.task.service

import com.auto.task.dto.CarDto
import jakarta.servlet.http.HttpServletResponse

interface CarService {
    fun getById(id: Int): CarDto?
}