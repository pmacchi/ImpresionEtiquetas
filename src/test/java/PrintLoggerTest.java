import org.example.PrintLogger;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintLoggerTest {

    private static final String LOG_FILE_TEST = "test_logs.txt";


    @Test
    public void logTest() {
        PrintLogger printLogger = PrintLogger.getInstance();
        printLogger.log("Etiqueta", "Impresora", 2);

    }

    ;
}
