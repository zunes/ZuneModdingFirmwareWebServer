import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class httpServer {
   public static void main(String[] args) {
      int port;
      try {
         port = Integer.parseInt(args[0]);
      } catch (Exception var8) {
         port = 80;
      }

      try {
         ServerSocket server_socket = new ServerSocket(port);
         System.out.println("httpServer running on port " + server_socket.getLocalPort());

         while(true) {
            Socket socket = server_socket.accept();
            System.out.println("New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());

            try {
               httpRequestHandler request = new httpRequestHandler(socket);
               Thread thread = new Thread(request);
               thread.start();
            } catch (Exception var6) {
               System.out.println(var6);
            }
         }
      } catch (IOException var7) {
         System.out.println(var7);
      }
   }
}