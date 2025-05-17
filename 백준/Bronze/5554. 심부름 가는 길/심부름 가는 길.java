public class Main {

	public static void main(String[] args) throws Exception {
		int n = read() + read() + read() + read();
		System.out.println(n / 60);
		System.out.println(n % 60);
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