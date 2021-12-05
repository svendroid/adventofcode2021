package day05

import readInput
import kotlin.math.absoluteValue
import kotlin.math.atan
import kotlin.math.max
import kotlin.math.min

fun main() {
    val solver = Solver()

    val input = readInput(5).trim()

    println("Part1: ${solver.solvePart1(input)}")
    println("Part2: ${solver.solvePart2(input)}")
}

data class Line(val start: Point, val end: Point) {

}

data class Point(val x: Int, val y: Int)

class Solver {

    fun solvePart1(input: String): Int {
        val lines = input.trim().lines().map {
            val points = it.split(" -> ")
            Line(start = points[0].toPoint(), end = points[1].toPoint())
        }

        val numRows = lines.maxOf { max(it.start.x, it.end.x) } + 1
        val numColumns = lines.maxOf { max(it.start.y, it.end.y) } + 1

        val vents = Array(numColumns) { IntArray(numRows) { 0 } }

        vents.printToConsole()

        for (line in lines) {

            if (line.end.y == line.start.y) {
                for (x in min(line.start.x, line.end.x)..max(line.start.x, line.end.x)) {
                    vents[line.start.y][x] += 1
                }
            } else if (line.end.x == line.start.x) {
                for (y in min(line.start.y, line.end.y)..max(line.start.y, line.end.y)) {
                    vents[y][line.start.x] += 1
                }
            }
        }

        vents.printToConsole()

        var dangerousCount = 0
        for (rows in vents) {
            for (value in rows) {
                if (value >= 2) {
                    dangerousCount += 1
                }
            }
        }

        return dangerousCount
    }

    fun solvePart2(input: String): Int {
        val lines = input.trim().lines().map {
            val points = it.split(" -> ")
            Line(start = points[0].toPoint(), end = points[1].toPoint())
        }

        val numRows = lines.maxOf { max(it.start.x, it.end.x) } + 1
        val numColumns = lines.maxOf { max(it.start.y, it.end.y) } + 1

        val vents = Array(numColumns) { IntArray(numRows) { 0 } }

        for (line in lines) {

            val maxY = max(line.start.y, line.end.y)
            val minY = min(line.start.y, line.end.y)
            val maxX = max(line.start.x, line.end.x)
            val minX = min(line.start.x, line.end.x)

            val degree = Math.toDegrees(atan((maxY - minY).toFloat() / (maxX - minX).toFloat()).toDouble()).toInt()

            if (line.end.y == line.start.y) {
                for (x in minX..maxX) {
                    vents[line.start.y][x] += 1
                }
            } else if (line.end.x == line.start.x) {
                for (y in minY..maxY) {
                    vents[y][line.start.x] += 1
                }
            } else if (degree == 45) {
                var xStart = line.start.x
                val xEnd = line.end.x

                var yStart = line.start.y
                val yEnd = line.end.y

                val xRange = xEnd - xStart
                val yRange = yEnd - yStart

                val xSign = if (xRange < 0) -1 else 1
                val ySign = if (yRange < 0) -1 else 1

                for (i in 0 .. xRange.absoluteValue) {
                    vents[yStart][xStart] += 1
                    xStart += xSign
                    yStart += ySign
                }
            }
        }

        var dangerousCount = 0
        for (rows in vents) {
            for (value in rows) {
                if (value >= 2) {
                    dangerousCount += 1
                }
            }
        }

        return dangerousCount
    }

    fun String.toPoint(): Point {
        val nums = this.split(",").map { it.toInt() }
        return Point(nums.first(), nums.last())
    }

    fun Array<IntArray>.printToConsole(){
        println()
        for (rows in this) {
            for (value in rows) {
                print("$value ")
            }
            println()
        }
        println()
    }

}