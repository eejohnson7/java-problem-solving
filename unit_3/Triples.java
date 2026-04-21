/*
You are given a string s composed of n lowercase alphabetic characters. Your task is to discover the number of ways to delete all characters except for three to obtain a 3-letter string, two characters of which are identical, and the other is different.

Write a Java method named solution that takes the string s as an argument and returns an integer indicating the total number of different 3-letter combinations that can be formed with two identical characters and one distinct character from the string.

Constraints:

The string s must contain at least three characters and at most 10^5 characters, i.e., 3 <= n <= 10^5.
All characters in s must be lowercase alphabetic characters.
The solution should have a time complexity of O(n).

Example:
For s = "abcabc", the output should be solution(s) = 12. The possible combinations include: "aba", "abb", "aca", "acc", "aab", "aac", "bcb", "bcc", "bab", "bbc", "cac", "cbc". Each combination consists of three characters, two of which are identical, and the third one is distinct.
*/

package unit_3;

import java.util.Arrays;

public class Triples {
    public long solution(String s) {
        // String s = "abcabc"
        System.out.println("INPUT: " + s);
        
        // # of distinct combos where "xyx" in any order
        long sol = 0;
        
        // get frequency of each character
        // 'a' -> 2
        // 'b' -> 2
        // 'c' -> 2
        long[] freqs = new long[26];
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i) - 'a'] += 1;
        }
        System.out.println(Arrays.toString(freqs));
        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j) {
                    sol += chooseIdentical(freqs[i]) * freqs[j];
                }
            }
        }
        
        return sol;
    }
    
    // how many ways can we pick 2 copies of x with a given frequency
    private long chooseIdentical(Long freq) {
        return (freq * (freq - 1)) / 2;
    }
}
