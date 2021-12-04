package day03

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class SolverTest {

    val input = """
        00100
        11110
        10110
        10111
        10101
        01111
        00111
        11100
        10000
        11001
        00010
        01010
    """.trimIndent()

    @Test
    internal fun solverPart1() {
        //When
        val result = Solver().solvePart1(input)

        //Then
        assertThat(result).isEqualTo(198)
    }


    @Test
    internal fun solverPart2() {
        //When
        val result = Solver().solvePart2(input)

        //Then
        assertThat(result).isEqualTo(230)
    }
}