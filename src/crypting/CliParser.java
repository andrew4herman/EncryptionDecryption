package crypting;

import java.util.HashMap;
import java.util.Map;

public class CliParser {

    private final Map<String, String> argValues;
    private String[] args;

    public CliParser(String[] arguments) {
        argValues = new HashMap<>();
        parse(arguments);
    }

    private void parse(String[] arguments) {
        this.args = arguments;

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                argValues.put(args[i], args[i + 1]);
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
