package util

import days.Day
import org.reflections.Reflections
import kotlin.math.max
import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

@ExperimentalTime
object Runner {

    private val reflections = Reflections("days")

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isNotEmpty()) {
            val day = try {
                args[0].toInt()
            }
            catch (e: NumberFormatException) {
                printError("Day argument must be an integer")
                return
            }

            val dayClass = getAllDayClasses()?.find { getDayNumber(it.simpleName) == day }
            if (dayClass != null) {
                printDay(dayClass)
            }
            else {
                printError("Day $day not found")
            }
        }
        else {
            val allDayClasses = getAllDayClasses()
            if (allDayClasses != null) {
                allDayClasses.forEach { printDay(it) }
            }
            else {
                printError("Couldn't find day classes - make sure you're in the right directory and try building again")
            }
        }
    }

    private fun getAllDayClasses(): MutableSet<Class<out Day>>? {
        return reflections.getSubTypesOf(Day::class.java)
    }

    private fun printDay(dayClass: Class<out Day>) {
        println("\n=== DAY ${getDayNumber(dayClass.simpleName)} ===")
        val day = dayClass.constructors[0].newInstance() as Day

        val partOneSolution = measureTimedValue { day.getPartOneSolution() }
        val partTwoSolution = measureTimedValue { day.getPartTwoSolution() }
        printParts(partOneSolution, partTwoSolution)
    }

    private fun printParts(partOneSolution: TimedValue<Any>, partTwoSolution: TimedValue<Any>) {
        val padding = max(partOneSolution.value.toString().length, partTwoSolution.value.toString().length) + 14        // 14 is 8 (length of 'Part 1: ' + 6 more)
        println("Part 1: ${partOneSolution.value}".padEnd(padding, ' ') + "(${partOneSolution.duration})")
        println("Part 2: ${partTwoSolution.value}".padEnd(padding, ' ') + "(${partTwoSolution.duration})")
    }

    private fun printError(message: String) {
        System.err.println("ERROR\n$message")
    }

    private fun getDayNumber(dayClassName: String) = dayClassName.replace("Day", "").toInt()
}
