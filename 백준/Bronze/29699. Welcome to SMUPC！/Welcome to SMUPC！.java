public class Main {

	public static void main(String[] args) throws Exception {
		String str = "WelcomeToSMUPC";
		int n = read() % 14;
		System.out.println(str.charAt(n == 0 ? 13 : n - 1));
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