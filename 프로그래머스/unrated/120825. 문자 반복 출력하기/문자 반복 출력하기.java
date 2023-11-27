class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        for(String str : my_string.split("")){
            sb.append(str.repeat(n));
        }
        return sb.toString();
    }
}