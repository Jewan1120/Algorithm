public class Main {

	public static void main(String[] args) throws Exception {
		int a = read(), b = read();
		int c = (a + b) / 2;
		if ((a + b) % 2 == 1 || a < b || (a - b) % 2 == 1) {
			System.out.println(-1);
			return;
		}
		int d = a - c;
		if (c > d)
			System.out.println(c + " " + d);
		else
			System.out.println(d + " " + c);
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