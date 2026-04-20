/*
Your task is to write a function solution(S, Q), where S is a string of lowercase English alphabets, and Q is a list of pairs. Each pair represents a query involving two alphabets, say c1 and c2. For each query, your function should return the length of the longest sequence of consecutive characters remaining after removing all occurrences of the alphabets c1 and c2 from the string S.

Constraints:

(1≤len(S)≤1000)
(1≤len(S)≤1000)
S consists of English lowercase letters only: "abcdefghijklmnopqrstuvwxyz"
(1≤len(Q)≤10^5)
(1≤len(Q)≤10^5)
Each pair in Q contains two distinct English lowercase alphabets.
Example: Consider the function call solution("abcccacba", { {'a', 'b'}, {'b', 'c'} }). The output should be [3, 1].

In the first query, removing all 'a's and 'b's from "abcccacba" results in strings "ccc" and "c", the maximum length is 3. In the second query, removing all 'b's and 'c's from "abcccacba" yields 3 "a"s, each of length 1. Thus, the result is [3, 1].

Similarly, for solution("intelliaiassistant", { {'a', 'i'}, {'n', 't'} }), the output should be [5, 11].
 */

package unit_2;

public class RemoveLetters {
    public static int[] solution(String S, char[][] Q) {           
        int[][] precalcMaxLength = new int[26][26];
        
        for (int a = 0; a < 26; a++) {            
            for (int b = a + 1; b < 26; b++) {
                char c1 = (char)('a' + a);
                char c2 = (char)('a' + b);
                
                int maxLength = 0;
                int currentLength = 1;
                
                for (int i = 0; i < S.length(); i++) {
                    char c = S.charAt(i);
                    
                    if (c == c1 || c == c2) {
                        currentLength = 1;
                    } else {
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                        }  
                        currentLength++;                     
                    }
                }
                
                precalcMaxLength[a][b] = maxLength;
                precalcMaxLength[b][a] = maxLength;
            }
        }
            
        int[] result = new int[Q.length];
        for (int i = 0; i < Q.length; i++) {
            int a = Q[i][0] - 'a';
            int b = Q[i][1] - 'a';
                    
            result[i] = precalcMaxLength[a][b];
        }
        
        return result;
    }
}
