public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        if (n >= 620)
            System.out.println("Red");
        else if (n >= 590)
            System.out.println("Orange");
        else if (n >= 570)
            System.out.println("Yellow");
        else if (n >= 495)
            System.out.println("Green");
        else if (n >= 450)
            System.out.println("Blue");
        else if (n >= 425)
            System.out.println("Indigo");
        else
            System.out.println("Violet");
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
