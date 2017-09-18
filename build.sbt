lazy val root = (project in file("."))
  .settings(
    name         := "scalapb-mcve",
    scalaVersion := "2.12.3"
  )

PB.pythonExe := "C:\\Python27\\python.exe"
PB.protocVersion := "-v320"
PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

libraryDependencies += "com.trueaccord.scalapb" %% "scalapb-runtime" % com.trueaccord.scalapb.compiler.Version.scalapbVersion % "protobuf"
libraryDependencies += "com.google.api.grpc" % "googleapis-common-protos" % "0.0.3" % "protobuf"

