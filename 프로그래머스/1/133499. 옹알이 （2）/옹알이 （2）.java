class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling){
            str = str.replaceAll("((aya){2,}|(ye){2,}|(woo){2,}|(ma){2,})", "-");
            str = str.replaceAll("(aya|ye|woo|ma)", "");
            if(str.trim().length() == 0){
                answer++;
            }
        }
        return answer;
    }
}