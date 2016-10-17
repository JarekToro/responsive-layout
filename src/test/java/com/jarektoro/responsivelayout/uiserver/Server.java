package com.jarektoro.responsivelayout.uiserver;

import org.vaadin.addonhelpers.TServer;

/**
 * The main method in this helper class opens a web server to 
 * http://localhost:9998/ to serve all your test UIs for development and
 * integration testing.
 */
public class Server extends TServer {
    
    public static void main(String... args) throws Exception {
        new Server().startServer();
    }

}
