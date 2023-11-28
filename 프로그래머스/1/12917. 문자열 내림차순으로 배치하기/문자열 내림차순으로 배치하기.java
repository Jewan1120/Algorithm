class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    char tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}