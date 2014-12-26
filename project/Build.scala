import sbt._, Keys._
import sbtrelease.ReleasePlugin._

object TimeBuild extends Build {

  import Deps._

  val basicSettings = Seq(
    organization := "com.thenewmotion",
    crossScalaVersions := Seq(Scala.current, Scala.prev),
    scalaVersion := Scala.current,
    ReleaseKeys.crossBuild := true,
    scalacOptions := Seq(
      "-encoding", "UTF-8",
      "-unchecked",
      "-deprecation",
      "-feature",
      "-Xlog-reflective-calls"
    )
  )

  val publishSettings = Seq(
    publishTo := {
      def nexus(tpe: String) = s"http://nexus.thenewmotion.com/content/repositories/releases-$tpe"
      Some("publish" at (nexus(if (isSnapshot.value) "snapshots" else "releases")))
    },
    publishMavenStyle := true,
    licenses +=("Apache License, Version 2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
  ) ++ releaseSettings

  def proj(name: String, dir: String) = Project(id = name, base = file(dir))
    .settings(basicSettings: _*)
    .settings(publishSettings: _*)

  val time = proj("time", "time")
    .settings(description := "Scala wrapper around Joda-time")
    .settings(
      libraryDependencies ++= Seq(
        jodaTime,
        jodaConvert
      )
    )

  val scalazBindings = proj("time-scalaz-bindings", "time-scalaz-bindings")
    .dependsOn(time)
    .settings(description := "Scalaz bindings for time")
    .settings(
      libraryDependencies +=
        scalaz
    )

  val timeParent = proj("time-parent", ".")
    .settings(publishArtifact := false)
    .aggregate(time, scalazBindings)

}

object Deps {
  object Scala {
    val current = "2.11.4"
    val prev = "2.10.4"
  }
  val jodaTime = "joda-time" % "joda-time" % "2.6"
  val jodaConvert = "org.joda" % "joda-convert" % "1.7"
  val scalaz = "org.scalaz" %% "scalaz-core" % "7.0.6"
}
