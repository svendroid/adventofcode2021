package day01

import Day1
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

import toIntArray

internal class Day1Test {

    @Test
    fun `solvePart1 should solve example input`() {
        //Given
        val input = """199
            |200
            |208
            |210
            |200
            |207
            |240
            |269
            |260
            |263
        """.trimMargin()

        //When
        val result = Day1().solvePart1(inputIntArray = input.toIntArray())

        //Then
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `solvePart2 should solve example input`() {
        //Given
        val input = """607
            |618
            |618
            |617
            |647
            |716
            |769
            |792
        """.trimMargin()

        //When
        val result = Day1().solvePart2(input.toIntArray())

        //Then
        assertThat(result).isEqualTo(5)
    }
}