package days

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day03Test {
    @Test
    fun `part 1 input 1`() {
        val input = "R75,D30,R83,U83,L12,D49,R71,U7,L72\n" +
                "U62,R66,U55,R34,D71,R55,D58,R83"
        val day03 = Day03(input)
        val actual = day03.getPartOneSolution()
        val expected = 159
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `part 1 input 2`() {
        val input = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\n" +
                "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
        val day03 = Day03(input)
        val actual = day03.getPartOneSolution()
        val expected = 135
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `part 2 input 1`() {
        val input = "R75,D30,R83,U83,L12,D49,R71,U7,L72\n" +
                "U62,R66,U55,R34,D71,R55,D58,R83"
        val day03 = Day03(input)
        val actual = day03.getPartTwoSolution()
        val expected = 610
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `part 2 input 2`() {
        val input = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\n" +
                "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
        val day03 = Day03(input)
        val actual = day03.getPartTwoSolution()
        val expected = 410
        assertThat(actual).isEqualTo(expected)
    }

}