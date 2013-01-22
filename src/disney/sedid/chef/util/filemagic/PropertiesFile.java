package disney.sedid.chef.util.filemagic;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.Scanner;

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
    /**
    public void convertToChefAttributesFile(String pathToOutput)
    {
        //TODO: ideally I'd be able to figure out the whole namespace thing
        try
        {
            PrintStream outputFile = new PrintStream(pathToOutput);

            //TODO: Understand better
            Set<String> keys = propertiesTree.keySet();
            for(String key: keys)
            {
                outputFile.println("default['profile']['" + key + "']=" + propertiesTree.get(key));
            }


        }
        catch (FileNotFoundException e)
        {
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        }

    }

    **/

    public void convertToChefAttributesFile(String pathToOutput)
    {
        //TODO: ideally I'd be able to figure out the whole namespace thing
        try
        {

            //read in line from profile.properties
            Scanner inputFromFile = new Scanner(new File (this.pathToFile));

            //open output file
            //PrintStream outputFile = new PrintStream(pathToOutput);

            //sort keys
            Set<String> keys = propertiesTree.keySet();

            while(inputFromFile.hasNextLine())
            {

                String oneLine = inputFromFile.nextLine();

                //if first character of line is '#' -> print to output
                if(oneLine.startsWith("#"))
                {
                    System.out.println(oneLine);
                }
                else
                {
                    for(String key: keys)
                    {
                        if(key.substring(0,3).equals("val"))
                        {

                            System.out.println("default['profile']['" + key + "']=" + propertiesTree.get(key));
                        }
                    }


                }



            }

            //if begins with '#' -> print to output

            //if line does not begin with 'dev', 'qa', 'stg', or 'prod' ->
            //print to line

            //if line begins with 'dev', 'qa', 'stg', or 'prod' ->
            //search for matching key in hashTable
            //print key and value


            //open in new file in current working directory


        }
        catch (FileNotFoundException e)
        {
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
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
