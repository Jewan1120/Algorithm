import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    String[][] cells = new String[51][51];
    int[][][] parent = new int[51][51][2];

    public String[] solution(String[] commands) {
        for (int i = 0; i < 51; i++)
            Arrays.fill(cells[i], "EMPTY");
        for (int i = 1; i < 51; i++)
            for (int j = 1; j < 51; j++)
                parent[i][j] = new int[] { i, j };
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            String[] command = commands[i].split(" ");
            int r1, c1, r2, c2;
            String value1, value2;
            switch (command[0]) {
            case "UPDATE":
                if (command.length == 4) {
                    r1 = Integer.parseInt(command[1]);
                    c1 = Integer.parseInt(command[2]);
                    value1 = command[3];
                    updateCell(r1, c1, value1);
                } else {
                    value1 = command[1];
                    value2 = command[2];
                    updateArea(value1, value2);
                }
                break;
            case "MERGE":
                r1 = Integer.parseInt(command[1]);
                c1 = Integer.parseInt(command[2]);
                r2 = Integer.parseInt(command[3]);
                c2 = Integer.parseInt(command[4]);
                merge(r1, c1, r2, c2);
                break;
            case "UNMERGE":
                r1 = Integer.parseInt(command[1]);
                c1 = Integer.parseInt(command[2]);
                unmerge(r1, c1);
                break;
            case "PRINT":
                r1 = Integer.parseInt(command[1]);
                c1 = Integer.parseInt(command[2]);
                result.add(print(r1, c1));
                break;
            }
        }
        return result.toArray(new String[0]);
    }

    private void updateCell(int r, int c, String value) {
        int[] rootX = find(r, c);
        for (int i = 1; i < 51; i++)
            for (int j = 1; j < 51; j++) {
                int[] rootY = find(i, j);
                if (rootX[0] == rootY[0] && rootX[1] == rootY[1]) {
                    cells[i][j] = value;
                }
            }
    }

    private void updateArea(String value1, String value2) {
        for (int i = 1; i < 51; i++)
            for (int j = 1; j < 51; j++)
                if (cells[i][j].equals(value1))
                    cells[i][j] = value2;
    }

    private void merge(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) {
            return;
        }
        String value = cells[r1][c1];
        if (value.equals("EMPTY")) {
            value = cells[r2][c2];
        }
        union(r1, c1, r2, c2);
        updateCell(r1, c1, value);
    }

    private void unmerge(int r, int c) {
        int[] rootX = find(r, c);
        String value = cells[rootX[0]][rootX[1]];
        for (int i = 1; i < 51; i++)
            for (int j = 1; j < 51; j++) {
                int[] rootY = find(i, j);
                if (rootX[0] == rootY[0] && rootX[1] == rootY[1]) {
                    parent[i][j] = new int[] { i, j };
                    cells[i][j] = "EMPTY";
                }
            }
        cells[r][c] = value;
    }

    private String print(int r, int c) {
        return cells[r][c];
    }

    private int[] find(int r, int c) {
        int pR = parent[r][c][0];
        int pC = parent[r][c][1];
        if (r != pR || c != pC)
            parent[r][c] = find(pR, pC);
        return parent[r][c];
    }

    private void union(int r1, int c1, int r2, int c2) {
        int[] rootX = find(r1, c1);
        int[] rootY = find(r2, c2);
        parent[rootX[0]][rootX[1]] = rootY;
    }
}