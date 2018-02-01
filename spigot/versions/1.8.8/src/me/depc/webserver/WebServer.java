package me.depc.webserver;

import com.sun.net.httpserver.HttpServer;
import me.depc.webserver.handlers.PlayerCount;

import java.net.InetSocketAddress;

public class WebServer {

    public WebServer(int port) throws Exception {
        InetSocketAddress ip = new InetSocketAddress(port);
        HttpServer server = HttpServer.create(ip, 0);
        server.createContext("/playercount", new PlayerCount());
        server.setExecutor(null);
        server.start();
    }
}
