class Solution {
    public int solution(int[] numbers) {
        for(int i = 0; i < numbers.length - 1; i ++){
            for(int j = 0; j < numbers.length - 1 - i; j ++){
                if(numbers[j] >numbers[j + 1]){
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }
        return numbers[numbers.length - 1] * numbers[numbers.length - 2];
    }
}