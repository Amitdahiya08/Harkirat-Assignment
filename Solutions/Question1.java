import java.util.*;

public class Main {
    
    public static String getMaxScoreString(List<String> arr) {
        String maxScoreString = "";
        int maxScore = Integer.MIN_VALUE;
        
        for (String s : arr) {
            int score = 0;
            int[] index = new int[26];
            Arrays.fill(index, 0);
            
            for (int i = 0; i < s.length(); i++) {
                if (index[s.charAt(i) - 'a'] == 0) {
                    index[s.charAt(i) - 'a'] = i + 1;
                }
                score += (s.charAt(i) - 'a') * index[s.charAt(i) - 'a'];
            }
            
            if (score > maxScore || (score == maxScore && s.compareTo(maxScoreString) < 0)) {
                maxScore = score;
                maxScoreString = s;
            }
        }
        
        return maxScoreString;
    }

    public static void main(String[] args) {
        List<String> arr = Arrays.asList("abc", "bcd", "a");
        System.out.println(getMaxScoreString(arr));  // Output: bcd
    }
}
