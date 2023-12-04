class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String str : s.split(" ")) {
            int i = Integer.parseInt(str);
            max = Integer.max(max, i);
            min = Integer.min(min, i);
        }
        return min + " " + max;
    }
}