package days

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day04Test {
    @Test
    fun `part 1 password criteria`() {
        // Note: day input is irrelevant
        val day04 = Day04("0-1000000")
        assertThat(day04.isValidPassword("111111")).isTrue()
        assertThat(day04.isValidPassword("223450")).isFalse()
        assertThat(day04.isValidPassword("123789")).isFalse()
        assertThat(day04.isValidPassword("11111")).isFalse()
        assertThat(day04.isValidPassword("11111a")).isFalse()
    }
}