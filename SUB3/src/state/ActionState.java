public class ActionState extends State {

    private String url;
    private List<String> parameters;

    public ActionState(String name, String url, List<String> parameters) {
        this.url = url;
        this.parameters = parameters;
    }

    @Override
    public void run() throws Exception {
        HttpClient httpClient = new HttpClient();
        httpClient.start();

        try {
            String query = makeQuery();
            System.out.println(url + query);
            ContentResponse contentResponse = httpClient.newRequest(url + query).method(HttpMethod.GET).send();
            JsonObject responseJo = new Gson().fromJson(contentResponse.getContentAsString(), JsonObject.class);
            System.out.println(responseJo.toString());
            for(String k : responseJo.keySet()) {
                VariableManager.put(k, responseJo.get(k).getAsString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String makeQuery() throws UnssupportedEncodingException {
        String query = "";
        for(int i=0; i<parameters.size() ; i++) {
            if (i == 0) {
                query += "?";
            }
            query += URLEncoder.encode(parameters.get(i), "UTF-8") + "="
                    + URLEncoder.encode(VariableManager.get(parameters.get(i)), "UTF-8");

            if(i < parameters.size() -1) {
                query += "&";
            }
        }
        return query;
    }
}