package disney.sedid.chef.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class PropertiesFile {

    private String pathToFile;
    private Scanner input;
    private File propertiesFile;

    public PropertiesFile(String somePath){

        this.pathToFile = somePath;

        try
        {
            this.propertiesFile = new File(this.pathToFile);
            this.input = new Scanner(this.propertiesFile);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        }
    }

    public void parsePropertiesFile(){


    }

    public void createTemplate ()
    {

        //test reading file and writing every line to screen
        while(input.hasNextLine())
        {

            System.out.println(input.nextLine());
        }


    }

    public void createAttributesFile(File output)
    {

        try
        {

        //initialize PrintStream object for write
        PrintStream attributesFile = new PrintStream(output);

            //test reading file and writing every line to screen
            while(input.hasNextLine())
            {
                //read each line into a String
                String oneLineString = input.nextLine();

                //instantiate new Scanner object with a single line as input
                Scanner oneLineScanner = new Scanner(oneLineString);


                //output section
                attributesFile.println(input.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        }
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String toString(){

        return "Path to file: " + getPathToFile();
    }
}
