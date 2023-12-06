import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int bottom = 0;
        int top = people.length - 1;
        while (bottom <= top) {
            if (people[bottom] + people[top] <= limit) {
                bottom++;
            }
            top--;
            answer++;
        }
        return answer;
    }
}