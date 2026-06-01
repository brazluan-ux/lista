
package gemini;

class Solution15 {
    public java.util.List<Integer> findSubstring(String s, String[] words) {
        java.util.List<Integer> res = new java.util.ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        
        int wordLen = words[0].length();
        int numWords = words.length;
        int sLen = s.length();
        
        java.util.Map<String, Integer> wordCount = new java.util.HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            java.util.Map<String, Integer> currCount = new java.util.HashMap<>();
            int count = 0;
            
            while (right + wordLen <= sLen) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                
                if (wordCount.containsKey(word)) {
                    currCount.put(word, currCount.getOrDefault(word, 0) + 1);
                    count++;
                    
                    while (currCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currCount.put(leftWord, currCount.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                    
                    if (count == numWords) {
                        res.add(left);
                    }
                } else {
                    currCount.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        
        return res;
    }
}
