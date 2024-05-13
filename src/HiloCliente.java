import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HiloCliente extends Thread {
    private Socket socket_cliente;
    private PreguntasRespuestas preguntasRespuestas;

    public HiloCliente(Socket socket_cliente, PreguntasRespuestas preguntasRespuestas) {
        this.socket_cliente = socket_cliente;
        this.preguntasRespuestas = preguntasRespuestas;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);

            Scanner mensaje = new Scanner(System.in);
            String pregunta;
            while (true) {
                // Obtener pregunta del servidor
                pregunta = String.valueOf(preguntasRespuestas. obtenerSiguientePregunta());
                salida.println(pregunta);

                // Leer respuesta del cliente
                String respuestaCliente = entrada.readLine();
                if (preguntasRespuestas.verificarRespuesta(pregunta, respuestaCliente)) {
                    salida.println("Respuesta Correcta!");
                } else {
                    salida.println("Respuesta Incorrecta!");
                }
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
