class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {1, 1, 1, 1, 1};
        int[] dx1 = {1, 0, -1, 0};
        int[] dy1 = {0, 1, 0, -1};
        int[] dx2 = {1, -1, 1, -1};
        int[] dy2 = {1, 1, -1, -1};
        next: for (int n = 0; n < 5; n++) {
            String[] place = places[n];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) != 'P')
                        continue;
                    for (int k = 0; k < 4; k++) {
                        int newX = j + dx1[k];
                        int newY = i + dy1[k];
                        if (0 <= newY && newY < 5 && 0 <= newX && newX < 5) {
                            if (place[newY].charAt(newX) == 'P') {
                                answer[n] = 0;
                                continue next;
                            }
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        int newX = j + 2 * dx1[k];
                        int newY = i + 2 * dy1[k];
                        int prtX = j + dx1[k];
                        int prtY = i + dy1[k];
                        if (0 <= newY && newY < 5 && 0 <= newX && newX < 5) {
                            if (place[newY].charAt(newX) == 'P' && place[prtY].charAt(prtX) != 'X') {
                                answer[n] = 0;
                                continue next;
                            }
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        int newX = j + dx2[k];
                        int newY = i + dy2[k];
                        int prtX = j + dx2[k];
                        int prtY = i + dy2[k];
                        if (0 <= newY && newY < 5 && 0 <= newX && newX < 5) {
                            if (place[newY].charAt(newX) == 'P') {
                                if (place[i].charAt(prtX) != 'X' || place[prtY].charAt(j) != 'X') {
                                    answer[n] = 0;
                                    continue next;
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}