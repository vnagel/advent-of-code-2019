package util

import java.io.File

object InputReader {

    fun getInputAsString(day: Int): String {
        return getInputFile(day).readText()
    }

    fun getInputAsList(day: Int): List<String> {
        return getInputFile(day).readLines()
    }
    private fun getInputFile(day: Int): File {
        val filename = String.format("input_day_%02d.txt", day);
        return File(javaClass.classLoader.getResource(filename).toURI())
    }
}
