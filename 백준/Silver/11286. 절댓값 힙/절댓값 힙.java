import java.io.*;
import java.util.*;

/**
 * 문제 풀이 일 : 2026.03.23.월요일
 * 1. n 입력받기
 * 2. n번 반복:
 * - x 입력받기
 * - x != 0 이면 → pq.offer(x)
 * - x == 0 이면 → pq가 비어있으면 0 출력
 * 아니면 pq.poll() 출력
 * 3. 결과 출력 (StringBuilder 쓰세요!)
 */
class Main {
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> pg = new PriorityQueue<>((a, b) -> {
            // 1. 절댓값이 다를 경우
            if (Math.abs(a) != Math.abs(b)) {
                return Math.abs(a) - Math.abs(b);
            }
            // 2. 절댓값이 같으면 음수가 먼저
            else {
                return a - b;
            }
        });

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 연산의 개수
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                pg.offer(x);
            } else {
                if (pg.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(pg.poll());
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);

    }
}