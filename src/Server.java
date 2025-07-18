import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer(){
        try{
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept(); //the program will be holded here until the client is connect 
                System.out.println("The new user is connected!");
                ClientHandler ClientHandler = new ClientHandler(socket); //every object of this class will be responsible for communicating with the client

                Thread thread = new Thread(ClientHandler);
                thread.start();

            }
        }

        catch (IOException e){
            closeServerSocket();
        }
    }

    public void closeServerSocket(){ //this method will be used if an error accured with the server
        try{
            if(serverSocket != null){
                serverSocket.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Server server = new Server(serverSocket);
        server.startServer();
    }
    
}

/*
 * Questions
 * 1. What is server socket
 * 
 */ 