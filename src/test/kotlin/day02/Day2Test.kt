package day02

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class Day2Test {

    val input = """forward 5
            |down 5
            |forward 8
            |up 3
            |down 8
            |forward 2""".trimMargin()

    @Test
    fun `solvePart1 should solve example input`() {
        //When
        val result = Day2().solvePart1(input)

        //Then
        assertThat(result).isEqualTo(150)
    }

    @Test
    fun `solvePart2 should solve example input`() {
        //When
        val result = Day2().solvePart2(input)

        //Then
        assertThat(result).isEqualTo(900)
    }
}