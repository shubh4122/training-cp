package Training;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//https://codeforces.com/problemset/problem/1791/D
public class cf_distinctSplit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            HashSet<Character> set = new HashSet<>();

            int[] preSum = new int[n];
            int[] sufSum = new int[n];

            //storing prefix sum
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (!set.contains(c)) {
                    set.add(c);
                    preSum[i] = (i == 0 ? 1 : preSum[i - 1] + 1);
                }
                else preSum[i] = preSum[i - 1];
            }

            //storing suffix sum
            set.clear();
            for (int i = n-1; i >= 0; i--) {
                char c = s.charAt(i);
                if (!set.contains(c)) {
                    set.add(c);
                    sufSum[i] = (i == n-1 ? 1 : sufSum[i + 1] + 1);
                }
                else sufSum[i] = sufSum[i + 1];
            }

            int max = 0;
            for (int i = 0; i < n-1; i++) {
                max = Math.max(max, preSum[i]+sufSum[i+1]);
            }

            System.out.println(max);
        }
    }
}
