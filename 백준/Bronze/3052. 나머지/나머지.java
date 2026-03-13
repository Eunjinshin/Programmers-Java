import java.io.*;
import java.util.*;

/**
 * 문제 풀이 일 : 2026.03.13
 * 
 * 문제의 핵심 : 나머지가 '어떤 값들'이 나왔는가?
 */
class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean[] exist = new boolean[42];

        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt(); // 숫자 입력

            // 입력한 숫자를 바로 나눠서 판별
            exist[num % 42] = true;
        }

        int count = 0;
        for (boolean check : exist) {
            if (check)
                count++;
        }

        System.out.println(count);
    }
}