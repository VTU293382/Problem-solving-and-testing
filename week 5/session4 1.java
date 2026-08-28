
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastIndex[c] > left) {
                left = lastIndex[c];
            }

            lastIndex[c] = right + 1;

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

