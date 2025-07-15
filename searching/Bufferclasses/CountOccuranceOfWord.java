import java.io.*;

public class CountOccuranceOfWord {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("sample.txt");
        BufferedReader br = new BufferedReader(fr);
        String wordToFind = "hello";
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equalsIgnoreCase(wordToFind)) {
                    count++;
                }
            }
        }
        System.out.println("The word '" + wordToFind + "' occurs: " + count + " times.");
        br.close();
        fr.close();
    }
}