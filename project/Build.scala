import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "deadbolt-core"
    val appVersion      = "2.1-SNAPSHOT"

    val appDependencies = Seq(
      javaCore
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      organization := "be.objectify"
    )
}
