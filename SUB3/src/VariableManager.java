public class VariableManager {

    private static Map<String, String> varaiables = new HashMap<>();

    public synchronized static String get(String key) {
        return varaiables.get(key);
    }

    public synchronized static String put(String key, String value) {
        return varaiables.put(key, value);
    }

    public synchronized static void load() throws JsonSyntaxException, Exception {
        // java.lang.reflect.Type
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();

        varaiables = Collections.sychronizedMap(new Gson().fromJson(new String(Files.readAllBytes(Paths.get("VARIABLE.JSON"))), type));
    }
}