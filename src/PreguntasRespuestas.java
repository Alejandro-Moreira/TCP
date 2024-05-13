import java.util.HashMap;
import java.util.Map;

public class PreguntasRespuestas {
    private Map<String, String> preguntasRespuestas;

    public PreguntasRespuestas() {
        preguntasRespuestas = new HashMap<>();
        // Agregar preguntas y respuestas
        preguntasRespuestas.put("¿Cuál es la capital de Francia?", "París");
        preguntasRespuestas.put("¿En qué año se descubrió América?", "1492");
        preguntasRespuestas.put("¿Cuál es el planeta más grande del sistema solar?", "Júpiter");
        preguntasRespuestas.put("¿Quién escribió 'Don Quijote de la Mancha'?", "Miguel de Cervantes");
        preguntasRespuestas.put("¿Cuál es el río más largo del mundo?", "Amazonas");
    }

    public boolean verificarRespuesta(String pregunta, String respuesta) {
        String respuestaCorrecta = preguntasRespuestas.get(pregunta);
        return respuestaCorrecta != null && respuestaCorrecta.equalsIgnoreCase(respuesta);
    }

    public String obtenerSiguientePregunta() {
        // En una implementación real, podrías devolver la siguiente pregunta de manera aleatoria.
        return "¿Cuál es la capital de Italia?";
    }
}
