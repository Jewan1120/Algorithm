class Solution {
    public int[] solution(int[] emergency) {
        int[] array = new int[emergency.length];
        int[] answer = new int[emergency.length];
        System.arraycopy(emergency, 0, array, 0, emergency.length);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < emergency.length; j++) {
                if (emergency[i] == array[j]) {
                    answer[i] = j + 1;
                }
            }
        }
        return answer;
    }
}