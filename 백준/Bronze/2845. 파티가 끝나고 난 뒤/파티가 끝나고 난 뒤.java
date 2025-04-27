public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int n = read() * read();
		for (int i = 0; i < 5; i++)
			sb.append(read() - n).append(" ");
		System.out.println(sb);
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