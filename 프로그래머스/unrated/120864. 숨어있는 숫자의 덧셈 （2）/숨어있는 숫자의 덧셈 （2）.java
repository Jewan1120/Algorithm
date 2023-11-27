class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(String str : my_string.split("[A-z]")){
            if(str.equals("")){
                continue;
            }
            answer += Integer.parseInt(str);
        }
        return answer;
    }
}