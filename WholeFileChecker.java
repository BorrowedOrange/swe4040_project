
import SimilarityChecker.Jaccard;

/**
Checking similarities between whole files
 
 * @version 1.0.0
 */
class WholeFileChecker {
    /**
     * @param origin 
     * @param copied 
     * @return 
     */
    static double checkWholeFile(String origin, String copied) {
        // Split the string
        String[] copiedArray = copied.split("\\. ");

        // Get the number of words in the copied string.
        int totalPlagiarized = 0;
        int totalWords = copied.split("\\s+").length;

        // Declare an instance of the Jaccard algorithm
        Jaccard useJaccard = new Jaccard(origin);

        // For every string in the list of copied sentences
        for (String sentence : copiedArray) {
            // Sum up its plagiarized count.
            totalPlagiarized += useJaccard.jaccardImplementation(sentence);
        }

        double plagiarizedValue = (double) totalPlagiarized / totalWords;

        if (plagiarizedValue >= 1) {
            // Return their percentage of plagiarism.
            return 1;
        } else {
            return plagiarizedValue;
        }
    }
}
