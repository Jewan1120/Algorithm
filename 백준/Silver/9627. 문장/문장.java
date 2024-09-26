import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static String[] num1 = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    static String[] num11 = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen" };
    static String[] num10 = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
    static String[] num100 = { "", "onehundred", "twohundred", "threehundred", "fourhundred", "fivehundred",
            "sixhundred", "sevenhundred", "eighthundred", "ninehundred" };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, String> hm = new HashMap<>();
        for (int i = 1; i < 10; i++)
            hm.put(i, num1[i]);
        for (int i = 10; i < 20; i++)
            hm.put(i, num11[i % 10]);
        for (int i = 2; i < 10; i++)
            for (int j = 0; j < 10; j++)
                hm.put(i * 10 + j, num10[i] + num1[j]);
        for (int i = 1; i < 9; i++)
            hm.put(i * 100, num100[i]);
        for (int i = 100; i < 1000; i++) {
            int n100 = i / 100;
            int n10 = (i % 100) / 10;
            int n1 = i % 10;
            String num = num100[n100];
            if (n10 == 1)
                num += num11[n1];
            else
                num += num10[n10] + num1[n1];
            hm.put(i, num);
        }
        int n = Integer.parseInt(br.readLine());
        String[] strArr = new String[n];
        int targetIdx = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("$"))
                targetIdx = i;
            else {
                len += str.length();
            }
            strArr[i] = str;
        }
        for (int i = 1; i < 1000; i++) {
            String str = hm.get(i);
            if (len + str.length() == i) {
                strArr[targetIdx] = str;
                break;
            }
        }
        System.out.println(String.join(" ", strArr));
    }
}