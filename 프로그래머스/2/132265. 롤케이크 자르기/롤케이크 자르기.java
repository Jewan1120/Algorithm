import java.util.HashSet;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        int[] typeA = new int[len];
        int[] typeB = new int[len];
        for (int i = 0; i < len; i++) {
            setA.add(topping[i]);
            setB.add(topping[len - 1 - i]);
            typeA[i] = setA.size();
            typeB[len - 1 - i] = setB.size();
        }
        for (int i = 0; i < len - 1; i++)
            if (typeA[i] == typeB[i + 1])
                answer++;
        return answer;
    }
}