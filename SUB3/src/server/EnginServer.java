public class EnginServer {

    public void start() throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(new ServletHolder(new EngineServlet()), "/*");

        server.setHandler(context);
        server.start();
        server.join();
    }
}