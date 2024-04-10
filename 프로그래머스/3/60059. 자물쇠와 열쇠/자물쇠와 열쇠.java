class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int N = lock.length, M = key.length;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N + M - 1; j++) {
                next: for (int k = 0; k < N + M - 1; k++) {
                    int[][] copyLock = new int[N][N];
                    for (int y = 0; y < N; y++) {
                        copyLock[y] = lock[y].clone();
                    }
                    for (int y = 0; y < N; y++) {
                        for (int x = 0; x < N; x++) {
                            int ky = y - j + M - 1, kx = x - k + M - 1;
                            if (0 <= ky && ky < M && 0 <= kx && kx < M) {
                                copyLock[y][x] += key[ky][kx];
                            }
                        }
                    }
                    for (int y = 0; y < N; y++) {
                        for (int x = 0; x < N; x++) {
                            if (copyLock[y][x] != 1) {
                                continue next;
                            }
                        }
                    }
                    return true;
                }
            }
            rotation(key);
        }
        return false;
    }

    public void rotation(int[][] key) {
        int M = key.length;
        int[][] newKey = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                newKey[j][M - 1 - i] = key[i][j];
            }
        }
        for (int i = 0; i < M; i++) {
            key[i] = newKey[i].clone();
        }
    }
}