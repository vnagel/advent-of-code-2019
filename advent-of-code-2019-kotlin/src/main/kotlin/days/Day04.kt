package days

class Day04(inputString: String) : Day(inputString) {
    private val passwordRange = inputString.split('-').map{it.trim().toInt()}

    override fun getPartOneSolution(): Any {
        return (passwordRange[0]..passwordRange[1]).count{isValidPassword(it.toString())}
    }

    override fun getPartTwoSolution(): Any {
        return ""
    }

    fun isValidPassword(password: String): Boolean{
        return password.length == 6 && password.all { it.isDigit() } && password.toInt() >= passwordRange[0] &&
                password.toInt() <= passwordRange[1] && password.toSet().size < 6 && password.zipWithNext().all{it.first <= it.second}
    }
}
