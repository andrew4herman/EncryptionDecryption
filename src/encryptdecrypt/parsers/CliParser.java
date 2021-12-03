package encryptdecrypt.parsers;

import java.util.HashMap;

public class CliParser {

    private final HashMap<String, Integer> optionIndexes;
    private String[] args;

    public CliParser(String[] arguments) {
        optionIndexes = new HashMap<>();
        parse(arguments);
    }

    private void parse(String[] arguments) {
        this.args = arguments;

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                optionIndexes.put(args[i], i);
            }
        }
    }

    public String optionValue(String switchName) {
        return optionValueOrDefault(switchName, null);
    }

    public String optionValueOrDefault(String optionName, String defaultValue) {
        if (!optionIndexes.containsKey(optionName)) return defaultValue;

        int switchIndex = optionIndexes.get(optionName);
        if (switchIndex + 1 < args.length) {
            return args[switchIndex + 1];
        }

        return defaultValue;
    }
}
