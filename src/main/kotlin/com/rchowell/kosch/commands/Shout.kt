package com.rchowell.kosch.commands

import com.rchowell.kosch.Command
import com.rchowell.kosch.Opt
import org.apache.commons.cli.CommandLine
import java.lang.IllegalArgumentException

class Shout : Command() {

    override val name = "shout"
    override val help = "shouts the input text"
    override val opts = listOf(
        Opt(
            alias = "t",
            name = "text",
            type = String::class.java,
            required = true,
            isFlag = false,
            usage = "the text to print",
        ),
    )

    override fun run(env: Any, args: CommandLine) {
        val text = args.getOptionValue("t") ?: throw IllegalArgumentException("text is required")
        println(text.toUpperCase())
    }
}
