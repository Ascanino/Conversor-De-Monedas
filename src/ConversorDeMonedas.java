import java.util.Scanner;

public class ConversorDeMonedas {
    public static void main(String[] args) {
        // Mostrar bienvenida
        System.out.println("Sea Bienvenido/a al conversor de monedas");

        // Crear una instancia del servicio de conversión
        ServicioConversion servicioConversion = new ServicioConversion();

        // Lógica del programa para ingresar datos y hacer la conversión
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Solicitar al usuario elegir la moneda de origen
            String monedas = """
                        Elija la moneda que desea convertir:
                        1: ARS - Peso argentino
                        2: BOB - Boliviano boliviano
                        3: BRL - Real brasileño
                        4: CLP - Peso chileno
                        5: COP - Peso colombiano
                        6: USD - Dólar estadounidense
                        7: VES - Bolívar venezolano
                        8: PEN - Sol peruano
                        Elija una opción válida (o '0' para salir):\s
                   \s""";

            System.out.print(monedas);

            int monedaOrigen = scanner.nextInt();
            if (monedaOrigen == 0) {
                System.out.println("Saliendo del conversor...");
                break;
            }

            // Solicitar el monto a convertir
            System.out.print("Ingrese el monto que desea convertir: ");
            double monto = scanner.nextDouble();

            // Determinar la moneda de origen
            String monedaOrigenStr = obtenerMoneda(monedaOrigen);
            if (monedaOrigenStr == null) {
                System.out.println("Opción no válida. Intente nuevamente.");
                continue;
            }

            // Solicitar la moneda de destino
            System.out.print(monedas);

            int monedaDestino = scanner.nextInt();
            if (monedaDestino == 0) {
                System.out.println("Saliendo del conversor...");
                break;
            }

            // Determinar la moneda de destino
            String monedaDestinoStr = obtenerMoneda(monedaDestino);
            if (monedaDestinoStr == null || monedaDestinoStr.equals(monedaOrigenStr)) {
                System.out.println("Opción no válida o la misma moneda. Intente nuevamente.");
                continue;
            }

            // Realizar la conversión utilizando el servicio de conversión
            double resultado = servicioConversion.convertirMoneda(monedaOrigenStr, monedaDestinoStr, monto);

            // Mostrar el resultado
            if (resultado > 0) {
                System.out.printf("El valor de %.2f %s corresponde a %.2f %s%n", monto, monedaOrigenStr, resultado, monedaDestinoStr);
            } else {
                System.out.println("Hubo un error al realizar la conversión.");
            }

            // Preguntar si el usuario quiere hacer otra conversión
            System.out.print("¿Desea realizar otra conversión? (1: Sí, 2: No): ");
            int respuesta = scanner.nextInt();
            if (respuesta == 2) {
                System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
                break;
            }
        }

        scanner.close();
    }

    // Método para obtener la moneda según la opción seleccionada
    private static String obtenerMoneda(int opcion) {
        return switch (opcion) {
            case 1 -> "ARS"; // Peso argentino
            case 2 -> "BOB"; // Boliviano
            case 3 -> "BRL"; // Real brasileño
            case 4 -> "CLP"; // Peso chileno
            case 5 -> "COP"; // Peso colombiano
            case 6 -> "USD"; // Dólar estadounidense
            case 7 -> "VES"; // Bolívar venezolano
            case 8 -> "PEN"; // Sol peruano
            default -> null;
        };
    }
}
