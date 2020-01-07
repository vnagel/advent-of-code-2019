package days

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day04Test {
    @Test
    fun `part 1 password criteria`() {
        // Note: day input is irrelevant
        val day04 = Day04("0-1000000")
        assertThat(day04.isValidPart01Password("111111")).isTrue()
        assertThat(day04.isValidPart01Password("223450")).isFalse()
        assertThat(day04.isValidPart01Password("123789")).isFalse()
        assertThat(day04.isValidPart01Password("11111")).isFalse()
        assertThat(day04.isValidPart01Password("11111a")).isFalse()
    }
    @Test
    fun `part 2 password criteria`() {
        // Note: day input is irrelevant
        val day04 = Day04("0-1000000")
        assertThat(day04.isValidPart02Password("111111")).isFalse()
        assertThat(day04.isValidPart02Password("123444")).isFalse()
        assertThat(day04.isValidPart02Password("111122")).isTrue()
    }
}