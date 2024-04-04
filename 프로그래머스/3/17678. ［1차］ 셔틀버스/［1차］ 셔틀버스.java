import java.util.Arrays;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] times = convIntArr(timetable);
        Arrays.sort(times);
        int start = 9 * 60;
        int cnt = m;
        int idx = 0;
        int con = 0;
        for (int i = 0; i < n; i++) {
            while (idx < times.length && times[idx] <= start) {
                cnt--;
                idx++;
                if (cnt == 0) {
                    break;
                }
            }
            if (i == n - 1) {
                if (cnt > 0) {
                    con = start;
                } else {
                    con = times[idx - 1] - 1;
                }
            }
            cnt = m;
            start += t;
        }
        return String.format("%02d:%02d", con / 60, con % 60);
    }
    
    public int[] convIntArr(String[] timetable) {
        int len = timetable.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            String[] strArr = timetable[i].split(":");
            arr[i] = Integer.parseInt(strArr[0]) * 60 + Integer.parseInt(strArr[1]);
        }
        return arr;
    }
}