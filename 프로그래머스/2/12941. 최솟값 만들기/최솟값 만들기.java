import java.util.Arrays;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < Integer.min(A.length, B.length); i++){
            answer += A[i] * B[B.length - 1 - i];
        }
        return answer;
    }
}