name := "wiki"
version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
    jdbc,
    filters,
    "org.postgresql" % "postgresql" % "9.4.1209.jre7"
)

// Docker configuration
import com.typesafe.sbt.packager.docker.Cmd
mappings in Docker += file("env-build.sh") -> "/opt/env-build.sh"
packageName in Docker := name.value
version in Docker := version.value
dockerCommands := Seq(
  Cmd("FROM", "openjdk:8"),
  Cmd("MAINTAINER", "Adel Abdelhak <adel.abdelhak@leansys.fr>"),
  Cmd("COPY", "opt /opt"),
  Cmd("RUN", "chmod +x /opt/env-build.sh"),
  Cmd("EXPOSE", "9010"),
  Cmd("CMD", s"/opt/env-build.sh ${packageName.value}")
)