public class Main {

	public static void main(String[] args) throws Exception {
		String[] sArr = {"S", "U", "O"};
		System.out.println(sArr[read() % 3]);
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
