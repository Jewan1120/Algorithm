import java.util.ArrayList;
class Solution {
    public int[][] solution(int n) {
        ArrayList<int[]> al = new ArrayList<>();
        move(n, 1, 3, 2, al);
        return al.toArray(new int[0][]);
    }
    public static void move(int n, int s, int e, int p, ArrayList<int[]> al) {
        if (n == 1) {
            al.add(new int[] {s, e});
        } else {
            move(n - 1, s, p, e, al);
            al.add(new int[] {s, e});
            move(n - 1, p, e, s, al);
        }
    }
}