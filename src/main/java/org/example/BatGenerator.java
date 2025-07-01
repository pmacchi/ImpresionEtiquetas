package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BatGenerator {


    public String generateBatContent(String rutaArchivo, String rutaImpresora) {
        String batGenerated = "@echo off\n" +
                "echo Enviando etiqueta a la impresora...\n" +
                "COPY /B \"" + rutaArchivo + "\" \"" + rutaImpresora + "\"\n" +
                "echo Impresión completada.\n";
        return batGenerated;
    }

    public File createBatFile(String content) {
        try {
            File directory = new File("C:\\Temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File file = new File(directory, "imprimir.bat");
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            System.out.println(".bat Generado Exitosamente");

            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
