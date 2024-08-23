import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr1 = new int[n][2];
        for (int i = 0; i < n; i++)
            arr1[i] = new int[] { read(), i };
        int m = read();
        int[][] arr2 = new int[m][2];
        for (int i = 0; i < m; i++)
            arr2[i] = new int[] { read(), i };
        Arrays.sort(arr1, (o1, o2) -> o1[0] - o2[0] != 0 ? o2[0] - o1[0] : o1[1] - o2[1]);
        Arrays.sort(arr2, (o1, o2) -> o1[0] - o2[0] != 0 ? o2[0] - o1[0] : o1[1] - o2[1]);
        ArrayList<int[]> al = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (arr1[i][0] == arr2[j][0])
                    if (al.isEmpty()) {
                        al.add(new int[] { arr1[i][0], arr1[i][1], arr2[j][1] });
                        break;
                    } else {
                        int[] last = al.get(al.size() - 1);
                        if (last[1] < arr1[i][1] && last[2] < arr2[j][1]) {
                            al.add(new int[] { arr1[i][0], arr1[i][1], arr2[j][1] });
                            break;
                        }
                    }
        StringBuilder sb = new StringBuilder();
        sb.append(al.size()).append("\n");
        for (int[] i : al) {
            sb.append(i[0]).append(" ");
        }
        System.out.println(sb);
    }
    
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}