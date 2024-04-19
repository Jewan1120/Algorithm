import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Myque que = new Myque();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (; n > 0; n--) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            char c = command.charAt(0);
            if (command.contains("push")) {
                if (command.charAt(5) == 'f') {
                    que.push(st.nextToken(), 'f');
                } else {
                    que.push(st.nextToken(), 'b');
                }
            } else {
                if (c == 'p') {
                    if (command.charAt(4) == 'f') {
                        bw.write(que.pop('f'));
                    } else {
                        bw.write(que.pop('b'));
                    }
                } else if (c == 's') {
                    bw.write(que.size());
                } else if (c == 'e') {
                    bw.write(que.empty());
                } else if (c == 'f') {
                    bw.write(que.front());
                } else if (c == 'b') {
                    bw.write(que.back());
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Myque {
        Deque<String> que;

        public Myque() {
            que = new ArrayDeque<>();
        }

        public void push(String str, char c) {
            if (c == 'f') {
                que.offerFirst(str);
            } else {
                que.offerLast(str);
            }
        }

        public String pop(char c) {
            if (!que.isEmpty()) {
                if (c == 'f') {
                    return String.valueOf(que.pollFirst());
                } else {
                    return String.valueOf(que.pollLast());
                }
            } else {
                return "-1";
            }
        }

        public String size() {
            return String.valueOf(que.size());
        }

        public String empty() {
            if (!que.isEmpty()) {
                return "0";
            } else {
                return "1";
            }
        }

        public String front() {
            if (!que.isEmpty()) {
                return String.valueOf(que.peekFirst());
            } else {
                return "-1";
            }
        }

        public String back() {
            if (!que.isEmpty()) {
                return String.valueOf(que.peekLast());
            } else {
                return "-1";
            }
        }
    }
}