class Solution {
    public int solution(int a, int b) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(a);
        sb1.append(b);
        
        sb2.append(b);
        sb2.append(a);
        int result1 = Integer.parseInt(sb1.toString());
        int result2 = Integer.parseInt(sb2.toString());
        return result1 >= result2 ? result1 : result2;
    }
}