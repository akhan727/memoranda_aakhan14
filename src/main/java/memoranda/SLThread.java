package main.java.memoranda;

import java.net.ServerSocket;

import main.java.memoranda.ui.ExceptionDialog;

// TASK 3-2 SMELL BETWEEN CLASSES

class SLThread extends Thread {
    
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(Start.DEFAULT_PORT);
            serverSocket.accept();
            Start.app.show();
            serverSocket.close();
            new SLThread().start();
            
        } catch (Exception e) {
            System.err.println("Port:"+Start.DEFAULT_PORT);
            e.printStackTrace();
            new ExceptionDialog(e, "Cannot create a socket connection on localhost:"+Start.DEFAULT_PORT,
            "Make sure that other software does not use the port "+Start.DEFAULT_PORT+" and examine your security settings.");
        }
    }
}
