import org.apache.commons.cli.Option

/**
 * Opt is Kotlin wrapper of the Apache Commons CLI [Option] class.
 *
 * @property alias
 * @property name
 * @property required
 * @property isFlag
 * @property usage
 * @constructor Create empty Arg
 */
class Opt(
    val alias: String,
    val name: String,
    val type: Class<*>,
    val required: Boolean,
    val isFlag: Boolean,
    val usage: String
) {

    /**
     * Build an [Option]
     */
    fun toOption(): Option = Option.builder(alias)
        .longOpt(name)
        .type(type)
        .required(required)
        .hasArg(!isFlag)
        .desc(usage)
        .build()
}
