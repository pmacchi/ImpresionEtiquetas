package org.example;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;

public class FileSelector {

    private Map<Integer, String> filesMap = new HashMap<>();

    File directorio = new File("etiquetas");

    // Filtro para recorrer unicamente archivos .txt
    private FileFilter filter = new FileFilter() {
        public boolean accept(File f) {
            return f.getName().toLowerCase().endsWith("txt");
        }
    };

    public void listFilesAndMap() {
        // Verifica si el directorio existe y es un directorio
        if (directorio.exists() && directorio.isDirectory()) {
            // Obtiene la lista de archivos y directorios
            File[] archivos = directorio.listFiles(filter);
            // Itera sobre la lista y muestra los nombres de los archivos .txt
            if (archivos != null) {
                Integer ID = 1;
                System.out.println("ID --- Articulo");
                for (File archivo : archivos) {
                    filesMap.put(ID, archivo.getName());
                    System.out.println("ID = " + ID + " Artículo = " + archivo.getName().replace(".txt" , ""));
                    ID = ID + 1;
                }
            } else {
                System.out.println("El directorio está vacío o no se pudo leer.");
            }
        } else {
            System.out.println("El directorio especificado no existe o no es un directorio.");
        }
    }

    ;

    public Map<Integer, String> getListaArchivos() {
        return filesMap;
    }

    public void setListaArchivos(Map<Integer, String> listaArchivos) {
        this.filesMap = listaArchivos;
    }

    public String getSelectedFile(int id) {
        int selectedID = id;
        if (filesMap.containsKey(selectedID)) {
            String fileSelected = filesMap.get(selectedID);
            System.out.println("Seleccionaste: " + fileSelected);
            return "etiquetas\\" + fileSelected;
        } else {

            System.out.println("Debe ingresar un ID válido, menor a " + filesMap.size());

        }
        return null;
    }

    public Map<Integer, String> getFilesMap() {
        return filesMap;
    }

    public void setFilesMap(Map<Integer, String> filesMap) {
        this.filesMap = filesMap;
    }
}
