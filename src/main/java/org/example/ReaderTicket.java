package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReaderTicket {

    // Esta clase lee el contenido de las etiquetas. Puede llegar a ser útil en algun momento.

    public void ZPLReader(File ZPLfile) throws Exception {
        FileReader fr = new FileReader(ZPLfile);
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            // Lee líneas del archivo y los despliega en la pantalla.
            System.out.println(s);
        }
        fr.close();
    }


}
