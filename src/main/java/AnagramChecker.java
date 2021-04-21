import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.*;


public class AnagramChecker {

    static int size;
    static int count;
    static char[] charArray;
    static char[] words;


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("/Users/roman/Documents/CODE/Coding Challenge No.1/src/main/resources/words_dictionary.json.txt"));
        ArrayList<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Printing Anagram from given File for abcfinlab challenge!\n");
        Map<String, List<String>> Anagrams = findAnagrams(words);

        for (Map.Entry<String, List<String>> entry : Anagrams.entrySet()) {
            {
                List<String> values = entry.getValue();
                String a = values.toString();
                a = a.substring(1, a.length() - 1);
                if (values.size() >= 2) {
                    System.out.println(">>> " + a);
                }
            }
        }
    }

    private static Map<String, List<String>> findAnagrams(List<String> words) {
        Map<String, List<String>> anagrams;
        if (words == null || words.isEmpty()) {
            return null;
        }
        anagrams = new HashMap<>();
        for (String word : words) {
            if (word.length() > 1) {
                char[] charArray = word.trim().toCharArray();
                Arrays.sort(charArray);
                String sortedWord = String.valueOf(charArray);
                if (anagrams.containsKey(sortedWord)) {
                    List<String> newList = anagrams.get(sortedWord);
                    newList.add(word);
                    anagrams.put(sortedWord, newList);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(word);
                    anagrams.put(sortedWord, list);
                }
            }
        }
        return anagrams;
    }
}