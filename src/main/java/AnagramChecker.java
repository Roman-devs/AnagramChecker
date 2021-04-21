import java.io.*;
import java.util.*;


public class AnagramChecker {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/main/resources/words_dictionary.json.txt"));
        ArrayList<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        System.out.println("Printing Anagram from given File for abcfinlab challenge!\n");
        Map<String, List<String>> setOfAnagrams = findAnagrams(words);

        for (Map.Entry<String, List<String>> entry : setOfAnagrams.entrySet()) {
            {
                List<String> values = entry.getValue();
                String anagramsToBePrinted = values.toString();
                if (values.size() >= 2) {
                    System.out.println(">>> " + anagramsToBePrinted);
                }
            }
        }
    }

    private static Map<String, List<String>> findAnagrams(List<String> words) {
        Map<String, List<String>> anagrams = new HashMap<>();
        if (words == null || words.isEmpty()) {
            return null;
        }
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