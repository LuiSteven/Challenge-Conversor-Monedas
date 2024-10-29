import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultaMonedas {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/ae0b385d976cd3d951e0cede/latest/";

    public Moneda buscarMoneda(String baseCode) {
        URI uri = URI.create(API_URL + baseCode);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré la conversión de moneda para " + baseCode);
        }
    }

    public double convertir(String baseCode, String targetCode, double amount) {
        Moneda moneda = buscarMoneda(baseCode);
        Map<String, Double> conversionRates = moneda.conversion_rates();
        Double tasaConversion = conversionRates.get(targetCode);

        if (tasaConversion != null) {
            return amount * tasaConversion;
        } else {
            throw new RuntimeException("No se encontró la tasa de conversión para " + targetCode);
        }
    }
}
