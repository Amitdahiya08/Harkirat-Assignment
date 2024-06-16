import java.util.HashMap;

public class CompleteCyclePairs {

    public static int completeCyclePairs(int k, int[] distances) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        int count = 0;
        
        for (int distance : distances) {
            int remainder = distance % k;
            int complement = (k - remainder) % k;
            
            if (remainderCount.containsKey(complement)) {
                count += remainderCount.get(complement);
            }
            
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] distances1 = {2, 7, 5, 4, 6};
        int k1 = 10;
        System.out.println(completeCyclePairs(k1, distances1)); // Output: 3
        
        int[] distances2 = {3, 6, 9, 4};
        int k2 = 12;
        System.out.println(completeCyclePairs(k2, distances2)); // Output: 1
        
        int[] distances3 = {2, 4, 6, 8, 1, 3, 5};
        int k3 = 8;
        System.out.println(completeCyclePairs(k3, distances3)); // Output: 2
    }
}
