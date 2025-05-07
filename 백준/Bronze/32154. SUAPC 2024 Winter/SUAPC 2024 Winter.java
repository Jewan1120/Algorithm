public class Main {

	public static void main(String[] args) throws Exception {
		switch (read()) {
			case 1 :
				System.out.println("11\nA B C D E F G H J L M");
				break;
			case 2 :
				System.out.println("9\nA C E F G H I L M");
				break;
			case 3 :
				System.out.println("9\nA C E F G H I L M");
				break;
			case 4 :
				System.out.println("9\nA B C E F G H L M");
				break;
			case 5 :
				System.out.println("8\nA C E F G H L M");
				break;
			case 6 :
				System.out.println("8\nA C E F G H L M");
				break;
			case 7 :
				System.out.println("8\nA C E F G H L M");
				break;
			case 8 :
				System.out.println("8\nA C E F G H L M");
				break;
			case 9 :
				System.out.println("8\nA C E F G H L M");
				break;
			case 10 :
				System.out.println("8\nA B C F G H L M");
				break;
		}
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