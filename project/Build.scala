import sbt._
import Keys._
import play.Play.autoImport._
import PlayKeys._

object ApplicationBuild extends Build {

    val appName         = "deadbolt-core"
    val appVersion      = "2.3.0-RC1"

    val appDependencies = Seq(
      "org.mockito" % "mockito-all" % "1.9.5" % "test"
    )

    val main = Project(appName, file(".")).enablePlugins(play.PlayJava).settings(
      organization := "be.objectify",
      version := appVersion,
      libraryDependencies ++= appDependencies
    )
}
