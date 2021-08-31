
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.DefaultParser
import java.util.Scanner

class Shell(
    val commands: List<Command>,
    val greeting: String?,
) {

    private val cmds = mutableMapOf<String, Command>()

    fun run() {

        // register all commands
        commands.forEach { cmds[it.name] = it }

        clear()
        if (greeting != null) println(greeting)

        //
        val scanner = Scanner(System.`in`)
        val parser = DefaultParser()

        var exit = false
        while (!exit) {
            print("> ")
            when (val input = scanner.nextLine()) {
                "exit" -> exit = true
                "clear" -> clear()
                else -> {
                    val args = splitArgs(input)
                    val command = cmds[args[0]]
                    if (command == null) {
                        println("unknown command: ${args[0]}")
                        continue
                    }
                    try {
                        val line: CommandLine = parser.parse(command.options, args.toTypedArray())
                        command.run({}, line)
                    } catch (e: Exception) {
                        println("Error: $e")
                    }
                }
            }
        }
    }
}

fun clear() {
    print("\u001b[H\u001b[2J")
    System.out.flush()
}
