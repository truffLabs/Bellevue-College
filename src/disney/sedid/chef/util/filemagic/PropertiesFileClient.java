package disney.sedid.chef.util.filemagic;
import java.util.*;

public class PropertiesFileClient {

    public static void main(String Args[]){

        String someInputPath = getInputPath();
        String someOutputPath = getOutputPath();

        PropertiesFile inputPropertiesFile = new PropertiesFile(someInputPath);
        inputPropertiesFile.convertToChefAttributesFile(someOutputPath);
    }

    public static String getInputPath(){

        System.out.print("Enter path to properties file: ");
        Scanner inputFromCL = new Scanner(System.in);
        String pathToFile = inputFromCL.next();

        return pathToFile;
    }

    public static String getOutputPath(){

        System.out.print("Where do you want the output: ");
        Scanner inputFromCL = new Scanner(System.in);
        String pathToOutput = inputFromCL.next();

        return pathToOutput;
    }




}
