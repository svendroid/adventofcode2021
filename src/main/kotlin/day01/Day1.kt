package day01

import readInput
import toIntArray

fun main() {
    val day1 = Day1()

    val input = readInput(1).trim().toIntArray()

    val resultPart1 = day1.solvePart1(input)
    println("Result part1: $resultPart1")

    val resultPart2 = day1.solvePart2(input)
    println("Result part2: $resultPart2")
}

class Day1 {

    fun solvePart1(inputIntArray: IntArray): Int {
        var result = 0
        for (i in 1 until inputIntArray.size) {
            if (inputIntArray[i - 1] < inputIntArray[i]) {
                result += 1
            }
        }
        return result
    }

    fun solvePart2(inputIntArray: IntArray): Int {
        val result =
            inputIntArray
                .copyOfRange(0, inputIntArray.size - 2)
                .mapIndexed { index, i -> inputIntArray[index] + inputIntArray[index + 1] + inputIntArray[index + 2] }
                .toIntArray()

        return solvePart1(result)
    }

}

