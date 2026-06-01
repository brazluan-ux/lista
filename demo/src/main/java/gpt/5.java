package gpt;

class Solution20 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;

        int wordLen = words[0].length();
        int k = words.length;
        int totalLen = wordLen * k;
        if (wordLen == 0 || s.length() < totalLen) return res;

        Map<String, Integer> need = new HashMap<>();
        for (String w : words) need.put(w, need.getOrDefault(w, 0) + 1);

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset;
            int count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {
                String w = s.substring(right, right + wordLen);

                if (!need.containsKey(w)) {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                window.put(w, window.getOrDefault(w, 0) + 1);
                count++;

                while (window.get(w) > need.get(w)) {
                    String lw = s.substring(left, left + wordLen);
                    int v = window.get(lw) - 1;
                    if (v == 0) window.remove(lw);
                    else window.put(lw, v);
                    left += wordLen;
                    count--;
                }

                if (count == k) {
                    res.add(left);
                    String lw = s.substring(left, left + wordLen);
                    int v = window.get(lw) - 1;
                    if (v == 0) window.remove(lw);
                    else window.put(lw, v);
                    left += wordLen;
                    count--;
                }
            }
        }

        return res;
    }
}

