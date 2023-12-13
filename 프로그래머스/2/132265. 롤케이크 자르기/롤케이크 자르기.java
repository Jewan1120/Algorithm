import java.util.HashSet;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> typeSetF = new HashSet<>();
        HashSet<Integer> typeSetB = new HashSet<>();
        int[] typeArrF = new int[topping.length];
        int[] typeArrB = new int[topping.length];
        for (int i = 0; i < topping.length; i++) {
            typeSetF.add(topping[i]);
            typeArrF[i] = typeSetF.size();
            typeSetB.add(topping[topping.length - 1 - i]);
            typeArrB[topping.length - 1 - i] = typeSetB.size();
        }
        for (int i = 0; i < typeArrF.length - 1; i++) {
            if (typeArrF[i] == typeArrB[i + 1]) answer++;
        }
        return answer;
    }
}