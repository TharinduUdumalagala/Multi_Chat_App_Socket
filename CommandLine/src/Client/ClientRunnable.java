package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientRunnable implements Runnable {
    private Socket socket;
    private BufferedReader bufferedReader;

    public ClientRunnable(Socket socket) throws IOException {
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run(){
        try {
            while (true){
                String response = bufferedReader.readLine();
                System.out.println(response);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
