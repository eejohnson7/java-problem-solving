/*
You are given a list of n integers and an arbitrary integer target value target. Your task involves finding a pair of integers in the array whose sum equals the value of target. If multiple pairs satisfy this condition, choose the one with a lower index of the last element that appears in the array. If no pairs' sum equals target, return an empty list.

Constraints:

1
≤
n
≤
1000000
1≤n≤1000000
−1000000≤arr[i]≤1000000
−2000000≤target≤2000000
The program should work within 1 second.
Example:

For the input array arr = [2, 13, 4, 7, 5, 15] and a target target = 9, the output should be [2, 7] because the sum of these numbers equals 9. [4, 5] is also a valid pair, but it appears later.
 */

package unit_1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] solution(int[] arr, int target) {
        // TODO: implement a function that finds a pair of numbers whose sum equals the target
        
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int num : arr) {
            int difference = target - num;
            
            if (visited.containsKey(difference)) {
                return new int [] {difference, num};
            }
            
            visited.put(num, true);
        }
        return new int[]{};
    }
}