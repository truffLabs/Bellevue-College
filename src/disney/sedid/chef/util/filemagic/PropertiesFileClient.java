package disney.sedid.chef.util.filemagic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileClient {

    public static void main(String Args[]){

        //read the properties file into a HashTable
        try
        {
            //construct FileInputStream object
            FileInputStream inputFile = new FileInputStream("/Users/pakaehua/Code/chef/misc/profile.properties");

            //construct Properties object
            Properties inputProperties = new Properties();

            //load properties from file into inputProperties object
            inputProperties.load(inputFile);

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("Caught IOException: " + e.getMessage());
        }

    }




}
