class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int now = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;
        int h = h1, m = m1, s = s1;
        float ihA = 1f / 120, imA = 1f / 10, isA = 6;
        float hA = (now * ihA) % 360, mA = (now * imA) % 360, sA = (now * isA) % 360;
        while (now < end) {
            if (sA < hA && hA + ihA <= sA + isA) {
                answer++;
            }
            if (sA < mA && mA + imA <= sA + isA) {
                answer++;
            }
            now++;
            hA = (hA + ihA) % 360;
            mA = (mA + imA) % 360;
            sA = (sA + isA) % 360;
        }
        return answer;
    }
}