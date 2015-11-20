name := "deadbolt-core"

version := "2.5.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

organization := "be.objectify"

libraryDependencies ++= Seq(
  "org.mockito" % "mockito-all" % "1.10.19" % "test"
)
