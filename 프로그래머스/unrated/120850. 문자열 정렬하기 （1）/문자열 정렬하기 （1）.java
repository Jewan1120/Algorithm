class Solution {
    public int[] solution(String my_string) {
        my_string = my_string.replaceAll("[A-z]", "");
        int[] answer = new int[my_string.length()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Character.getNumericValue(my_string.charAt(i));
        }
        for (int i = 0; i < answer.length - 1; i++) {
            for (int j = 0; j < answer.length - 1 - i; j++) {
                if (answer[j] > answer[j + 1]) {
                    int tmp = answer[j];
                    answer[j] = answer[j + 1];
                    answer[j + 1] = tmp;
                }
            }
        }
        return answer;
    }
}