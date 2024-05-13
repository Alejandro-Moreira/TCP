import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        // Crear un socket
        Socket socket_cliente = null;
        try {
            socket_cliente = new Socket("localhost", 5000);
            System.out.println("Cliente conectado");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String pregunta;
            while (true) {
                // Leer pregunta del servidor
                pregunta = entrada.readLine();
                if (pregunta == null) {
                    break;
                }
                System.out.println(pregunta);
                // Enviar respuesta al servidor
                String respuesta = scanner.nextLine();
                salida.println(respuesta);

                // Leer respuesta del servidor
                String respuestaServidor = entrada.readLine();
                System.out.println("Respuesta del servidor: " + respuestaServidor);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket_cliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
