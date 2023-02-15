package com.avto.task.dto
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.io.Serial



class CarDto{
     var carId: Int? = null
     var carGosNum: String? = null
     var markName: String? = null
     var modelName: String? = null
     var modelHp: Int? = null
     var modelEngineType: String? = null
     var modelEngineVolume: Float? = null
     var modelTransmissionType: String? = null
     var modelSteeringWheel: String? = null
     var equipmentType: String? = null


     override fun toString(): String {
          var strStart: StringBuilder = java.lang.StringBuilder("Cars (")

          strStart.append(carId);
          strStart.append(", ").append(carGosNum);
          strStart.append(", ").append(markName);
          strStart.append(", ").append(modelHp);
          strStart.append(", ").append(modelEngineType);
          strStart.append(", ").append(modelEngineVolume);
          strStart.append(", ").append(modelTransmissionType);
          strStart.append(", ").append(modelSteeringWheel);
          strStart.append(", ").append(equipmentType);

          strStart.append(")");
          return strStart.toString();
     }
}

