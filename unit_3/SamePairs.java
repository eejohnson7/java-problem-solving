/*
Write a Java function named solution that calculates the number of pairs of elements in an array that have the same value. The function takes one parameter — an array of integers arr and should return an integer representing the number of pairs with equal values. An array can contain up to 100 elements, each being an integer ranging from -100 to 100, inclusive.

Time Constraints:

The solution should execute within 200 milliseconds for all inputs within the problem constraints.
Example: For arr = {1, 1, 2, 2, 1, 3}, the function should return 4. The reason being that there are three pairs of equal values (1, 1) and one pair (2, 2).
*/

package unit_3;

import java.util.HashMap;
import java.util.Map;

public class SamePairs {
    public int solution(int[] arr) {
        // int[] arr = {-100, ..., 100} (max 100 elements, -100 <= i < 100)
        
        // {1, 1, 2, 2, 3} -> 2 pairs
        // {1, 1, 2, 2, 1, 3} -> 4 pairs
        
        // initial approach -> brute force approach
        // looping through the arr getting each pair using a nested loop and using a cumulative sum to keep our solution
        
        // better approach -> count frequency of each number (k)
        // (k * (k - 1)) / 2 = # of pairs
        
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            frequencies.put(arr[i], frequencies.getOrDefault(arr[i], 0) + 1);
        }
        
        int result = 0;
        for (int num : frequencies.keySet()) {
            int k = frequencies.get(num);
            if (k > 1) {
                result += (k * (k - 1)) / 2;
            }
        }
        
        return result;
    }
}
