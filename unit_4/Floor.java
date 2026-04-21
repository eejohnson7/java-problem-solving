/*
You are provided with a list of integers, and your task is to define a function named solution that takes this list as input and returns another list. The returned list should contain the floor(k/3)-th smallest element for each prefix of the original list, prefix_numbers[0..k].

The function solution will take the following parameter:

An array of n integers, numbers, (
1≤n≤100000
1≤n≤100000, ∣numbers∣≤100000
∣numbers∣≤100000, where all numbers[i] are unique, and i is [0, n-1]) - the original list of integers.

The floor(k/3)-th smallest element is the element that would occupy the index floor(k/3) if the sublist prefix_numbers[0..k] were sorted in ascending order. If floor(k/3) equals the length of the sublist, return the maximum possible value from the sublist.

Constraints:

The list will contain between 1 and 100000 elements, inclusive.
Each element of the list will be an integer in the range −100000 to 100000, inclusive.
−
100000
−100000 to 
100000
100000, inclusive.
Example: For numbers = [33, 11, 44, 22, 55, 77], the function solution(numbers) should return [33, 11, 33, 22, 22, 33].

Let's break down each step and the corresponding prefix list:

For the prefix [33], k=1, floor(k/3) = floor(1/3) = 0; the sorted prefix is [33], where the element at index 0 is 33. Result so far: [33].
For the prefix [33, 11], k=2, floor(k/3) = floor(2/3) = 0; the sorted prefix is [11, 33], the element at index 0 is 11. Result so far: [33, 11].
For the prefix [33, 11, 44], k=3, floor(k/3) = floor(3/3) = 1; the sorted prefix is [11, 33, 44], the element at index 1 is 33. Result so far: [33, 11, 33].
For the prefix [33, 11, 44, 22], k=4, floor(k/3) = floor(4/3) = 1; the sorted prefix is [11, 22, 33, 44], the element at index 1 is 22. Result so far: [33, 11, 33, 22].
For the prefix [33, 11, 44, 22, 55], k=5, floor(k/3) = floor(5/3) = 1; the sorted prefix is [11, 22, 33, 44, 55], the element at index 1 is 22. Result so far: [33, 11, 33, 22, 22].
For the prefix [33, 11, 44, 22, 55, 77], k=6, floor(k/3) = floor(6/3) = 2; the sorted prefix is [11, 22, 33, 44, 55, 77], the element at index 2 is 33. Final result: [33, 11, 33, 22, 22, 33].
This example shows the calculations for each prefix of the list and demonstrates how the floor(k/3)-th smallest element is determined for each step.
*/

package unit_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Floor {
    public List<Integer> solution(List<Integer> numbers) {
        // numbers = [33, 11, 44, 22, 55, 77]
        //System.out.println("Input: " + numbers);
        
        if (numbers.size() == 1) {
            return List.of(numbers.get(0));
        }
        
        // [33] -> sorted -> [33] -> k = 1 -> floor(k/3) = 0 -> result = [33]
        // [33, 11] -> sorted -> [11, 33] -> k = 2 -> floor(k/3) = 0 -> result = [33, 11]
    
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> high = new PriorityQueue<>();
        
        for (int k = 1; k < numbers.size() + 1; k++) {
            int number = numbers.get(k - 1);
            
            if (low.isEmpty() || number < low.peek()) {
                low.add(number);
                //System.out.println("Added number to low: " + low);
                //System.out.println("Low size: " + low.size());
            } else {
                //System.out.println("Added number to high: " + high);
                high.add(number);
            }
            
            double floor = Math.floor((double) k / 3);
            
            if (low.size() > (int) floor + 1) {
                while (low.size() > floor + 1) {
                    high.add(low.poll());
                }
                //System.out.println("Rebalanced low: " + low);
                //System.out.println("Rebalanced high: " + high);
            } else if (low.size() < (int) floor + 1) {
                while (low.size() < floor + 1) {
                    low.add(high.poll());
                }
                //System.out.println("Rebalanced low: " + low);
                //System.out.println("Rebalanced high: " + high);
            }
            
            result.add(low.peek());
            //System.out.println("Added number to result: " + result);
        } 
        
        return result;
    }
}
