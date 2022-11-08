class Solution {
    public String reverseVowels(String s) {
        char[] letters = s.toCharArray();
        int left = 0;
        int right = letters.length - 1;
        while (left < right) {
            if (Character.toLowerCase(letters[left]) != 'a' && Character.toLowerCase(letters[left]) != 'e' && Character.toLowerCase(letters[left]) != 'i' && Character.toLowerCase(letters[left]) != 'o' && Character.toLowerCase(letters[left]) != 'u') {
                left++;
            } else if (Character.toLowerCase(letters[right]) != 'a' && Character.toLowerCase(letters[right]) != 'e' && Character.toLowerCase(letters[right]) != 'i' && Character.toLowerCase(letters[right]) != 'o' && Character.toLowerCase(letters[right]) != 'u') {
                right--;
            } else {
                swap(letters, left, right);
                left++;
                right--;
            }
        }
        return String.valueOf(letters);
    }

    private void swap(char[] letters, int left, int right) {
        char temp = letters[left];
        letters[left] = letters[right];
        letters[right] = temp;
    }
}

class Solution {
    public String reverseVowels(String s) {
        char[] letters = s.toCharArray();
        int left = 0;
        int right = letters.length - 1;
        String vowels = "aeiouAEIOU";
        while (left < right) {
            if (!vowels.contains(letters[left] + "")) {
                left++;
            } else if (!vowels.contains(letters[right] + "")) {
                right--;
            } else {
                swap(letters, left, right);
                left++;
                right--;
            }
        }
        return String.valueOf(letters);
    }

    private void swap(char[] letters, int left, int right) {
        char temp = letters[left];
        letters[left] = letters[right];
        letters[right] = temp;
    }
}

class Solution {
    private HashSet<Character> record = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        int len = s.length();
        char[] letters = s.toCharArray();
        for(int i = 0, j = len - 1; i < j; i ++, j --) {
            while(i < j && !record.contains(s.charAt(i))) i ++;
            while(i < j && !record.contains(s.charAt(j))) j --;
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }

}


