package util

import org.junit.jupiter.api.Test
import com.google.common.truth.Truth.assertThat

class InputReaderTest {
    @Test
    fun `getInputAsString(1) returns expected string`() {
        val actual = InputReader.getInputAsString(1)
        val expected = "this\nis\na\ntest input\nfile\n"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `getInputAsList(1) returns expected list`() {
        val actual : List<String> = InputReader.getInputAsList(1)
        val expected : List<String> = arrayListOf("this", "is", "a", "test input", "file")
        assertThat(actual).containsExactlyElementsIn(expected)
    }

}