package days

class Day01 : Day(1) {

    override fun getPartOneSolution(): Any {
        return inputList.take(2)
            .map { it.toUpperCase() }
            .joinToString(" ")
    }

    override fun getPartTwoSolution(): Any {
        return inputString.split("\n")
            .filterNot { it.isEmpty() }
            .map { it.toUpperCase() }
            .last()
    }
}
