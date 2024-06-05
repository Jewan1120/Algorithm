public class Main {

    public static void main(String[] args) throws Exception {
        int w = 0, b = 0, cnt = 0;
        while (cnt < 64) {
            int p = System.in.read();
            if (p == 10 || p == 13) {
                continue;
            }
            cnt++;
            switch (p) {
                case 112:
                    b += 1;
                    break;
                case 80:
                    w += 1;
                    break;
                case 110:
                case 98:
                    b += 3;
                    break;
                case 78:
                case 66:
                    w += 3;
                    break;
                case 114:
                    b += 5;
                    break;
                case 82:
                    w += 5;
                    break;
                case 113:
                    b += 9;
                    break;
                case 81:
                    w += 9;
                    break;
            }
        }
        System.out.println(w - b);
    }
}