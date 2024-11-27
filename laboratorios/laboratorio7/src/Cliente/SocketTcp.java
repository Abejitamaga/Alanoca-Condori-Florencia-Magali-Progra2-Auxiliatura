package Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Servidor.PackageData;

public class SocketTcp implements Runnable {
    private Integer port;
    private String ip;
    private Boolean connected;
    private Socket socket;
    private Thread thread;
    private ObjectOutputStream outData;
    private ObjectInputStream inData;

    public SocketTcp(String ip, Integer port) {
        this.port = port;
        this.ip = ip;
        this.connected = false;
    }

    public void connected() {
        try {
            socket = new Socket(this.ip, this.port);
            outData = new ObjectOutputStream(socket.getOutputStream());
            inData = new ObjectInputStream(socket.getInputStream());
            this.connected = true;
            thread = new Thread(this);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void emmit(Cliente.PackageData data, OnMessageRecive listener) {
        try {
            outData.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (this.connected) {
            try {
                PackageData data = (PackageData) inData.readObject();
                System.out.println(data.getNick() + " > " + data.getMsn());
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
                this.connected = false;
            }
        }
    }

    public void dissConnect() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dissConnect'");
    }
}
