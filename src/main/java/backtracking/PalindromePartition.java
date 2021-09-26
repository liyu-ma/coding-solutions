package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartition {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, s, new ArrayList<String>());

        return res;
    }

    private static void backtrack(List<List<String>> res, String s, List<String> tmp) {
        if (s.length() == 0) {
            if (tmp.size() > 0) {
                res.add(tmp);
            }
        } else {
            for (int i=0; i<s.length(); i++) {
                if (isPalindrome(s, 0, i)) {
                    List<String> list = new ArrayList<>(tmp);
                    list.add(s.substring(0, i+1));
                    backtrack(res, s.substring(i+1), list);
                }
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        if (end - start < 1) return true;

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String question = "aabaa";
        List<List<String>> partitions = partition(question);
        for(List<String> par : partitions) {
            System.out.println(par.stream().map(x -> x + " ").collect(Collectors.joining()));
        }
    }
}
