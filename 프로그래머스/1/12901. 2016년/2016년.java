class Solution {
    public String solution(int a, int b) {
        String[] weekendArr = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30,31};
        int sum = b;
        for(int i = 0; i < a - 1; i++){
            sum += date[i];
        }
        int weekend = (4 + sum) % 7;
        String answer = weekendArr[weekend];
        return answer;
    }
}