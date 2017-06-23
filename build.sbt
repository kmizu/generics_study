organization := "com.github.kmizu"

name := "generics_study"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.7" % "test",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

initialCommands in console += {
  Iterator().map("import "+).mkString("\n")
}
