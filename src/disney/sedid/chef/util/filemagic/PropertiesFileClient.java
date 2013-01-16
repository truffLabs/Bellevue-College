package disney.sedid.chef.util.filemagic;
import java.util.*;

public class PropertiesFileClient {

    public static void main(String Args[]){

        String somePath = getPath();

        PropertiesFile inputPropertiesFile = new PropertiesFile(somePath);
        inputPropertiesFile.convertToChefAttributesFile();

    }

    public static String getPath(){

        System.out.print("Enter path to properties file: ");
        System.out.println();
        Scanner inputFromCL = new Scanner(System.in);
        String pathToFile = inputFromCL.next();

        return pathToFile;
    }




}
