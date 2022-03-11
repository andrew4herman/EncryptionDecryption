package crypting;

import java.util.HashMap;
import java.util.Map;

/**
 * It parses the command line arguments and returns the values of the options
 */
public class CliParser {

    private final Map<String, String> argValues;

    public CliParser(String[] arguments) {
        argValues = new HashMap<>();
        parse(arguments);
    }

    /**
     * Given an argument name, return the value of that argument
     *
     * @param arg The argument to the option.
     * @return The value of the argument that was passed in.
     */
    public String optionOf(String arg) {
        return argValues.get(arg);
    }

    /**
     * If the argument is present, return its value; otherwise, return the default value
     *
     * @param arg          The name of the argument.
     * @param defaultValue The default value to return if the argument is not found.
     * @return The value of the argument if it is present, otherwise the default value.
     */
    public String optionOrDefault(String arg, String defaultValue) {
        return argValues.getOrDefault(arg, defaultValue);
    }

    private void parse(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                if (i + 1 >= args.length || args[i + 1].startsWith("-"))
                    throw new IllegalArgumentException(
                            String.format("Error. Incorrect option for %s", args[i]));

                argValues.put(
                        args[i].toLowerCase(),
                        args[i + 1]
                );
            }
        }
    }
}
