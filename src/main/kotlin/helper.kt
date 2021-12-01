fun String.toIntArray(): IntArray {
    return this.lines().map { it.toInt() }.toIntArray()
}