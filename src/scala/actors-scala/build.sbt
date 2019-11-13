name := "actors-scala"
version := "1.0"
scalaVersion := "2.13.1"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.0"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3" % Runtime
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.6.0" % Test

