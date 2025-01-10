import java.util.Arrays;

// 0
public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), c = read(), m = read();
		int[][] arr = new int[m][3];
		for (int i = 0; i < m; i++)
			arr[i] = new int[] { read(), read(), read() };
		Arrays.sort(arr, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
		int[] town = new int[n + 1];
		int total = 0;
		for (int i = 0; i < m; i++) {
			int from = arr[i][0], to = arr[i][1], boxes = arr[i][2];
			int maxLoaded = 0, delivery = 0;
			for (int j = from; j < to; j++)
				maxLoaded = Math.max(maxLoaded, town[j]);
			delivery = Math.min(c - maxLoaded, boxes);
			total += delivery;
			for (int j = from; j < to; j++)
				town[j] += delivery;
		}
		System.out.println(total);
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