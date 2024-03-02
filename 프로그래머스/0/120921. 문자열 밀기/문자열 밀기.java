class Solution {
    public int solution(String A, String B) {
        int answer =0;
        boolean flg = false;
        StringBuilder sb = new StringBuilder(B);
        for(int i = 0; i < A.length(); i++){
            if(A.equals(sb.toString())){
                flg = true;
                break;
            }
            sb.append(B.charAt(i)).deleteCharAt(0);
            answer++;
        }
        return flg ? answer : -1;
    }
}