lazy val root = (project in file("."))
  .settings(
    name := "scalatest-embedmongo",
    organization := "com.github.simplyscala",
    description := "API to use embeded mongoDb database for testing in Scala",
    version := "1.0.0",
    scalaVersion := "2.13.8",
    crossScalaVersions := Seq("2.11.12", "2.12.8", "2.13.8"),
    scalacOptions := Seq("-deprecation", "-feature"),
    libraryDependencies ++= Seq(
      "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "2.0.0",
      "org.scalatest" %% "scalatest" % "3.2.11" % Test,
      "org.mongodb.scala" %% "mongo-scala-driver" % "2.7.0" % "test"
    ),
    parallelExecution := false,
    publishMavenStyle := true,
    Test / publishArtifact := false,
    pomIncludeRepository := { _ => false },
    pomExtra in Global := {
      <url>https://github.com/SimplyScala/scalatest-embedmongo</url>
        <licenses>
          <license>
            <name>GPLv3</name>
            <url>http://www.gnu.org/licenses/gpl-3.0.html</url>
            <distribution>repo</distribution>
          </license>
        </licenses>
        <scm>
          <url>git@github.com:SimplyScala/scalatest-embedmongo.git</url>
          <connection>scm:git:git@github.com:SimplyScala/scalatest-embedmongo.git</connection>
        </scm>
        <developers>
          <developer>
            <id>ugobourdon</id>
            <name>bourdon.ugo@gmail.com</name>
            <url>https://github.com/ubourdon</url>
          </developer>
          <developer>
            <id>tg44</id>
            <name>tg44</name>
            <url>https://github.com/tg44</url>
          </developer>
        </developers>
    },
    publishTo := {
      val nexus = "https://nexus.oc.systems:9099/nexus/content/repositories/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    },
    scalacOptions ++= Seq(
    "-target:jvm-1.11",
    "-encoding", "UTF-8",
    "-deprecation",
    "-unchecked",
    "-Ywarn-dead-code")
  )
