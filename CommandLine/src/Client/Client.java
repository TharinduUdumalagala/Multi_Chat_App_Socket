package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("localhost",5000);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);

            Scanner scanner = new Scanner(System.in);
            String userInput;
            String response;
            String clientName ="";

            ClientRunnable clientRunnable = new ClientRunnable(socket);

            new Thread(clientRunnable).start();

            do {
                if (clientName.equals("empty")){
                    System.out.println("Enter your name");
                    userInput = scanner.nextLine();
                    clientName = userInput;
                    printWriter.println(userInput);
                    if (userInput.equals("exit")){
                        break;
                    }
                }else {
                    String message = ("("+clientName +")"+"message :");
                    System.out.println(message);
                    userInput = scanner.nextLine();
                    printWriter.println(message + "" + message);
                    if (userInput.equals("exit")){
                        break;
                    }
                }
            }while (!userInput.equals("exit"));

            socket.close();
            bufferedReader.close();
            printWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}


