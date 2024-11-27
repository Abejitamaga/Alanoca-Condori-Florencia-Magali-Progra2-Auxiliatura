package Servidor;

public interface OnEventListener {
    void join(String channelName, ServerClientSocket client);
}
