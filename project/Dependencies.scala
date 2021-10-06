import sbt._

object Dependencies {

  val Aws = "com.amazonaws" % "aws-java-sdk-core" % Version.Aws

  val SparkSql = "org.apache.spark" %% "spark-sql" % Version.Spark
  val SparkDaria = "com.github.mrpowers" %% "spark-daria" % "0.38.2",
  val SparkFastTests = "com.github.mrpowers" %% "spark-fast-tests" % "0.21.3"
  val ScalaTests = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

  object Version {
    val Aws = "1.11.243"
    val Spark = "3.1.1"
  }

}
