Programa de Impresión de Etiquetas 
-----------------------------------

Este programa está dedicado a todos los que buscan la eficiencia y la precisión en la impresión de etiquetas.

Descripción General:
--------------------
Este programa permite seleccionar e imprimir etiquetas ZPL desde una carpeta compartida. 
El usuario puede elegir la etiqueta y la impresora, así como la cantidad de etiquetas a imprimir. 
El programa también registra un log de todas las impresiones realizadas.

Estructura del Código:
----------------------
1. Main.java:
   - Punto de entrada del programa.
   - Muestra un menú para seleccionar etiquetas e impresoras.
   - Solicita la cantidad de etiquetas a imprimir.
   - Ejecuta el archivo .bat para imprimir las etiquetas.
   - Registra las impresiones en un archivo de log.

2. FileSelector.java:
   - Lista y mapea los archivos de etiquetas disponibles.
   - Devuelve la ruta del archivo seleccionado.

3. PrinterChoise.java:
   - Lee y muestra las impresoras disponibles.
   - Devuelve la ruta de la impresora seleccionada.

4. BatGenerator.java:
   - Genera el contenido del archivo .bat para la impresión.
   - Crea el archivo .bat.

5. BatExecutor.java:
   - Ejecuta el archivo .bat generado.
   - Lee y muestra la salida del proceso de impresión.

6. PrintLogger.java:
   - Registra las impresiones en un archivo de log.
   - Incluye la fecha, hora, etiqueta, impresora y cantidad de etiquetas impresas.

Advertencia:
------------
Por favor, no modifique ni mueva los archivos de esta carpeta. 
Cualquier cambio puede afectar el funcionamiento del programa.

---------
¡Gracias por usar el Programa de Impresión de Etiquetas!
