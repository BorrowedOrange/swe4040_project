
import java.io.File;
import java.io.PrintWriter;

/**
 * Test Class
 *
 *
 * @version 1.5.0
 */
public class Test {
    /**
     * main() Method:
     * @param args 
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        // Declaring variables 
        File originals, duplicates;

        // The user specifies the location 
        // Else use the default project folder.
        if (args.length != 2) {
            originals = new File("Evaluation/Original");
            duplicates = new File("Evaluation/Plagiarized");
        } else {
            originals = new File(args[0]);
            duplicates = new File(args[1]);
        }

        // Declare an array to store all the files in the folders
        File[] originalList = originals.listFiles();
        File[] duplicateList = duplicates.listFiles();

        // Declare a variable to write to the output CSV file
        PrintWriter output = new PrintWriter("Evaluation/output.csv");

        // Check that the duplicateList and originList is not undefined
        assert duplicateList != null;
        assert originalList != null;

        // For every file in the duplicate-list
        for (File duplicate : duplicateList) {
            
            if (duplicate.isFile()) {
                // Output to the csv file
                output.print(duplicate.getName() + ",");

                for (File origin : originalList) {
                    // If all good above calculate the plagiarism against this one and write it to the CSV
                    if (origin.isFile()) {
                        double value = DriverProgram.driverProgram(origin, duplicate);
                        output.print(value + ",");
                    }
                }

                // Move to the next line.
                output.print("\n");
            }
        }

        // Close the output file
        output.close();
    }
}
