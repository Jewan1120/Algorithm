public class Main {

	public static void main(String[] args) throws Exception {
		int n = read();
		int r = 0;
		while (n-- > 0)
			r += read();
		if (r == 0)
			System.out.println("Stay");
		else if (r > 0)
			System.out.println("Right");
		else
			System.out.println("Left");
	}

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean m = n == 13;
		if (m)
			n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13)
			System.in.read();
		return m ? ~n + 1 : n;
	}
}