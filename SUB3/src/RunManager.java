public class RunManager {

    public static void main(String[] args) {
        VariableManager.load();
        StateManager.load();

        EngineServer engineServer = new EnginServer();
        engineServer.start();
    }
}