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
            states.put(name, new State(name, type, url));
        }

        // Console에서 입력 받기
        while(true) {
            String request = scanner.nextLine();
            State state = states.get(request);
            System.out.println(state.getType{} + " " + state.getUrl());
        }
    }
}