name := "deadbolt-core"

version := "2.4.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.5"

crossScalaVersions := Seq("2.11.5", "2.10.4")

organization := "be.objectify"

libraryDependencies ++= Seq(
  "org.mockito" % "mockito-all" % "1.9.5" % "test"
)
