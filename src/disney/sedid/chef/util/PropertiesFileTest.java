package disney.sedid.chef.util;
import org.junit.Test;
import java.io.File;

public class PropertiesFileTest {
    @Test
    public void testCreateTemplate() throws Exception {

        PropertiesFile p1 = new PropertiesFile("/Users/pakaehua/Code/chef/misc/profile.properties");
        //System.out.println(p1.toString());
        File f1 = new File("/Users/pakaehua/Code/chef/misc/test.out");
        p1.createAttributesFile(f1);


    }

    @Test
    public void testCreateTemplateBad() throws Exception {



    }

    @Test
    public void testCreateAttributesFile() throws Exception {

    }

    @Test
    public void testGetPathToFile() throws Exception {

    }

    @Test
    public void testSetPathToFile() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }
}
