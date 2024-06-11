public class VariableManager {

    private static Map<String, String> varaiables = new HashMap<>();

    public static String get(String key) {
        return varaiables.get(key);
    }

    public static String put(String key, String value) {
        return varaiables.put(key, value);
    }

    public static void load() throws Exception {
        for(String line : Files.readAllLines(Paths.get("VARIABLE.TXT"))) {
            String[] elements = line.split("#");
            String name = elements[0];
            String value = elements[1];
            varaiables.put(name, value);
        }
    }
}