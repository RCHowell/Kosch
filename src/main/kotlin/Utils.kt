import java.lang.StringBuilder

/**
 * Split args parses the input string to create a list of tokens.
 * It's nothing more than whitespace splitting that groups text in quotes.
 * This is probably in at least one Apache library and can be done with a regex.
 */
fun splitArgs(input: String): List<String> {
    val args = mutableListOf<String>()
    val buffer = StringBuilder()
    val chars = input.toCharArray().iterator()
    var inquotes = false
    var escaped = false

    fun accept() {
        args.add(buffer.toString())
        buffer.clear()
    }

    while (chars.hasNext()) {
        val c = chars.next()
        if (c.isWhitespace() && !inquotes) {
            accept()
        } else if (c == '"') {
            when {
                !escaped && !inquotes -> inquotes = true
                !escaped && inquotes -> inquotes = false
                escaped -> buffer.append(c)
            }
        } else if (c == '\\' && !escaped) {
            escaped = true
        } else {
            buffer.append(c)
            escaped = false
        }
    }
    if (buffer.isNotEmpty()) accept()
    return args
}
