import org.example.FileSelector;
import org.junit.Assert;
import org.junit.Test;

public class FileSelectorTest {

    @Test
    public void listFilesAndMapTest () {
        FileSelector fileSelector = new FileSelector();
        fileSelector.listFilesAndMap();
    }

    @Test
    public void getSelectedFileTest () {
        FileSelector fileSelector = new FileSelector();
        fileSelector.listFilesAndMap();

        Assert.assertEquals("BUMPER.txt" , fileSelector.getFilesMap().get(6));
    }
}
