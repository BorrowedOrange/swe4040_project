
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 
 *
 * @version 1.0.0
 */
class DriverProgram {
    /**
     Getting data from 2 entire files and save it as a String
     *
     * @param src  
     * @param plag 
     * @return 
     * @throws Exception 
     */
    static double driverProgram(File src, File plag) throws Exception {
        BufferedReader srcRead = new BufferedReader(new FileReader(src));
        BufferedReader plagRead = new BufferedReader(new FileReader(plag));

        // Declare a string builder to read the line from the file into that string
        // Also declaring a temporary string 
        StringBuilder source = new StringBuilder(), plagiarized = new StringBuilder();
        String temp;

        // Reading every line from the source file 
        while ((temp = srcRead.readLine()) != null) {
            source.append(temp);
        }

        //Basically just repaets
        while ((temp = plagRead.readLine()) != null) {
            plagiarized.append(temp);
        }

        srcRead.close();
        plagRead.close();

        // Return the plagiarism level for the entire file system
        return WholeFileChecker.checkWholeFile(source.toString(), plagiarized.toString());
    }
}
