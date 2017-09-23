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

// Generate scala classes for all protos under "google/type"
PB.protoSources in Compile += PB.externalIncludePath.value / "google" / "type"

// Since protoSources is passed to the include path, and externalIncludePath is already in there
// we need to remove this extra path to prevent duplicate compilation.
PB.includePaths in Compile -= PB.externalIncludePath.value / "google" / "type"

// So it compiles google-apis
PB.protoSources in Compile += PB.externalIncludePath.value

libraryDependencies += "com.trueaccord.scalapb" %% "scalapb-runtime" % com.trueaccord.scalapb.compiler.Version.scalapbVersion % "protobuf"
libraryDependencies += "com.google.api.grpc" % "googleapis-common-protos" % "0.0.3" % "protobuf"

