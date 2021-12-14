package crypting;

import java.util.HashMap;
import java.util.Map;

public class CliParser {

    private final Map<String, String> argValues;

    public CliParser(String[] arguments) {
        argValues = new HashMap<>();
        parse(arguments);
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

    public String optionOf(String arg) {
        return argValues.get(arg);
    }

    public String optionOrDefault(String arg, String defaultValue) {
        return argValues.getOrDefault(arg, defaultValue);
    }
}
