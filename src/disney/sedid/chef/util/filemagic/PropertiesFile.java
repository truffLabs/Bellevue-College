package disney.sedid.chef.util.filemagic;
import java.io.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

public class PropertiesFile {

    //String holding path to java formatted properties file
    private String pathToFile;

    //HashTable for properties
    private Properties propertiesHash = new Properties();

    //TreeMap for properties
    private TreeMap propertiesTree = new TreeMap();

    public PropertiesFile(String somePath){

        this.pathToFile = somePath;

        try
        {
            //construct FileInputStream object
            FileInputStream inputFile = new FileInputStream(pathToFile);

            //load properties from file into inputProperties object
            propertiesHash.load(inputFile);

            //load unsorted hash into TreeMap for sorting
            propertiesTree.putAll(propertiesHash);

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

    /**
     * Takes key-value pairs from propertiesHash and converts to "chef-esque" attributes file, minus comments.
     *
     */
    public void convertToChefAttributesFile()
    {
        //TODO: ideally I'd be able to figure out the whole namespace thing
        try
        {
            //open in new file in current working directory
            PrintStream outputFile = new PrintStream("/Users/pakaehua/Temp/convertedAttributes.txt");

            //TODO: Understand better
            Set<String> keys = propertiesTree.keySet();
            for(String key: keys)
            {
                outputFile.println("default['disney']['recipe']['profile']['" + key + "']=" + propertiesTree.get(key));
            }


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

    public Properties getPropertiesHash()
    {

        return this.propertiesHash;
    }

    /**
     * Sets instance variable 'propertiesHash' to values contained in new
     * @param somePropertiesFile a String object representing a path to a Java based Properties file
     */
    public void setPropertiesHash(String somePropertiesFile)
    {

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

    public TreeMap getPropertiesTree()
    {
        return propertiesTree;
    }

    public void setPropertiesTree(HashMap someHash)
    {

        propertiesTree.clear();
        propertiesTree.putAll(someHash);
    }

    public String getPathToFile()
    {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile)
    {
        this.pathToFile = pathToFile;
    }

    public String toString()
    {

        //TODO: Make more robust
        return "Path to file: " + getPathToFile();
    }
}
