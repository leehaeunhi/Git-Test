public class RunManager {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, State> states = new HashMap<>();

        // 파일에서 State 정보 읽기
        for(String line : Files.readAllLines(Paths.get("STATE.TXT"))) {
            String[] elements = line.split("#");
            String name = elements[0];
            String type = elements[1];
            String url = elements[2];

            String[] keys = null;
            if(elements.length > 3) {
                keys = elements[3].split(",");
            }

            states.put(name, new State(name, type, url, keys));
        }

        // 다른 파일에서 추가정보 읽기


        // Console에서 입력 받기
        while(true) {
            String request = scanner.nextLine();

            State state = states.get(request);

            String print = state.getType() + " " + state.getUrl();

            String[] keys = state.getKeys();
            if(keys != null) {
                for(int i=0; i<keys.length; i++) {
                    if (i == 0) {
                        print += "?";
                    } else if(i > 0) {
                        print += "&";
                    }
                    print += keys[i] + "=" + VariableManager.get(keys[i]);
                }
            }

            System.out.println(print);
        }
    }
}