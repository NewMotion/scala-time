import sbt._
import Keys._

object TimeBuild extends Build {
  import Deps._

  lazy val basicSettings = Seq(
    organization := "com.thenewmotion",

    crossScalaVersions := Versions.crossScala,

    scalaVersion := Versions.scala,

    crossVersion := CrossVersion.full,

    resolvers ++= Seq(
      "Releases"  at "http://nexus.thenewmotion.com/content/repositories/releases-public",
      "Snapshots" at "http://nexus.thenewmotion.com/content/repositories/snapshots"
    ),

    scalacOptions := Seq(
      "-encoding", "UTF-8",
      "-unchecked",
      "-deprecation"
    )
  )

  lazy val publishSettings = Seq(
    publishTo <<= version { (v: String) =>
      val nexus = "http://nexus.thenewmotion.com/content/repositories/"
      if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "snapshots")
      else                             Some("releases"  at nexus + "releases")
    },
    publishMavenStyle := true,
    pomExtra :=
      <licenses>
        <license>
          <name>Apache License, Version 2.0</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0</url>
          <distribution>repo</distribution>
        </license>
      </licenses>,
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
  )


  lazy val root = Project(id= "root", base = file(".")) aggregate (time, scalazBindings)

  lazy val time = Project(id = "time", base = file("time"))
    .settings(basicSettings: _*)
    .settings(publishSettings: _*)
    .settings(description  := "Scala wrapper around joda time")
    .settings(
      libraryDependencies ++= Seq(
        jodaTime, jodaConvert
      )
    )

  lazy val scalazBindings = Project(id = "scalaz-bindings", base = file("time-scalaz-bindings"))
    .dependsOn(time)
    .settings(basicSettings: _*)
    .settings(publishSettings: _*)
    .settings(description  := "Scalaz bindings for time")
    .settings(
      libraryDependencies <++= (scalaVersion) { v: String =>
        if (v.startsWith("2.10")) {
          Seq(scalaz, scalaCompiler_2_10)
        } else {
          Seq(scalaz, scalaCompiler_2_11)
        }
      }
    )
}

object Deps {
  object Versions {
    val scala = "2.11.1"
    val crossScala = Seq("2.11.1", "2.10.4")
  }
  val scalaz        = "org.scalaz"      %% "scalaz-core"    % "7.0.6"
  val jodaTime      = "joda-time"       %  "joda-time"      % "2.4"
  val jodaConvert   = "org.joda"        %  "joda-convert"   % "1.6"
  val scalaCompiler_2_10 = "org.scala-lang"  %  "scala-compiler" % "2.10.4"
  val scalaCompiler_2_11 = "org.scala-lang"  %  "scala-compiler" % "2.11.1"
}