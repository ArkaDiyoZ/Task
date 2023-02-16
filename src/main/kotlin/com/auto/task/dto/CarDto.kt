package com.auto.task.dto
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.io.Serial

class CarDto(
     val carId: Int,
     val carGosNum: String,
     val markName: String,
     val modelName: String,
     val modelHp: Int,
     val modelEngineType: String,
     val modelEngineVolume: Float,
     val modelTransmissionType: String,
     val modelSteeringWheel: String,
     val equipmentType: String,
     val typeName: String
) {
     override fun toString(): String {
          val strStart: StringBuilder = java.lang.StringBuilder("Cars (")

          strStart.append(carId)
          .append(", ").append(carGosNum)
          .append(", ").append(markName)
          .append(", ").append(modelName)
          .append(", ").append(modelHp)
          .append(", ").append(modelEngineType)
          .append(", ").append(modelEngineVolume)
          .append(", ").append(modelTransmissionType)
          .append(", ").append(modelSteeringWheel)
          .append(", ").append(equipmentType)
          .append(", ").append(typeName)

          strStart.append(")")
          return strStart.toString()
     }
}

