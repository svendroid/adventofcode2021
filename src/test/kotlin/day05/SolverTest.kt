package day05

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class SolverTest {

    val input = """
        0,9 -> 5,9
        8,0 -> 0,8
        9,4 -> 3,4
        2,2 -> 2,1
        7,0 -> 7,4
        6,4 -> 2,0
        0,9 -> 2,9
        3,4 -> 1,4
        0,0 -> 8,8
        5,5 -> 8,2
    """.trimIndent()

    @Test
    fun solvePart1() {
        val result = Solver().solvePart1(input)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun solvePart2() {
        val result = Solver().solvePart2(input)
        assertThat(result).isEqualTo(12)
    }
}