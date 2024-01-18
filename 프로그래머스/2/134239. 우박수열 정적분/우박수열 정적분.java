import java.util.ArrayList;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Integer> collatz = new ArrayList<>();
        collatz.add(k);
        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = (k * 3) + 1;
            }
            collatz.add(k);
        }
        for (int i = 0; i < answer.length; i++) {
            int[] range = ranges[i];
            if (range[0] - range[1] >= collatz.size()) {
                answer[i] = -1;
                continue;
            }
            double integral = 0;
            for (int j = range[0]; j < collatz.size() + range[1] - 1; j++) {
                integral += (double) (collatz.get(j) + collatz.get(j + 1)) / 2;
            }
            answer[i] = integral;
        }
        return answer;
    }
}