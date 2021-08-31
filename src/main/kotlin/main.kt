import com.rchowell.kosch.Shell
import com.rchowell.kosch.commands.Shout

const val banner = """
 __  __  ______  ______  ______  __  __    
/\ \/ / /\  __ \/\  ___\/\  ___\/\ \_\ \   
\ \  _"-\ \ \/\ \ \___  \ \ \___\ \  __ \  
 \ \_\ \_\ \_____\/\_____\ \_____\ \_\ \_\ 
  \/_/\/_/\/_____/\/_____/\/_____/\/_/\/_/ 
                                           
"""

fun main() {
    val shell = Shell(
        commands = listOf(Shout()),
        greeting = banner,
    )
    shell.run()
}
