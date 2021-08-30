import commands.Shout
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.DefaultParser
import java.util.Scanner

const val banner = """
__/\\\________/\\\_______/\\\\\__________/\\\\\\\\\\\__________/\\\\\\\\\__/\\\________/\\\_        
 _\/\\\_____/\\\//______/\\\///\\\______/\\\/////////\\\_____/\\\////////__\/\\\_______\/\\\_       
  _\/\\\__/\\\//_______/\\\/__\///\\\___\//\\\______\///____/\\\/___________\/\\\_______\/\\\_      
   _\/\\\\\\//\\\______/\\\______\//\\\___\////\\\__________/\\\_____________\/\\\\\\\\\\\\\\\_     
    _\/\\\//_\//\\\____\/\\\_______\/\\\______\////\\\______\/\\\_____________\/\\\/////////\\\_    
     _\/\\\____\//\\\___\//\\\______/\\\__________\////\\\___\//\\\____________\/\\\_______\/\\\_   
      _\/\\\_____\//\\\___\///\\\__/\\\_____/\\\______\//\\\___\///\\\__________\/\\\_______\/\\\_  
       _\/\\\______\//\\\____\///\\\\\/_____\///\\\\\\\\\\\/______\////\\\\\\\\\_\/\\\_______\/\\\_ 
        _\///________\///_______\/////_________\///////////___________\/////////__\///________\///__ 

"""

const val banner2 = """
 __  __  ______  ______  ______  __  __    
/\ \/ / /\  __ \/\  ___\/\  ___\/\ \_\ \   
\ \  _"-\ \ \/\ \ \___  \ \ \___\ \  __ \  
 \ \_\ \_\ \_____\/\_____\ \_____\ \_\ \_\ 
  \/_/\/_/\/_____/\/_____/\/_____/\/_/\/_/ 
                                           
"""

fun main() {

    clear()
    println(banner)

    val scanner = Scanner(System.`in`)
    val parser = DefaultParser()

    val commands: Map<String, Command> = mapOf<String, Command>(
        "shout" to Shout()
    )

    var exit = false
    while (!exit) {
        print("> ")
        when (val input = scanner.nextLine()) {
            "exit" -> exit = true
            "clear" -> clear()
            else -> {
                val args = splitArgs(input)
                val command = commands[args[0]]
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

fun clear() {
    print("\u001b[H\u001b[2J")
    System.out.flush()
}
