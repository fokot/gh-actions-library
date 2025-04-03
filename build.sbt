Global / onChangedBuildSource := ReloadOnSourceChanges

val scala3Version = "3.6.4"

val credentialsViaEnvVariables = for {
  username <- sys.env.get("MAVEN_WRITE_USERNAME")
  password <- sys.env.get("MAVEN_WRITE_PASSWORD")
} yield Credentials("Sonatype Nexus Repository Manager", "kodiak-helped-fawn.ngrok-free.app", username, password)

ThisBuild / credentials += credentialsViaEnvVariables.getOrElse(Credentials(Path.userHome / ".sbt" / ".credentials"))


ThisBuild / organization := "com.fokot2"



lazy val root = project
  .in(file("."))
  .settings(
    name := "gh-actions-library",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.0.0" % Test
    ),
    publishTo := {
      val nexus = "https://kodiak-helped-fawn.ngrok-free.app/nexus/content/repositories/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "snapshots/")
      else
        Some("releases" at nexus + "releases/")
    },
  )
