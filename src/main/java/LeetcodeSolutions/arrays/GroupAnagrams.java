package LeetcodeSolutions.arrays;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<List<String>> group = group(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"));
        for(List<String> strings : group) {
            for(String s: strings) {
                System.out.print(s + ", ");
            }
            System.out.println(" ");
        }
    }

    public static List<List<String>> group(List<String> strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] temp = new char[26];
            for(char c: s.toCharArray()) {
                temp[Character.toLowerCase(c) - 'a']++; // ASCII 0 -> 'NULL'       ASCII 1 -> 'SOH'
            }
            String key = String.valueOf(temp); //                        
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
