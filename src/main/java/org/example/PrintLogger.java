package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintLogger {

    private static PrintLogger instance;

    private PrintLogger () {};

    private static final String LOG_FILE = "log_impresiones.txt";

    public static PrintLogger getInstance() {
        if ( instance == null ) {
            instance = new PrintLogger();
        }
        return instance;
    }

    public void log(String etiqueta, String impresora, int cantidad) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(String.format("[%s] Etiqueta: %s | Impresora: %s | Cantidad: %d%n",
                    timestamp, etiqueta, impresora, cantidad));
        } catch (IOException e) {
            System.out.println("Error al escribir en el log: " + e.getMessage());
        }
    }
}
