class Solution {
    public int solution(String number) {
        int answer = 0;
        for(String str : number.split("")) {
            answer += Integer.parseInt(str);
        }
        return answer % 9;
    }
}