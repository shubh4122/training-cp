package Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cf_tilesComeback {
    public static void main(String[] args) throws IOException {

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nk = br.readLine().split(" ");
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            int[] tiles = new int[n];
            int i = 0;
            for (String s : arr) {
                tiles[i++] = Integer.parseInt(s);
            }

            //Logic - find k elem of tiles[0], after that find k elem of [n-1]
            int count1 = 0, count2 = 0;
            for (i = 0; i < n; i++) {
                if (tiles[i] == tiles[0]) count1++;
                if (count1 == k) break;
            }
            //at this point i points to kth tile with val = [0]

            for (i++; i < n; i++) {//increasing i to next tile at initialisation
                if (tiles[i] == tiles[n-1]) count2++;
                if (count2 == k) break;
            }

            if((count1 == k && count2 == k) || (tiles[0] == tiles[n-1] && count1 == k))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
