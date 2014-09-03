import sbt._
import Keys._
import sbtrelease.ReleasePlugin._

object TimeBuild extends Build {

  import Deps._

  lazy val nexus = "http://nexus.thenewmotion.com/content/repositories/"

  lazy val nexusReleases = nexus + "releases-public"

  lazy val nexusSnapshots = nexus + "snapshots-public"

  lazy val basicSettings = Seq(
    organization := "com.thenewmotion",
    crossScalaVersions := Seq(scala_2_10, scala_2_11),
    scalaVersion := scala_2_11,
    ReleaseKeys.crossBuild := true,
    resolvers ++= Seq(
      "Releases" at nexusReleases,
      "Snapshots" at nexusSnapshots
    ),
    scalacOptions := Seq(
      "-encoding", "UTF-8",
      "-unchecked",
      "-deprecation"
    )
  )

  lazy val publishSettings = Seq(
    publishTo := Some("snapshots" at (if (isSnapshot.value) nexusSnapshots else nexusReleases)),
    publishMavenStyle := true,
    licenses +=("Apache License, Version 2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
  ) ++ releaseSettings

  def proj(name: String, dir: String) = Project(id = name, base = file(dir))
    .settings(basicSettings: _*)
    .settings(publishSettings: _*)

  lazy val timeParent = proj("time-parent", ".")
    .settings(publishArtifact := false)
    .aggregate(time, scalazBindings)

  lazy val time = proj("time", "time")
    .settings(description := "Scala wrapper around Joda-time")
    .settings(
      libraryDependencies ++= Seq(
        jodaTime,
        jodaConvert
      )
    )

  lazy val scalazBindings = proj("time-scalaz-bindings", "time-scalaz-bindings")
    .dependsOn(time)
    .settings(description := "Scalaz bindings for time")
    .settings(
      libraryDependencies <++= scalaVersion { v: String =>
        Seq(
          scalaz,
          if (v == scala_2_10) scalaCompiler_2_10 else scalaCompiler_2_11
        )
      }
    )
}

object Deps {
  val scala_2_11 = "2.11.2"
  val scala_2_10 = "2.10.4"

  val scalaz = "org.scalaz" %% "scalaz-core" % "7.0.6"
  val jodaTime = "joda-time" % "joda-time" % "2.4"
  val jodaConvert = "org.joda" % "joda-convert" % "1.7"
  val scalaCompiler_2_10 = "org.scala-lang" % "scala-compiler" % scala_2_10
  val scalaCompiler_2_11 = "org.scala-lang" % "scala-compiler" % scala_2_11
}