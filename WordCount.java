import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        
        File file = new File("C:\\Users\\miha1\\Documents\\CEN 3024\\The Raven.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        Map<String, Long> counts = new HashMap<>();
        while ((line = br.readLine()) != null) {
            
        	String[] words = line.split("[\\s.;,?:!()\"]+");
            for (String word : words) {
                word = word.trim();
                if (word.length() > 0) {
                    if (counts.containsKey(word)) {
                        counts.put(word, counts.get(word) + 1);
                    } else {
                        counts.put(word, 1L);
                    }
                }
            }
        }
        for (Map.Entry<String, Long> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        br.close();
    }
}
