import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "deadbolt-core"
    val appVersion      = "2.2-RC1"

    val appDependencies = Seq(
      javaCore,

      "org.mockito" % "mockito-all" % "1.9.5" % "test"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      organization := "be.objectify"
    )
}
