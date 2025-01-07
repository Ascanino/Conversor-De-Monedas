# Proyecto: Conversor de Monedas en Java

Este proyecto consiste en un **conversor de monedas** que utiliza Java para interactuar con una API de tasas de cambio. El programa permite a los usuarios realizar conversiones entre diversas monedas mediante una interfaz textual en la consola.

---

## **Características principales**

- **Conexión a la API de tasas de cambio**  
  Utiliza las clases `HttpClient`, `HttpRequest` y `HttpResponse` para conectarse a la API, enviar solicitudes y gestionar respuestas.  

- **Procesamiento de datos JSON**  
  Emplea la biblioteca `Gson` para mapear y extraer las tasas de conversión del JSON proporcionado por la API.  

- **Monedas soportadas**  
  Maneja conversiones entre múltiples monedas, con sus respectivos íconos de bandera:  
  - 🇦🇷 ARS (Peso argentino)  
  - 🇧🇴 BOB (Boliviano boliviano)  
  - 🇧🇷 BRL (Real brasileño)  
  - 🇨🇱 CLP (Peso chileno)  
  - 🇨🇴 COP (Peso colombiano)  
  - 🇺🇸 USD (Dólar estadounidense)  
  - 🇻🇪 VES (Bolívar venezolano)  
  - 🇵🇪 PEN (Sol peruano)  

- **Interfaz interactiva en consola**  
  Incluye un menú dinámico que:  
  1. Solicita la moneda de origen.  
  2. Permite ingresar un monto para convertir.  
  3. Solicita la moneda de destino.  
  4. Muestra el resultado de la conversión.  

- **Validaciones robustas**  
  Comprueba entradas numéricas válidas y evita selecciones inválidas como convertir a la misma moneda.

---

## **Estructura del proyecto**

1. **Clase `Principal`**  
   Responsable de gestionar la interacción con el usuario, mostrando el menú y capturando las entradas con la clase `Scanner`.

2. **Clase `ServicioConversion`**  
   Encargada de:  
   - Realizar solicitudes a la API.  
   - Procesar la respuesta JSON.  
   - Calcular los valores convertidos entre las monedas seleccionadas.  

---

## **Propósito del proyecto**

Este proyecto busca:  

1. **Demostrar habilidades técnicas**  
   Aplicando conceptos avanzados de programación en Java, como manejo de APIs, procesamiento de JSON, y diseño modular.  

2. **Facilitar la conversión de monedas**  
   Proporcionando una herramienta práctica y eficiente que realiza conversiones basadas en tasas de cambio actualizadas.  

3. **Ofrecer una experiencia educativa**  
   Explorando el desarrollo de programas interactivos y el uso de herramientas como `Gson` y `HttpClient` para trabajar con APIs y JSON.

---

### **Ejemplo de flujo del programa**
1. Selección de moneda de origen:  
   _"Ingrese la opción numérica correspondiente a la moneda de origen"_.  
2. Introducción del monto a convertir:  
   _"Ingrese el monto que desea convertir"_.  
3. Selección de moneda de destino:  
   _"Seleccione la moneda a la cual desea convertir"_.  
4. Resultado:  
   _"El valor de 100 CLP corresponde a 0.11 USD"_.  

5. Opción de repetir la operación o salir del programa.  

---

¡Este proyecto representa una solución completa y funcional para la conversión de monedas en tiempo real! 🚀
