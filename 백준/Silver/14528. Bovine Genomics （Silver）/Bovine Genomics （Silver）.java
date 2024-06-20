import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
public class Main {
    static int n, m;
    static char[][] sptArr, plnArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sptArr = new char[n][m];
        plnArr = new char[n][m];
        for (int i = 0; i < n; i++)
            sptArr[i] = br.readLine().toCharArray();
        for (int i = 0; i < n; i++)
            plnArr[i] = br.readLine().toCharArray();
        int cnt = 0;
        for (int i = 0; i < m - 2; i++)
            for (int j = i + 1; j < m - 1; j++)
                for (int k = j + 1; k < m; k++)
                    if (genomeChk(i, j, k))
                        cnt++;
        System.out.println(cnt);
    }
    
    private static boolean genomeChk(int x, int y, int z) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String genome = new String(new char[]{sptArr[i][x], sptArr[i][y], sptArr[i][z]});
            hs.add(genome);
        }
        for (int i = 0; i < n; i++) {
            String genome = new String(new char[]{plnArr[i][x], plnArr[i][y], plnArr[i][z]});
            if (hs.contains(genome))
                return false;
        }
        return true;
    }
}