import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>(); //keep track of our all clients 
    //if a client sent a message we can loop throw our clients and send the message to each one

    private Socket socket; //represent the connection between the clients  
    private BufferedReader bufferedReader; //will be used to read data that sent by other clients
    private BufferedWriter bufferedWriter; //Send data to our client
    private String clientUsername;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = bufferedReader.readLine();
            clientHandlers.add(this);
            broadCastMessage("SERVER: " + clientUsername + " has entered the chat!");
        } catch(IOException e){
            closeEveryThing(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String messageFromClient;

        while (socket.isConnected()) {
            try{
                messageFromClient = bufferedReader.readLine();
                broadCastMessage(messageFromClient);
            }

            catch (IOException e){
                closeEveryThing(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    public void broadCastMessage (String messageToSend){ //send a message to users except the sender user
        for (ClientHandler clientHandler : clientHandlers){
            try{
                if(!clientHandler.clientUsername.equals(clientUsername)){
                    clientHandler.bufferedWriter.write(messageToSend);
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();
                }
            }
            catch(IOException e){
                closeEveryThing(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    public void removeClientHandler(){
        clientHandlers.remove(this);
        broadCastMessage("SERVER:"  + clientUsername + " has left the chat!");
    }

    public void closeEveryThing(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientHandler();
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter !=null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        } 
        catch(IOException e){
            e.printStackTrace();
        }
    }

}



/*
 * What is the runnable interface ? make the instances of clienthandler class executed by seprate threads
 */
