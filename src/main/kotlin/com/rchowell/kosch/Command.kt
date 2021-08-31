package com.rchowell.kosch

import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.Options

/**
 * Shell com.rchowell.kosch.Command
 *
 * @constructor Create empty com.rchowell.kosch.Command
 */
abstract class Command {

    /**
     * The command's name
     */
    abstract val name: String

    /**
     * Simple help text for the command
     */
    abstract val help: String

    /**
     * Identifier to metadata about the command's arguments
     */
    abstract val opts: List<Opt>

    /**
     * Runs this command with some environment and args
     */
    abstract fun run(env: Any, args: CommandLine)

    val options: Options
        get() {
            val options = Options()
            opts.forEach { options.addOption(it.toOption()) }
            return options
        }
}
