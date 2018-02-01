package me.depc.webserver.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.io.OutputStream;

public class PlayerCount implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
        String response = String.valueOf(Bukkit.getServer().getOnlinePlayers().size());
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
