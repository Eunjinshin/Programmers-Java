import java.io.*;
import java.util.*;

/**
 * 문제 풀이 일 : 2026.03.27
 * 
 * 순서대로 제일 앞에 있는 카드를 버리면 마지막에 남는 카드의 수 구하기
 * 
 */
class Main {
    public static void main(String[] args) throws IOException {

        // N 입력받기 (br.readLine() 몇 번?)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // Queue에 1~N까지 넣기
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        // while (queue.size() > 1):
        while (queue.size() > 1) {
            // 첫 번째 카드 버리기
            queue.poll();

            // 두 번째 카드 뒤로
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());

    }
}