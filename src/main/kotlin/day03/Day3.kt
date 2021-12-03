fun main() {
    val solver = Solver()

    val input = readInput(3).trim()

    println("Part1: ${solver.solvePart1(input)}")
    println("Part2: ${solver.solvePart2(input)}")
}

class Solver {

    fun solvePart1(input: String): Int {

        val lineLength = input.lines().first().length
        val counts = IntArray(lineLength)

        input.lines().forEach { it ->
            it.toCharArray().forEachIndexed { idx, element ->
                counts[idx] += element.digitToInt()
            }
        }

        var gammaBinaryString = ""
        for (count in counts) {
            if (count < input.lines().size / 2) {
                gammaBinaryString += 0
            } else {
                gammaBinaryString += 1
            }
        }
        val gamma = gammaBinaryString.toInt(2)

        println("gamma: $gammaBinaryString -> $gamma")

        var epsilonBinaryString = ""
        for (count in counts) {
            if (count < input.lines().size / 2) {
                epsilonBinaryString += 1
            } else {
                epsilonBinaryString += 0
            }
        }

        val epsilon = epsilonBinaryString.toInt(2)
        println("epsilon: $epsilonBinaryString -> $epsilon")

        return gamma * epsilon
    }

    fun solvePart2(inputStr: String): Int {
        val input = inputStr.trim()

        val oxygen = filterForOxygenGeneratorRating(input.lines()).first().toInt(2)
        println("oxygen $oxygen")

        val co2 = filterForCo2ScrubberRating(input.lines()).first().toInt(2)
        println("CO2 $co2")

        return oxygen * co2
    }

    fun filterForOxygenGeneratorRating(inputs: List<String>, idx: Int = 0): List<String> {
        if (inputs.size == 1 || inputs.first().length == idx) {
            return inputs
        } else {
            val count = inputs.map { it.toCharArray()[idx].digitToInt() }.sum()
            return if (count < inputs.size / 2f) {
                filterForOxygenGeneratorRating(inputs.filter { it.toCharArray()[idx].digitToInt() == 0 }, idx = idx + 1)
            } else {
                filterForOxygenGeneratorRating(inputs.filter { it.toCharArray()[idx].digitToInt() == 1 }, idx = idx + 1)
            }
        }
    }

    fun filterForCo2ScrubberRating(inputs: List<String>, idx: Int = 0): List<String> {
        if (inputs.size == 1 || inputs.first().length == idx) {
            return inputs
        } else {
            val count = inputs.map { it.toCharArray()[idx].digitToInt() }.sum()
            return if (count < inputs.size / 2f) {
                filterForCo2ScrubberRating(inputs.filter { it.toCharArray()[idx].digitToInt() == 1 }, idx = idx + 1)
            } else {
                filterForCo2ScrubberRating(inputs.filter { it.toCharArray()[idx].digitToInt() == 0 }, idx = idx + 1)
            }
        }
    }

}

