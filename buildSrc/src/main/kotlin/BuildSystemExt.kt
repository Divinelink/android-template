import org.gradle.api.Project
import java.io.File

fun Project.buildSystemFile(buildSystemFile: String): File {
  val buildSystemDir = File("$rootDir/buildsystem")
  return File(buildSystemDir, buildSystemFile)
}
