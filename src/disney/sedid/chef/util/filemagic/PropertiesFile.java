package disney.sedid.chef.util.filemagic;
import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    //String holding path to java formatted properties file
    private String pathToFile;

    //HashTable for properties
    private Properties propertiesHash = new Properties();

    public PropertiesFile(String somePath){

        this.pathToFile = somePath;

        try
        {
            //construct FileInputStream object
            FileInputStream inputFile = new FileInputStream(pathToFile);

            //load properties from file into inputProperties object
            propertiesHash.load(inputFile);

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

    public Properties getPropertiesHash(){

        return this.propertiesHash;
    }

    /**
     * Sets instance variable 'propertiesHash' to values contained in new
     * @param somePropertiesFile a String object representing a path to a Java based Properties file
     */
    public void setPropertiesHash(String somePropertiesFile){

        try
        {
            //clear HashTable in case it already exists
            propertiesHash.clear();

            //construct FileInputStream object
            FileInputStream inputFile = new FileInputStream(somePropertiesFile);

            //load properties from file into inputProperties object
            propertiesHash.load(inputFile);

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

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String toString(){

        //TODO: Make more robust
        return "Path to file: " + getPathToFile();
    }
}
