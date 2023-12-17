class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                StringBuilder sb = new StringBuilder(Long.toBinaryString(numbers[i]));
                if (sb.indexOf("0") < 0) {
                    sb.insert(1, "0");
                } else {
                    int c = sb.lastIndexOf("0");
                    sb.replace(c, c + 2, "10");
                }
                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }
        return answer;
    }
}