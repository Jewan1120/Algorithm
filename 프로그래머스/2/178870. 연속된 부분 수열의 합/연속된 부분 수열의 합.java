class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int l = 0, r = 0, sum = sequence[0];
        while(r < sequence.length){
            if(sum < k){
                if(r == sequence.length - 1) break;
                sum += sequence[++r];
            }else{
                if(sum == k){
                    if(answer.length == 0) answer = new int[]{l, r};
                    else if(answer[1] - answer[0] > r - l){
                        answer[0] = l;
                        answer[1] = r;
                    }
                }
                sum -= sequence[l++];
            }
        }
        return answer;
    }
}