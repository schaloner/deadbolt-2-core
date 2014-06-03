name := """deadbolt-core"""

version := "2.3.0-RC1"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

organization := "be.objectify"

libraryDependencies ++= Seq(
     javaCore,
      "org.mockito" % "mockito-all" % "1.9.5" % "test"
)
    