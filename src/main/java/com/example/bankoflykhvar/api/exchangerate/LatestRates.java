package com.example.bankoflykhvar.api.exchangerate;

import java.io.IOException;
import java.net.http.HttpClient;

public class LatestRater {
    String url_str = "https://api.exchangerate.host/latest";


    public String getRates() throws IOException {
        HttpClient request = request.send()
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        String req_result = jsonobj.get("result").getAsString();
    }
}
