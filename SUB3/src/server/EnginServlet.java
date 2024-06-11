public class EnginServlet extends HttpServlet{

    public static final long serialVersionUID = 8572241974921679005L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String requestURL = request.getRequestURL().toString();
        String path = requestURL.subString(requestURL.lastIndexOf("/") + 1);

        System.out.println(path);

        try {
            StateManager.get(path).run;
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}