package com.example.testtask.controllers

import java.io.Serializable

class CarDto: Serializable{
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
}