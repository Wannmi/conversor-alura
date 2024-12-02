import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public Conversiones ConsultaConversion(String monedaBase){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/cde3919da9dc82143496151c/latest/" + monedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversiones.class);
        } catch (Exception e) {
            throw new RuntimeException("No se ha encontrado la moneda base.");
        }
    }
}
