name := "deadbolt-core"

version := "2.4.1-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

crossScalaVersions := Seq("2.11.6", "2.10.5")

organization := "be.objectify"

libraryDependencies ++= Seq(
  "org.mockito" % "mockito-all" % "1.10.19" % "test"
)
