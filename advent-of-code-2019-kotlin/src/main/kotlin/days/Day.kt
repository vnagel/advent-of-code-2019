package days

import java.io.File

abstract class Day(protected val inputString: String) {

    protected val inputList: List<String> = inputString.split("\n")

    abstract fun getPartOneSolution(): Any

    abstract fun getPartTwoSolution(): Any
}
