class Solution {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            answer[i] = my_string.substring(i);
        }
        for (int i = 0; i < answer.length - 1; i++) {
            for (int j = 0; j < answer.length - 1; j++) {
                char[] tmp1 = answer[j].toCharArray();
                char[] tmp2 = answer[j + 1].toCharArray();
                int n = tmp1.length >= tmp2.length ? tmp2.length : tmp1.length;
                for (int k = 0; k < n; k++) {
                    if (tmp1[k] < tmp2[k]) {
                        break;
                    } else if (tmp1[k] > tmp2[k]) {
                        String tmpStr = answer[j + 1];
                        answer[j + 1] = answer[j];
                        answer[j] = tmpStr;
                        break;
                    } else if (k == n - 1 && tmp1.length > tmp2.length) {
                        String tmpStr = answer[j + 1];
                        answer[j + 1] = answer[j];
                        answer[j] = tmpStr;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}