class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length - 5];

        for (int i = 0; i < num_list.length - 1; i++) {
          for (int j = 0; j < num_list.length - 1; j++) {
            if (num_list[j] >= num_list[j + 1]) {
              int tmp = num_list[j + 1];
              num_list[j + 1] = num_list[j];
              num_list[j] = tmp;
            }
          }
        }
        System.arraycopy(num_list, 5, answer, 0, num_list.length - 5);
        return answer;
    }
}