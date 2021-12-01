import java.io.File

fun String.toIntArray(): IntArray {
    return this.lines().map { it.toInt() }.toIntArray()
}

/**
 * Read input.txt from package for given [day] as [String]
 */
fun readInput(day: Int): String {
    return File("src/main/kotlin/day${day.toString().padStart(2, '0')}", "input.txt").readText()
}