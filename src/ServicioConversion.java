import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioConversion {

    private final String API_KEY = "b5fb7d834b07d3155e31c16f"; // Tu API Key
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public double convertirMoneda(String monedaOrigen , String monedaDestino , double monto) {
        try {
            // Crear la URL para la solicitud a la API
            String urlString = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + monedaOrigen;

            // Crear la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .build();

            // Realizar la solicitud HTTP y obtener la respuesta
            HttpResponse<String> response = client
                    .send(request , HttpResponse.BodyHandlers.ofString());

            // Verificar si la respuesta es exitosa (código 200)
            if (response.statusCode() == 200) {
                // Convertir el cuerpo de la respuesta JSON en un objeto ApiResponse
                ApiResponse apiResponse = gson.fromJson(response.body() , ApiResponse.class);

                // Verificar si el resultado de la respuesta es "success"
                if ("success".equals(apiResponse.result)) {
                    // Obtener la tasa de conversión de la moneda seleccionada
                    double tasaConversion = getTasaConversion(apiResponse , monedaDestino);
                    return monto * tasaConversion;
                } else {
                    System.out.println("Error al obtener los datos de conversión.");
                    return 0;
                }
            } else {
                System.out.println("Error: " + response.statusCode());
                return 0;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    private double getTasaConversion(ApiResponse apiResponse , String monedaDestino) {
        // Utilizar el nombre de la moneda para acceder directamente a la tasa de conversión
        try {
            return apiResponse.conversion_rates.getClass()
                    .getDeclaredField(monedaDestino)
                    .getDouble(apiResponse.conversion_rates);
        } catch (Exception e) {
            throw new IllegalArgumentException("Moneda no soportada");
        }
    }

    // Clase para mapear la respuesta JSON de la API
    private static class ApiResponse {
        String result;
        ConversionRates conversion_rates;
    }

    private static class ConversionRates {
        double VES, USD, PEN, CLP, EUR;
    }
}
