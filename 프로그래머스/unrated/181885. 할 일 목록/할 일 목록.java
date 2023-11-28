class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        String[] answer = {};
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) {
                String[] tmp = new String[answer.length + 1];
                System.arraycopy(answer, 0, tmp, 0, answer.length);
                tmp[answer.length] = todo_list[i];
                answer = tmp;
            }
        }
        return answer;
    }
}