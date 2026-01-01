package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    static final int MAX_CHAR = 26;
    public static void main(String[] args) {
        String[] arr = {"act", "god", "cat", "dog", "tac"};

        Map<String, List<String>> res = anagrams(arr);

        for (Map.Entry<String,List<String>> group : res.entrySet()) {
                System.out.print(group.getValue());
                System.out.println();
        }
    }

    private static Map<String, List<String>> anagrams(String[] arr) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String s : arr){
            int[] freq = new int[MAX_CHAR];
            for(char ch : s.toCharArray()){
                freq[ch - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for(int i=0;i<MAX_CHAR;i++){
                key.append("#").append(freq[i]);
            }
            mp.computeIfAbsent(key.toString(), k->new ArrayList<>()).add(s);
        }

        return mp;
    }
}
