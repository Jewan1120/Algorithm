class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        int startIdx = 0;
        int endIdx = num_list.length - 1;
        int k = 1;
        int j = 0;
        switch (n) {
            case 1:
                endIdx = slicer[1];
                break;
            case 2:
                startIdx = slicer[0];
                break;
            case 3:
                startIdx = slicer[0];
                endIdx = slicer[1];
                break;
            case 4:
                startIdx = slicer[0];
                endIdx = slicer[1];
                k = slicer[2];
                break;
        }
        for (int i = startIdx; i <= endIdx; i += k) {
            int[] tmp = new int[answer.length + 1];
            System.arraycopy(answer, 0, tmp, 0, answer.length);
            tmp[j] = num_list[i];
            answer = tmp;
            j++;
        }
        return answer;
    }
}