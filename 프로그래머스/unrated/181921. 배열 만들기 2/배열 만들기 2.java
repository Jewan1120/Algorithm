class Solution {
    public int[] solution(int l, int r) {
        
        String str = "";
        String condition = "12346789";
        StringBuilder sb = new StringBuilder();
        
        next: for (int i = l; i <= r; i++) {
            str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (condition.indexOf(str.charAt(j)) != -1) {
                    continue next;
                }
            }
            sb.append(i + ",");
        }
        if (sb.length() == 0) {
            sb.append(-1);
        }
        String[] tmpStr = sb.toString().split(",");
        int[] answer = new int[tmpStr.length];
        for (int i = 0; i < tmpStr.length; i++) {
            answer[i] = Integer.parseInt(tmpStr[i]);
        }
        return answer;
    }
}