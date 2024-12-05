class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int now = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;
        if (now == 0 || now == 43200)
            answer++;
        while (now < end) {
            double[] nowAngles = calculateAndgles(now);
            double[] nextAngles = calculateAndgles(now + 1);
            boolean isHourMatched = chkHour(nowAngles, nextAngles);
            boolean isMinMatched = chkMin(nowAngles, nextAngles);
            if (isHourMatched)
                answer++;
            if (isMinMatched)
                answer++;
            if (isHourMatched && isMinMatched)
                if (nextAngles[0] == nextAngles[1])
                    answer--;
            now++;
        }
        return answer;
    }

    private double[] calculateAndgles(int time) {
        double[] angles = new double[3];
        double h = time / 3600, m = time % 3600 / 60, s = time % 3600 % 60;
        angles[0] = (h % 12) * (360d / 12) + m * (360d / 12 / 60) + s * (360d / 12 / 3600);
        angles[1] = m * (360d / 60) + s * (360d / 60 / 60);
        angles[2] = s * (360d / 60);
        return angles;
    }

    private boolean chkHour(double[] now, double[] next) {
        double nowSec = now[2], nextSec = next[2];
        if (nowSec < now[0] && next[0] <= nextSec)
            return true;
        if (nowSec == 354d && 354d < now[0])
            return true;
        return false;
    }

    private boolean chkMin(double[] now, double[] next) {
        double nowSec = now[2], nextSec = next[2];
        if (nowSec < now[1] && next[1] <= nextSec)
            return true;
        if (nowSec == 354d && 354d < now[1])
            return true;
        return false;
    }
}