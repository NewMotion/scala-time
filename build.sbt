val basicSettings = Seq(
  organization := "com.thenewmotion",
  crossScalaVersions := Seq(tnm.ScalaVersion.curr, tnm.ScalaVersion.prev, tnm.ScalaVersion.aged),
  scalaVersion := tnm.ScalaVersion.curr,
  releaseCrossBuild := true,
  publishMavenStyle := true,
  scalacOptions := Seq(
    "-encoding", "UTF-8",
    "-unchecked",
    "-deprecation",
    "-feature",
    "-Xlog-reflective-calls"
  ),
  licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
)

def proj(name: String, dir: String) = Project(id = name, base = file(dir))
  .settings(basicSettings: _*)
  .enablePlugins(OssLibPlugin)

val jodaTime = "joda-time" % "joda-time" % "2.6"
val jodaConvert = "org.joda" % "joda-convert" % "1.7"
val scalaz = "org.scalaz" %% "scalaz-core" % "7.2.29"

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
