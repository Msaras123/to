
import com.sun.net.httpserver.*;
import java.net.*;
import java.nio.file.*;

public class TodoApp {
    public static void main(String[] args) throws Exception {
        var s = HttpServer.create(new InetSocketAddress(8080), 0);
        s.createContext("/", e -> {
            byte[] b = Files.readAllBytes(Path.of("index.html"));
            e.getResponseHeaders().set("Content-Type", "text/html");
            e.sendResponseHeaders(200, b.length);
            e.getResponseBody().write(b);
            e.close();
        });
        s.start();
        System.out.println("http://localhost:8080");
    }
}
