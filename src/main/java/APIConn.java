import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject; // Importar a biblioteca para trabalhar com JSON

public class APIConn {
    public static JSONObject getRate(String rate) throws APIException {
        HttpClient httpClient = HttpClient.newHttpClient();

        String apiUrl = "https://brasilapi.com.br/api/taxas/v1/" + rate;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                return new JSONObject(responseBody); // Converter a resposta para um objeto JSON
            } else {
                throw new APIException("Request Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new APIException("Error sending request", e);
        }
    }

    public static class APIException extends Exception {
        public APIException(String message) {
            super(message);
        }

        public APIException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
