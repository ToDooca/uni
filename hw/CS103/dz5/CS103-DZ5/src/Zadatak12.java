//12.	Napisati funkciju kojom se formira lista koja sadrži sve
// različite reči unetog teksta i broj pojavljivanja svake reči


import java.util.*;

public class Zadatak12 {

    public static void main(String[] args) {
        System.out.println(countWords());
    }

    public static List<String> countWords(){
        List<String> occurrences = new ArrayList<>();
        String inputString;
        Scanner scanner = new Scanner(System.in);
        int count;
        System.out.println("Enter a string : ");
        inputString = scanner.nextLine();
        String[] wordsArray = inputString.split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : wordsArray) {
            if (map.containsKey(word)) {
                count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            occurrences.add(entry.getKey() + " : " + entry.getValue());
        }
        return occurrences;
    }

}
