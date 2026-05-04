package unit_5;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*
You are tasked with designing a Java method called solution() that processes a series of distinct requests or operations. These operations consist of a list of two integers: one signifies the type of operation, and the other is the operand.

There are three kinds of actions you will need to handle:

Adding a number to the set (operation type 0). If the number is already in the set, you should ignore it.
Removing a number from the set (operation type 1). Whenever this operation is invoked, it is guaranteed that the number exists in the set.
Finding the maximum number in the set (operation type 2).
The list of operations is delivered to your method as a 2D array, where each subarray contains two values — the type of operation and the operand.

The function should output an array of results for every operation. For operation types 0 and 1, the function should return the count of elements in the set after the operation. For operation type 2, the function should return the maximum number in the set. If the set is empty, the function should return -1.

Constraints: The number of operations 1≤n≤10^5. For the operation parameter, 0≤operation≤2. For the operand parameter, −10^5≤operand≤10^5. 
Example: For operations = {{0, 20}, {0, 30}, {2}, {1, 20}, {0, 20}, {2}}, the output should be {1, 2, 30, 1, 2, 30}.
*/

public class Operations {
    public List<Integer> solution(int[][] operations) {
        List<Integer> results = new ArrayList<>();
        TreeSet<Integer> sortedStream = new TreeSet<>();
        
        for (int[] operation : operations) {
            int operationType = operation[0];
            
            if (operationType == 0) {
                int operand = operation[1];
                
                if (!sortedStream.contains(operand)) {
                    sortedStream.add(operand);
                }
                
                results.add(sortedStream.size());
            } else if (operationType == 1){
                int operand = operation[1];
                
                sortedStream.remove(operand);
                results.add(sortedStream.size());
            } else if (operationType == 2) {
                if (sortedStream.size() < 1) {
                    results.add(-1);
                } else {
                    results.add(sortedStream.last());
                }
            }
        }
        
        return results;
    }
}
