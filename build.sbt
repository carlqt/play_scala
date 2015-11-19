name := """play_scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "com.lihaoyi" % "ammonite-repl" % "0.4.8" % "test" cross CrossVersion.full,
  "org.sorm-framework" % "sorm" % "0.3.19"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
dependencyOverrides += "org.scala-lang" % "scala-compiler" % scalaVersion.value
routesGenerator := InjectedRoutesGenerator
initialCommands in (Test, console) := """ammonite.repl.Repl.run("")"""
