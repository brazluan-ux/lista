package claude;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution5 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> current = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String w = s.substring(right, right + wordLen);
                right += wordLen;
                if (wordMap.containsKey(w)) {
                    current.put(w, current.getOrDefault(w, 0) + 1);
                    while (current.get(w) > wordMap.get(w)) {
                        String leftWord = s.substring(left, left + wordLen);
                        current.put(leftWord, current.get(leftWord) - 1);
                        left += wordLen;
                    }
                    if (right - left == totalLen) {
                        result.add(left);
                    }
                } else {
                    current.clear();
                    left = right;
                }
            }
        }
        return result;
    }
}

