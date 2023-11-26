class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 1};
        next: for(int i : lottos){
            if(i == 0){
                answer[0]--;
                answer[1]++;
            }else{
                for(int j : win_nums){
                    if(i == j){
                        answer[0]--;
                        continue next;
                    }
                }
                answer[1]++;
            }
        }
        if(answer[0] == 7) answer = new int[] {6, 6};
        if(answer[1] == 7) answer = new int[] {1, 6};
        return answer;
    }
}