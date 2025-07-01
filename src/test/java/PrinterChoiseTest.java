import org.example.PrinterChoise;
import org.junit.Assert;
import org.junit.Test;

public class PrinterChoiseTest {

    @Test
    public void printerReaderTest () throws Exception {
        PrinterChoise printerChoise = new PrinterChoise();
        printerChoise.printerReader();
        System.out.println(printerChoise.getPrinterMap().keySet());
        System.out.println(printerChoise.getPrinterMap());
    }

    @Test
    public void showPrintersTest () throws Exception {
        PrinterChoise printerChoise = new PrinterChoise();
        printerChoise.printerReader();
        printerChoise.showPrinters();
    }

    @Test
    public void printerSelectTest () throws Exception {
        PrinterChoise printerChoise = new PrinterChoise();
        printerChoise.printerReader();
        printerChoise.printerSelect(3);
        Assert.assertEquals("\\\\srvontps1\\ZE-ONT-Armado3" , printerChoise.getPrinterMap().get(3));
    }
}
