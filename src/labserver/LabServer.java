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