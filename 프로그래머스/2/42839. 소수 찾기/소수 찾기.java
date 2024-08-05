import java.util.Arrays;
import java.util.HashSet;
class Solution {
    
    static boolean[] isPrime;
    static boolean[] visited;
    static int[] result;
    static int[] nums;
    static HashSet<Integer> chk = new HashSet<>();
    
    public int solution(String numbers) {
        String[] strArr = numbers.split("");
        nums = new int[strArr.length];
        Arrays.sort(strArr, (o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < strArr.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }
        int maxNum = 0;
        for (int i : nums) {
            maxNum *= 10;
            maxNum += i;
        }
        isPrime = new boolean[maxNum + 1];
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(maxNum); i++) {
            if (!isPrime[i]) {
                for (int j = i + i; j <= maxNum; j += i)
                    isPrime[j] = true;
            }
        }
        visited = new boolean[nums.length];
        result = new int[nums.length];
        recursive(0);
        return chk.size();
    }
    
    private void recursive(int depth) {
        int num = 0;
        for (int i = 0; i < depth; i++) {
            num *= 10;
            num += result[i];
        }
        if (!isPrime[num])
            chk.add(num);
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                result[depth] = nums[i];
                visited[i] = true;
                recursive(depth + 1);
                visited[i] = false;
            }
        }
    }
}