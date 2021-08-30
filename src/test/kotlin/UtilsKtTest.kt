import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

internal class UtilsKtTest {

    @Test
    fun splitArgsSimple() {
        val input = "A B SEA"
        val output = splitArgs(input)
        assertEquals(listOf("A", "B", "SEA"), output)
    }

    @Test
    fun splitArgsQuotes() {
        val input = "A B \"SEA\" \"Something with spaces\""
        val output = splitArgs(input)
        assertEquals(listOf("A", "B", "SEA", "Something with spaces"), output)
    }

    @Test
    fun splitArgsEscapes() {
        val input = "A B SE\\\"A"
        val output = splitArgs(input)
        assertEquals(listOf("A", "B", "SE\"A"), output)
    }
}
