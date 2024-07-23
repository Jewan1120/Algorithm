class Solution {
    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            int xA = arrayA[i];
            int xB = arrayB[i];
            while (xA != 0) {
                int tmp = gcdA % xA;
                gcdA = xA;
                xA = tmp;
            }
            while (xB != 0) {
                int tmp = gcdB % xB;
                gcdB = xB;
                xB = tmp;
            }
        }
        boolean chkA = false;
        boolean chkB = false;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % gcdB == 0) {
                chkB = true;
            }
            if (arrayB[i] % gcdA == 0) {
                chkA = true;
            }
        }
        if (gcdA != 1 && !chkA) {
            answer = Math.max(answer, gcdA);
        }
        if (gcdB != 1 && !chkB) {
            answer = Math.max(answer, gcdB);
        }
        return answer;
    }
}