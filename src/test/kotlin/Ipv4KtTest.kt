import org.example.isValidIPv4
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Ipv4KtTest {

    @Test
    fun `valid IP should return true`() {
        // Given
        val ip = "192.168.0.1"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertTrue(result)
    }

    @Test
    fun `IP with 3 segments should return false`() {
        // Given
        val ip = "192.168.1"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with 5 segments should return false`() {
        // Given
        val ip = "10.0.0.1.5"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `empty IP should return false`() {
        // Given
        val ip = ""

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with character segment should return false`() {
        // Given
        val ip = "192.168.1.a"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with letters only should return false`() {
        // Given
        val ip = "abc.def.ghi.jkl"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with segment greater than 255 should return false`() {
        // Given
        val ip = "123.456.78.90"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with negative number should return false`() {
        // Given
        val ip = "12.34.56.-7"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with leading zeros should return false`() {
        // Given
        val ip = "01.2.3.4"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with multiple leading zeros should return false`() {
        // Given
        val ip = "1.02.003.4"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with segment 0 should be valid`() {
        // Given
        val ip = "0.0.0.0"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertTrue(result)
    }

    @Test
    fun `IP with segment 256 should return false`() {
        // Given
        val ip = "256.100.100.100"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with segment 999 should return false`() {
        // Given
        val ip = "1.1.1.999"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with double dots should return false`() {
        // Given
        val ip = "192..168.1.1"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP starts with dot should return false`() {
        // Given
        val ip = ".192.168.1.1"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP ends with dot should return false`() {
        // Given
        val ip = "192.168.1.1."

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with leading space should return false`() {
        // Given
        val ip = " 192.168.0.1"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with trailing space should return false`() {
        // Given
        val ip = "192.168.0.1 "

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with space in middle should return false`() {
        // Given
        val ip = "192.168. 0.1"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with special character should return false`() {
        // Given
        val ip = "192.168@0.1"

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

    @Test
    fun `IP with Null input should return false`() {
        // Given
        val ip = null

        // When
        val result = isValidIPv4(ip)

        // Then
        assertFalse(result)
    }

}

