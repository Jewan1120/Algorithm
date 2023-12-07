import java.util.HashSet;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> hs = new HashSet<>();
        int pointer = 0;
        int length =0;
        while(++length <= elements.length){
            for(int i = 0; i < elements.length; i ++){
                int sum = 0;
                pointer = i;
                for(int j = 0; j < length; j++){
                    sum += elements[pointer];
                    pointer++;
                    if(pointer >= elements.length) pointer = 0;
                }
                hs.add(sum);
            }
        }
        return hs.size();
    }
}