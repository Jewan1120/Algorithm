public class Main {

	public static void main(String[] args) throws Exception {
		int a = read(), b = read();
		if (20 <= a && a <= 23)
			System.out.println(24 - a + b);
		else
			System.out.println(b - a);
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