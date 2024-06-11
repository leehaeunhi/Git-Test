public class State {

    private String name;

    public State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void run() throws Exception;
}