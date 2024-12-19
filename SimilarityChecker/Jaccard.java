

package SimilarityChecker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings({"unused"})
public class Jaccard {
    private String[] originalSentence;

    /**
     *
     * @param original The original text to compare against
     */
    public Jaccard(String original) {
        this.originalSentence = original.toLowerCase().replaceAll("[^a-z0-9. ]", "").replaceAll("\\. ", ".").split("\\.");
    }

    /**
     
      @param newOriginal 
     
    public void changeOriginal(String newOriginal) {
        this.originalSentence = newOriginal.toLowerCase().replaceAll("[^a-z0-9. ]", "").replaceAll("\\. ", ".").split("\\.");
    }

    /**
     *Implementation of the Jaccard algorithm for comparing strings.
     *
     * @param plagiarized 
     * @return 
     */
    public double jaccardImplementation(String plagiarized) {
        if (originalSentence == null) {
            System.out.println("Please define the original text to compare against.\n");
            return Double.NaN;
        }

        // Saving as a list
        // Spliting the strings
        List<String> plagiarizedBag = Arrays.asList(plagiarized.toLowerCase().replaceAll("[^a-z0-9 ]", "").split(" "));

        // Declare a list to store the copied and original sentence
        double max = 0, maximum = 0;
        List<String> copied, originalString;

        for (String sentence : this.originalSentence) {
            // Splitting the sentence

            originalString = Arrays.asList(sentence.split(" "));
            copied = new ArrayList<>(plagiarizedBag);

            // Find the similarity
            copied.retainAll(originalString);

            // Calculate the amount of plagiarism
            double amountPlagiarized = (double) copied.size() / (originalString.size() + plagiarizedBag.size() - copied.size());

            // Plagiarism value
            if (amountPlagiarized > max) {
                max = amountPlagiarized;
                maximum = copied.size();
            }
        }

        // Return the number of words plagiarized
        return maximum;
    }
}
