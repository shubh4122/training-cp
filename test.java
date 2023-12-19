package Training;


import java.io.*;

import java.util.*;

public class test {
    //{"hello":"world","hi":"hello","ab":"xyz"} {"hello":"world","hi":"helldffo","ab":"xyz"}

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
        String s1 = "{\"hellowe\":\"world\",\"hi\":\"hello\",\"ab\":\"xyzfgge\"}" ;
        String s2 = "{\"hello\":\"world\",\"hi\":\"helldffo\",\"ab\":\"xyz\"}";


//        System.out.println(s1);
//        System.out.println(s2);
        System.out.println(get(s1, s2));
    }

    static List<String> get(String a, String b) {
        Map<String, String> m = new HashMap<>();
        String key = "", value = "";
        int c = 0;
        for (char i : a.toCharArray()) {
            if (i == '{' || i == '}')
                continue;
            if (i == ':') {
                c = 1;
            } else if (i == ',') {
                m.put(key, value);
                key = "";
                value = "";
                c = 0;
            } else {
                if (c == 1) {
                    value += i;
                } else
                    key += i;
            }
        }

        m.put(key, value);
        key = "";
        value = "";
        c = 0;

        System.out.println(m);
        List<String> ans = new ArrayList<>();
        for (char i : b.toCharArray()) {
            if (i == '{' || i == '}')
                continue;
            if (i == ':') {
                c = 1;
            } else if (i == ',') {
                if (m.get(key) != null && !m.get(key).equals(value))
                    ans.add(key.substring(1,key.length()-1));
                key = "";
                value = "";
                c = 0;
            } else {
                if (c == 1) {
                    value += i;
                } else
                    key += i;
            }
        }

        if (!m.get(key).equals(value))
            ans.add(key.substring(1,key.length()-1));
        return ans;
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        long number = scanner.nextLong();
//        long n = scanner.nextLong();
//
//        System.out.println(findNthFactor(number, n));
//
//        scanner.close();
//    }

//    private static long findNthFactor(long number, long n) {
//
//        ArrayList<Long> factors = new ArrayList<>();
//
//        for (int i = 1; i <= Math.sqrt(number); i++) {
//            if (number % i == 0) {
//                factors.add((long) i);
//                if (i != number/i)
//                    factors.add(number/i);
//            }
//        }
//
//        Collections.sort(factors);
//        System.out.println(factors);
//        if (n > factors.size())
//            return 0; // Indicates that the number does not have n factors
//
//        return factors.get((int) n-1);
//    }
}
