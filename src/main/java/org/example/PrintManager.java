package org.example;

import java.util.Scanner;

public class PrintManager {

    public void printTicket () throws Exception {
        Scanner choise = new Scanner(System.in);
        String contin;
        Integer ticketNumber = 0;
        Integer printerNumber = 0;
        Boolean isActive = true;

        KonsolaUtils konsolaUtils = new KonsolaUtils();

        System.out.println();
        System.out.println();
        Banners banners = new Banners();
        banners.startBanner();
        System.out.println();
        System.out.println();
        System.out.println("Programa de Impresion de Etiquetas Pablo");
        System.out.println();
        System.out.println("Presione una tecla para continuar...");
        System.out.print("Presione Q para salir.");
        System.out.println();

        contin = choise.nextLine().toLowerCase().trim();
        konsolaUtils.limpiarConsola();
        if (!contin.equals("q")) {
            isActive = true;
            while (isActive) {
                System.out.println();
                System.out.println();
                banners.ticketBanner();
                System.out.println();

                FileSelector selectorDeArchivo = new FileSelector();
                selectorDeArchivo.listFilesAndMap();

                String selectedFilePath = null;
                boolean validFileSelected = false;

                System.out.println();
                while (!validFileSelected) {
                    System.out.print("Elija por ID qué etiqueta desea imprimir: ");
                    if (choise.hasNextInt()) {
                        ticketNumber = choise.nextInt();
                        selectedFilePath = selectorDeArchivo.getSelectedFile(ticketNumber);
                        if (selectedFilePath != null) {
                            validFileSelected = true;

                        }
                    } else {
                        System.out.println("Debe ingresar un número válido.");
                        choise.next(); // limpiar entrada inválida
                    }
                }

                konsolaUtils.limpiarConsola();
                System.out.println();
                banners.printerBanner();
                System.out.println();
                PrinterChoise printerChoise = new PrinterChoise();
                printerChoise.printerReader();
                printerChoise.showPrinters();

                String selectedPrinterPath = null;
                boolean validPrinterSelected = false;
                System.out.println();
                while (!validPrinterSelected) {
                    System.out.print("Elija por ID la Impresora: ");
                    if (choise.hasNextInt()) {
                        printerNumber = choise.nextInt();
                        selectedPrinterPath = printerChoise.printerSelect(printerNumber);
                        if (selectedPrinterPath != null) {
                            validPrinterSelected = true;

                        }
                    } else {
                        System.out.println("Debe ingresar un número válido.");
                        choise.next(); // limpiar entrada inválida
                    }
                }


                System.out.println();
                BatGenerator batGenerator = new BatGenerator();
                batGenerator.createBatFile(
                        batGenerator.generateBatContent(
                                selectorDeArchivo.getSelectedFile(ticketNumber),
                                printerChoise.printerSelect(printerNumber)
                        )
                );
                konsolaUtils.limpiarConsola();
                System.out.println();
                System.out.println();

                banners.quantityBanner();

                System.out.println();
                System.out.print("¿Cuántas etiquetas desea imprimir?: ");
                int cantidad = 1;
                if (choise.hasNextInt()) {
                    cantidad = choise.nextInt();

                    if (cantidad > 20) {
                        System.out.print("Está por imprimir " + cantidad + " etiquetas. ¿Está seguro? (S para confirmar): ");
                        choise.nextLine(); // limpiar buffer
                        String confirmacion = choise.nextLine().toLowerCase().trim();

                        if (!confirmacion.equals("s")) {
                            System.out.println("Impresión cancelada por el usuario.");
                            continue; // vuelve al inicio del bucle
                        }
                    }

                } else {
                    System.out.println("Entrada inválida. Se imprimirá 1 etiqueta por defecto.");
                    choise.next(); // limpiar entrada inválida

                }

                BatExecutor batExecutor = new BatExecutor();
                batExecutor.runBat(cantidad);


// Registrar en el log
                PrintLogger logger = PrintLogger.getInstance();
                logger.log(
                        selectorDeArchivo.getSelectedFile(ticketNumber),
                        printerChoise.printerSelect(printerNumber),
                        cantidad
                );

                konsolaUtils.limpiarConsola();
                System.out.println();
                System.out.print("¿Desea imprimir otra etiqueta? (Q para salir, cualquier otra tecla para continuar): ");
                System.out.println();
                choise.nextLine(); // Limpiar buffer
                contin = choise.nextLine().toLowerCase().trim();
                if (contin.equals("q")) {
                    isActive = false;
                }


            }
            System.out.println();
            banners.endBanner();
            System.out.println();
            System.out.println("Saliendo del programa...");
            System.out.println();
            choise.close();


        } else {
            System.out.println();
            banners.endBanner();
            System.out.println();
            isActive = false;
            System.out.println("Saliendo del programa...");
        }
    }
}
