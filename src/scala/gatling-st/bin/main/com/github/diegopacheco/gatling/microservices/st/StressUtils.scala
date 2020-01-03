package com.github.diegopacheco.gatling.microservices.st

import scala.concurrent.duration._

object StressConfig{

   def gatlingUrl():String  = {
        if (System.getProperty("GATLING_URL")!=null){
           return System.getProperty("GATLING_URL").toString
        } else {
           return "http://localhost:8080"
        }
   }

   def gatlingUsers():Double  = {
       if (System.getProperty("GATLING_USERS")!=null){
         return new java.lang.Double(System.getProperty("GATLING_USERS"))
       }else{
         return 1D
       }
   }

   def gatlingDuring():FiniteDuration = {
       if (System.getProperty("GATLING_DURING")!=null) {
         return FiniteDuration(new java.lang.Long(System.getProperty("GATLING_DURING")), "seconds")
       } else{
         return FiniteDuration(60L, "seconds")
       }
   } 
}
