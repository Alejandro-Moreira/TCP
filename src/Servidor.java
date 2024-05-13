import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        // Crear el socket
        ServerSocket socket_server = null;
        try {
            socket_server = new ServerSocket(5000);
            System.out.println("Esperando conexión...");

            while (true) {
                // Esperar y aceptar conexiones de clientes
                Socket socket_cliente = socket_server.accept();

                PreguntasRespuestas preguntasRespuestas = new PreguntasRespuestas();
                HiloCliente cli1 = new HiloCliente(socket_cliente, preguntasRespuestas);
                cli1.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
