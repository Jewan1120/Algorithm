class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String str = toBinaryString(numbers[i]);
            answer[i] = chkInOrder(str, 0, str.length() - 1) ? 1 : 0;
        }
        return answer;
    }

    private String toBinaryString(long number) {
        StringBuilder sb = new StringBuilder(Long.toBinaryString(number));
        int n = 1;
        while (sb.length() > (1 << n) - 1) {
            n++;
        }
        sb.insert(0, "0".repeat((1 << n) - 1 - sb.length()));
        return sb.toString();
    }

    private boolean chkInOrder(String str, int l, int r) {
        if (l == r)
            return true;
        int rootIdx = (l + r) / 2;
        if (str.charAt(rootIdx) == '0')
            for (int i = l; i <= r; i++)
                if (str.charAt(i) == '1')
                    return false;
        return chkInOrder(str, l, rootIdx - 1) && chkInOrder(str, rootIdx + 1, r);
    }
}