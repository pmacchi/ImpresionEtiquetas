package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


public class PrinterChoise {
    public Map<Integer, String> getPrinterMap() {
        return printerMap;
    }

    public void setPrinterMap(Map<Integer, String> printerMap) {
        this.printerMap = printerMap;
    }

    private Map<Integer, String> printerMap = new HashMap<>();

    File printerFile = new File("Printers.txt");

    public void printerReader() throws Exception {
        FileReader fr = new FileReader(printerFile);
        BufferedReader br = new BufferedReader(fr);
        Integer printerID = 1;
        String s;
        while ((s = br.readLine()) != null) {
            // Lee líneas del archivo y los despliega en la pantalla.
            printerMap.put(printerID, s);
            printerID = printerID + 1;

        }
        fr.close();
    }

    public void showPrinters() {
        for (Map.Entry<Integer, String> entry : printerMap.entrySet()) {
            System.out.println("ID : " + entry.getKey() + ", IMPRESORA : " + entry.getValue().replace("\\\\ad.midominio.com.ar\\" , "") + " ");

            }
        }



    ;

    public String printerSelect(int id) {
        int selectedID = id;
        if (printerMap.containsKey(selectedID)) {
            String printerSelected = printerMap.get(selectedID);
            System.out.println("Seleccionaste: " + printerSelected);
            return printerSelected;
        } else {
            System.out.println("Debe ingresar un ID válido");
        }
        return null;
    }


}

