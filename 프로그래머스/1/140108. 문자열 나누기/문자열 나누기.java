class Solution {
    public int solution(String s) {
        int answer = 0;
        String x = "";
        boolean chk = false;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            String chkStr = String.valueOf(s.charAt(i));
            if(!chk){
                x = chkStr;
                chk = !chk;
                count++;
            }else if(x.equals(chkStr)){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                answer++;
                chk = !chk;
            }
        }
        if(count != 0){
            answer++;
        }
        return answer;
    }
}