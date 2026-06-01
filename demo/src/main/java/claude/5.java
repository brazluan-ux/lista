package claude;

class Solution5 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        
        if (s.length() < totalLen) {
            return result;
        }
        
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            
            while (j < wordCount) {
                int wordIndex = i + j * wordLen;
                String word = s.substring(wordIndex, wordIndex + wordLen);
                
                if (!wordMap.containsKey(word)) {
                    break;
                }
                
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                
                if (seen.get(word) > wordMap.get(word)) {
                    break;
                }
                
                j++;
            }
            
            if (j == wordCount) {
                result.add(i);
            }
        }
        
        return result;
    }
}

