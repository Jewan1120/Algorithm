class Solution {
    public String solution(String code) {
        boolean flg = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '1') {
                flg = !flg;
            } else {
                if (!flg && i % 2 == 0) {
                    sb.append(code.charAt(i));
                } else if (flg && i % 2 == 1) {
                    sb.append(code.charAt(i));
                }
            }
        }
        if (sb.length() == 0)
        {
            sb.append("EMPTY");
        }
        return sb.toString();
    }
}