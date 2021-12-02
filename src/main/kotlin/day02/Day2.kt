fun main() {
    val solver = Day2()

    val input = readInput(2)

    println("Part1: ${solver.solvePart1(input)}")
    println("Part2: ${solver.solvePart2(input)}")
}

class Day2 {

    private fun parseCommands(input: String): List<Pair<String, Int>> {
        return input.trim().lines().map { it.split(" ") }.map { Pair(it[0], it[1].toInt()) }
    }

    fun solvePart1(input: String): Int {
        val commands = parseCommands(input)
        var horizontalPosition = 0
        var depth = 0
        for (command in commands) {
            when(command.first){
                "forward" -> horizontalPosition += command.second
                "down" -> depth += command.second
                "up" -> depth -= command.second
            }
        }
        return horizontalPosition * depth
    }

    fun solvePart2(input: String): Int {
        val commands = parseCommands(input)
        var horizontalPosition = 0
        var depth = 0
        var aim = 0
        for (command in commands) {
            when(command.first){
                "forward" -> {
                    horizontalPosition += command.second
                    depth += aim * command.second
                }
                "down" -> aim += command.second
                "up" -> aim -= command.second
            }
        }
        return horizontalPosition * depth
    }

}

