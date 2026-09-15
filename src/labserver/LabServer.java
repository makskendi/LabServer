/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labserver;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.io.InputStream;


public class LabServer {
 public static void main(String[] args) throws IOException {
 HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
 server.createContext("/", exchange -> {
 String path = exchange.getRequestURI().getPath();
 if (path.equals("/")) {
 sendText(exchange, 200, "Hello from Lab 1");
 } else {
 sendText(exchange, 404, "Not found");
 }
 });
 
 server.createContext("/about", exchange -> {
 String method = exchange.getRequestMethod();
 if (!"GET".equals(method)) {
 sendText(exchange, 405, "Method Not Allowed. Use GET.");
 return;
 }
 sendText(exchange, 200, "About this server: Lab 2 plain Java HttpServer.");
 });
 server.createContext("/time", exchange -> {
 String method = exchange.getRequestMethod();
 if (!"GET".equals(method)) {
 sendText(exchange, 405, "Method Not Allowed. Use GET.");
 return;
 }
 sendText(exchange, 200, LocalDateTime.now().toString());
 });
 
 server.createContext("/echo", exchange -> {
 String method = exchange.getRequestMethod();
 if (!"POST".equals(method)) {
 sendText(exchange, 405, "Method Not Allowed. Use POST.");
 return;
 }
 InputStream requestBody = exchange.getRequestBody();
 byte[] bodyBytes = requestBody.readAllBytes();
 String body = new String(bodyBytes, StandardCharsets.UTF_8);
 sendText(exchange, 200, body);
 });
server.createContext("/info", exchange -> {
    String method = exchange.getRequestMethod();

    if (!"GET".equals(method)) {
        sendText(exchange, 405, "Method Not Allowed. Use GET.");
        return;
    }

    sendText(exchange, 200,
            "Lab 2 Info: Full-stack web development, plain Java HttpServer, port 8080.");
});
 
 server.createContext("/greet", exchange -> {
 String method = exchange.getRequestMethod();
 if (!"GET".equals(method)) {
 sendText(exchange, 405, "Method Not Allowed. Use GET.");
 return;
 }
 String query = exchange.getRequestURI().getQuery();
 String name = "world";
 if (query != null) {
 for (String pair : query.split("&")) {
 String[] parts = pair.split("=", 2);
 if (parts.length == 2 && parts[0].equals("name") && !parts[1].isEmpty()) {
 name = java.net.URLDecoder.decode(parts[1], StandardCharsets.UTF_8);
 }
 }
 }
 sendText(exchange, 200, "Hello, " + name);
 });


 server.setExecutor(null);
 server.start();
 System.out.println("Server started on http://localhost:8080/");
 }
 private static void sendText(HttpExchange exchange, int statusCode, String response)
 throws IOException {
 byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
 exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=utf-8");
 exchange.sendResponseHeaders(statusCode, responseBytes.length);
 try (OutputStream os = exchange.getResponseBody()) {
 os.write(responseBytes);
 }
 }
}