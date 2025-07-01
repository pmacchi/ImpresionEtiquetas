package org.example;

import java.io.*;

public class BatExecutor {

    private String filePath = "C:\\Temp\\imprimir.bat";

    public void runBat(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", filePath);
                processBuilder.redirectErrorStream(true);
                Process proceso = processBuilder.start();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        System.out.println(linea);
                    }
                }

                int exitCode = proceso.waitFor();
                System.out.println("Impresión " + (i + 1) + " finalizada con código: " + exitCode);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
