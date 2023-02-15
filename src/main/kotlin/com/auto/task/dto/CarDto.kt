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
){


     override fun toString(): String {
          val strStart: StringBuilder = java.lang.StringBuilder("Cars (")

          strStart.append(carId);
          strStart.append(", ").append(carGosNum);
          strStart.append(", ").append(markName);
          strStart.append(", ").append(modelName);
          strStart.append(", ").append(modelHp);
          strStart.append(", ").append(modelEngineType);
          strStart.append(", ").append(modelEngineVolume);
          strStart.append(", ").append(modelTransmissionType);
          strStart.append(", ").append(modelSteeringWheel);
          strStart.append(", ").append(equipmentType);
          strStart.append(", ").append(typeName);


          strStart.append(")");
          return strStart.toString();
     }
}

