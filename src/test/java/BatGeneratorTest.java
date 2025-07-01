import org.example.BatGenerator;
import org.junit.Assert;
import org.junit.Test;

public class BatGeneratorTest {

    @Test
    public void generateBatContentTest (){
        BatGenerator batGenerator = new BatGenerator();
        String rutaArchivo = "ruta_al_archivo";
        String rutaImpresora = "ruta_a_la_printer";
        batGenerator.generateBatContent(rutaArchivo , rutaImpresora);
        String batGenerated = rutaArchivo + " " + rutaImpresora;
        Assert.assertEquals("ruta_al_archivo ruta_a_la_printer", batGenerated);

    }

}
