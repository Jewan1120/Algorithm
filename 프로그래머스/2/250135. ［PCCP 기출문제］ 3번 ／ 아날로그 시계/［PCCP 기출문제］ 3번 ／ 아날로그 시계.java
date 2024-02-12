class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int now = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;
        if (now == 0 || now == 43200) {
            answer++;
        }
        while (now < end) {
            double[] nowAngle = stoA(now);
            double[] nextAngle = stoA(now + 1);
            boolean hourMatch = hourChk(nowAngle, nextAngle);
            boolean minMatch = minChk(nowAngle, nextAngle);
            if (hourMatch) {
                answer++;
            }
            if (minMatch) {
                answer++;
            }
            if (hourMatch && minMatch) {
                if (Double.compare(nextAngle[0], nextAngle[1]) == 0) {
                    answer--;
                }
            }
            now++;
        }
        return answer;
    }
    
    public double[] stoA(int sec) {
        double[] angles = new double[3];
        int h = sec / 3600;
        int m = sec % 3600 / 60;
        int s = sec % 3600 % 60;
        angles[0] = (h % 12) * 30d + m * 1 / 2d + s * 1 / 120d;
        angles[1] = m * 6d + s * 1 / 10d;
        angles[2] = s * 6d;
        return angles;
    }
    
    public boolean hourChk(double[] now, double[] next) {
        double hA = now[0], sA = now[2];
        double nhA = next[0], nsA = next[2];
        if (Double.compare(hA, sA) > 0 && Double.compare(nhA, nsA) <= 0) {
            return true;
        }
        if (Double.compare(sA, 354d) == 0 && Double.compare(hA, 354d) > 0) {
            return true;
        }
        return false;
    }

    public boolean minChk(double[] now, double[] next) {
        double mA = now[1], sA = now[2];
        double nmA = next[1], nsA = next[2];
        if (Double.compare(mA, sA) > 0 && Double.compare(nmA, nsA) <= 0) {
            return true;
        }
        if (Double.compare(sA, 354d) == 0 && Double.compare(mA, 354d) > 0) {
            return true;
        }
        return false;
    }
}