name := "deadbolt-core"

version := "2.3.3-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

crossScalaVersions := Seq("2.11.1", "2.10.4")

organization := "be.objectify"

libraryDependencies ++= Seq(
  "org.mockito" % "mockito-all" % "1.9.5" % "test"
)
