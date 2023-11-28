class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                next: for(int k = j + 1; k < nums.length ; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    for(int l = 3; l < sum - 1; l++){
                        if(sum % l == 0){
                            continue next;
                        }
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}