package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Socket socket;
    private ArrayList<ServerThread> threadArrayList;
    private PrintWriter printWriter;

    public ServerThread(){

    }

    public ServerThread(Socket socket, ArrayList<ServerThread> threads){
        this.socket = socket;
        this.threadArrayList = threads;
    }

    public  void run(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(),true);

            while (true){
                String outputString = bufferedReader.readLine();
                if (outputString.equals("exit")){
                    break;
                }
                printToAllClient(outputString);
                System.out.println("Server received" + outputString);
            }
        }catch (Exception e){
            System.out.println("Error occurred" );
            e.printStackTrace();
        }

    }

    private void printToAllClient(String outputString) {
        for (ServerThread serverThread : threadArrayList){
            serverThread.printWriter.println(outputString);
        }
    }
}
