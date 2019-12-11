val jodaTime = "joda-time" % "joda-time" % "2.6"
val jodaConvert = "org.joda" % "joda-convert" % "1.7"
val scalaz = "org.scalaz" %% "scalaz-core" % "7.2.29"

val scalaCurrent = "2.13.1"
val scalaPrev = "2.12.10"
val scalaAged = "2.11.12"

enablePlugins(ReleasePlugin)

val basicSettings = Seq(
  organization := "com.thenewmotion",
  crossScalaVersions := Seq(scalaCurrent, scalaPrev, scalaAged),
  scalaVersion := scalaCurrent,
  releaseCrossBuild := true,
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
)

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
