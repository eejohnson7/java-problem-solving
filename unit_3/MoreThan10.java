/*
You are provided with an array of n integers, which are guaranteed to be distinct. The task requires you to craft a function 
solution that returns the count of pairs of numbers whose absolute difference is more than 10. The solution should find the answer 
within 3 seconds, so pay attention to write a time-efficient one.
 */

package unit_3;

import java.util.Arrays;

public class MoreThan10 {
    public long solution(int[] arr) {
        Arrays.sort(arr);
        
        int n = arr.length;  
        int right = 1;
        long count = 0;
                        
        for (int left = 0; left < n; left++) {            
            while (right < arr.length && arr[right] - arr[left] <= 10) {
                right++;
            }
            
            if (right < n) {
                count += n - right;
            }
        }
                
        return count;
    }
}
