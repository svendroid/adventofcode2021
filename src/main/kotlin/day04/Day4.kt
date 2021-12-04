package day04

import readInput

fun main() {
    val solver = Solver()

    val input = readInput(4).trim()

    println("Part1: ${solver.solvePart1(input)}")
    println("Part2: ${solver.solvePart2(input)}")
}

class Solver {

    fun solvePart1(input: String): Int {
        val inputClean = input.trim().lines()

        val draws = inputClean.first().split(",").map { it.toInt() }

        val boards = createBoards(inputClean)

        val boardsResults = mutableListOf<Pair<MutableList<Int>, MutableList<Int>>>()
        boards.forEachIndexed { index, board ->
            boardsResults.add(index, Pair(mutableListOf(0, 0, 0, 0, 0), mutableListOf(0, 0, 0, 0, 0)))
        }

        val drawedNumbers = mutableListOf<Int>()
        for (draw in draws) {
            drawedNumbers.add(draw)
            boards.forEachIndexed { boardIdx, board ->
                board.forEachIndexed { rowIdx, row ->

                    val idx = row.indexOf(draw)
                    if (idx > -1) {
                        boardsResults[boardIdx].first[rowIdx] += 1

                        boardsResults[boardIdx].second[idx] += 1

                        if (boardsResults[boardIdx].first[rowIdx] == 5 || boardsResults[boardIdx].second[idx] == 5) {
                            return calcResultFor(drawedNumbers, board)
                        }
                    }
                }

            }

        }

        return -1
    }

    fun solvePart2(input: String): Int {
        val inputClean = input.trim().lines()

        val draws = inputClean.first().split(",").map { it.toInt() }

        val boards = createBoards(inputClean)

        val boardsResults = mutableListOf<Pair<MutableList<Int>, MutableList<Int>>>()

        boards.forEachIndexed { index, board ->
            boardsResults.add(index, Pair(mutableListOf(0, 0, 0, 0, 0), mutableListOf(0, 0, 0, 0, 0)))
        }

        val winningBoardsIdx = mutableListOf<Int>()
        val drawedNumbers = mutableListOf<Int>()
        for (draw in draws) {
            drawedNumbers.add(draw)
            boards.forEachIndexed { boardIdx, board ->
                if (winningBoardsIdx.size == boards.size) {
                    return calcResultFor(drawedNumbers, boards[winningBoardsIdx.last()])
                } else if (!winningBoardsIdx.contains(boardIdx)) {
                    board.forEachIndexed { rowIdx, row ->

                        val idx = row.indexOf(draw)
                        if (idx > -1) {
                            boardsResults[boardIdx].first[rowIdx] += 1

                            boardsResults[boardIdx].second[idx] += 1

                            if (boardsResults[boardIdx].first[rowIdx] == 5 || boardsResults[boardIdx].second[idx] == 5) {
                                winningBoardsIdx.add(boardIdx)
                            }
                        }
                    }
                }
            }

        }

        return -1
    }

    private fun createBoards(input: List<String>): MutableList<List<List<Int>>> {
        val boardsLines = input.subList(fromIndex = 1, toIndex = input.size)

        val boards = mutableListOf<List<List<Int>>>()

        boardsLines.windowed(size = 6, step = 6).map { lines ->
            val board = mutableListOf<List<Int>>()
            for (line in lines) {
                if (line.isNotEmpty()) {
                    board.add(line.trim().split(" ").filter { it.isNotEmpty() }.map {
                        it.toInt()
                    })
                }
            }
            boards.add(board)
        }

        return boards
    }

    private fun calcResultFor(drawedNumbers: MutableList<Int>, board: List<List<Int>>): Int {
        return board.flatten().filter { !drawedNumbers.contains(it) }.sum() * drawedNumbers.last()
    }
}