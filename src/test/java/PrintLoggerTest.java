import org.example.PrintLogger;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintLoggerTest {

    private static final String LOG_FILE_TEST = "test_logs.txt";

    class TestablePrintLogger extends PrintLogger {
        @Override
        public void log(String etiqueta, String impresora, int cantidad) {
            try (FileWriter writer = new FileWriter(LOG_FILE_TEST, true)) {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                writer.write(String.format("[%s] Etiqueta: %s | Impresora: %s | Cantidad: %d%n",
                        timestamp, etiqueta, impresora, cantidad));
            } catch (IOException e) {
                System.out.println("Error al escribir en el log: " + e.getMessage());
            }
        }
    }

    @Test
    public void logTest (){
        TestablePrintLogger testablePrintLogger = new TestablePrintLogger();
        testablePrintLogger.log("Etiqueta", "Impresora", 2);

    }

    ;
}
