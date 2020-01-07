package days

class Day04(inputString: String) : Day(inputString) {
    private val passwordRange = inputString.split('-').map { it.trim().toInt() }

    override fun getPartOneSolution(): Any {
        return countPasswords(::isValidPart01Password)
    }

    override fun getPartTwoSolution(): Any {
        return countPasswords(::isValidPart02Password)
    }

    private fun countPasswords(isValidPassword: (String) -> Boolean): Int {
        return (passwordRange[0]..passwordRange[1]).count { isValidPassword(it.toString()) }
    }

    fun isValidPart01Password(password: String): Boolean {
        return password.length == 6 && password.all { it.isDigit() } && password.toInt() >= passwordRange[0] &&
                password.toInt() <= passwordRange[1] && password.toSet().size < 6 && password.zipWithNext().all { it.first <= it.second }
    }

    fun isValidPart02Password(password: String): Boolean {
        return isValidPart01Password(password) && password.any{letter -> password.count{it == letter} == 2}
    }
}
