package days

import com.google.common.truth.Truth
import org.junit.jupiter.api.Test

class Day03Test {
    @Test
    fun `input 1 part 1`() {
        val input = "R75,D30,R83,U83,L12,D49,R71,U7,L72\n" +
                "U62,R66,U55,R34,D71,R55,D58,R83"
        val day03 = Day03(input)
        val actual = day03.getPartOneSolution()
        val expected = 159
        Truth.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `input 2 part 1`() {
        val input = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\n" +
                "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
        val day03 = Day03(input)
        val actual = day03.getPartOneSolution()
        val expected = 135
        Truth.assertThat(actual).isEqualTo(expected)
    }

}