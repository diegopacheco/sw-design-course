package com.github.diegopacheco.gatling.microservices.st

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import StressConfig._

class StressTest extends Simulation {
  
  val httpProtocol = http
    .baseUrl(StressConfig.gatlingUrl)
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
//    .shareConnections

  val scn = scenario("Happy Path Stress")
     .exec(
       http("get current date")
         .get("/rest/datetime/")
     )
  
  setUp(scn.inject(
        constantUsersPerSec(StressConfig.gatlingUsers).
        during(StressConfig.gatlingDuring)
  ).protocols(httpProtocol))
  
}
