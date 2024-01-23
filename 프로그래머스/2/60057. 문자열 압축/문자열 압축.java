class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            int leng = s.length();
            int count = 1;
            String str = s.substring(0, i);
            for (int j = i; j <= s.length() - i; j += i) {
                String chkStr = s.substring(j, j + i);
                if (str.equals(chkStr)) {
                    leng -= i;
                    count++;
                } else {
                    if (count > 1) {
                        leng += Math.log10(count) + 1;
                    }
                    str = chkStr;
                    count = 1;
                }
            }
            if (count > 1) {
                leng += Math.log10(count) + 1;
            }
            answer = answer > leng ? leng : answer;
        }
        return answer;
    }
}
