Global / onChangedBuildSource := ReloadOnSourceChanges

val scala3Version = "3.6.4"
val scala2Version = "2.13.16"

val credentialsViaEnvVariables = for {
  username <- sys.env.get("MAVEN_WRITE_USERNAME")
  password <- sys.env.get("MAVEN_WRITE_PASSWORD")
} yield Credentials("Sonatype Nexus Repository Manager", "repository.cloudfarms.online", username, password)

ThisBuild / credentials += credentialsViaEnvVariables.getOrElse(Credentials(Path.userHome / ".sbt" / ".credentials"))


ThisBuild / organization := "com.fokot"

lazy val root = project
  .in(file("."))
  .settings(
    name := "gh-actions-library",
    version := "0.3.0-SNAPSHOT",
    scalaVersion := scala3Version,
    crossScalaVersions := Seq(scala3Version, scala2Version),
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.0.0" % Test
    ),
    publishTo := {
      val nexus = "https://repository.cloudfarms.online/repository/maven-workshop/"
      if (isSnapshot.value)
        Some("snapshots" at nexus)
      else
        Some("releases" at nexus)
    },
  )
