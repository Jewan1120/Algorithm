import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static class Chunbae {
        int h, d;
        boolean surpriseUsedFlag;
        boolean surpriseCount;

        Chunbae(int h, int d, boolean surpriseUsedFlag, boolean surpriseCount) {
            this.h = h;
            this.d = d;
            this.surpriseUsedFlag = surpriseUsedFlag;
            this.surpriseCount = surpriseCount;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        Deque<Chunbae> dq = new ArrayDeque<>();
        int h = read(), d = read(), k = read();
        dq.offer(new Chunbae(h, d, false, true));
        int t = 0, damage = 0, tempDamage = 0;
        while (n-- > 0) {
            t = dq.size();
            tempDamage = read();
            while (t-- > 0) {
                Chunbae chunbae = dq.poll();
                damage = tempDamage;
                if (chunbae.h <= 0)
                    continue;
                if (chunbae.surpriseUsedFlag) {
                    chunbae.surpriseUsedFlag = false;
                    damage = 0;
                }
                if (chunbae.surpriseCount)
                    dq.offer(new Chunbae(chunbae.h - Math.max(0, damage - chunbae.d), chunbae.d, true, false));
                dq.offer(new Chunbae(chunbae.h - Math.max(0, damage - chunbae.d - k), chunbae.d + k,
                        chunbae.surpriseUsedFlag, chunbae.surpriseCount));
                dq.offer(new Chunbae(chunbae.h - Math.max(0, damage - chunbae.d) / 2, chunbae.d,
                        chunbae.surpriseUsedFlag, chunbae.surpriseCount));
            }
        }
        int maxH = 0;
        while (!dq.isEmpty()) {
            Chunbae chunbae = dq.poll();
            if (chunbae.h <= 0)
                continue;
            maxH = Math.max(maxH, chunbae.h);
        }
        System.out.println(maxH != 0 ? maxH : -1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}