package Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://codeforces.com/problemset/problem/58/A
public class cf_chatRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int j = 0;
        String MATCH_STR = "hello";
        char c2 = MATCH_STR.charAt(j);
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);

            if (c1 == c2) {
                if (j == MATCH_STR.length()-1) {
                    System.out.println("YES");
                    System.exit(0);
                }
                c2 = MATCH_STR.charAt(++j);
            }

        }
        System.out.println("NO");
    }
}
