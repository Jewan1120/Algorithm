class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")){
            int i = s.replaceAll("0", "").length();
            answer[0]++;
            answer[1] += (s.length() - i);
            s = Integer.toBinaryString(i);
        }
        return answer;
    }
}