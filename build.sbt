import sbt._
import Keys.{fork, javaOptions, _}
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain

val org = "com.some.org"
val scalaV = "2.12.13"

ThisBuild / version := "0.0.1"
ThisBuild / scalaVersion := scalaV

lazy val root = (project in file(".")).settings(
  name := "trial-sbt",
  organization := org,
  libraryDependencies ++= Seq(
    Dependencies.SparkSql % "provided",
    Dependencies.SparkDaria,
    Dependencies.SparkFastTests % "test",
    Dependencies.ScalaTests % "test",
    Dependencies.Aws
  ),
  s3credentials := DefaultAWSCredentialsProviderChain.getInstance(),
  s3region := com.amazonaws.services.s3.model.Region.US_Standard,
  publish / skip := true, // publish disabled
  publishTo := Some(
    s3resolver.value(
      "Testing",
      s3(s"test-bucket/to-be-decided")
    )
  ),
  testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-oD"),
  Test / fork := true,
  javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
)


