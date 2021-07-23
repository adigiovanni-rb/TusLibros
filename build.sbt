name := "TusLibros"
 
version := "1.0" 
      
lazy val `tuslibros` = (project in file(".")).enablePlugins(PlayScala)

      
resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
      
scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  jdbc,
  ehcache,
  ws,
  specs2 % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % "test",
  guice )

//Esto es para que ande el debugger en test mode
fork in run := true
fork in Test := true
parallelExecution in Test := true


      