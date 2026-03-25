
/**
 * 문제 풀이 일 : 2026.03.25
 * 
 * N, K 입력받기
 * Queue에 1~N까지 삽입
 * StringBuilder result
 * 
 * while (queue가 비어있지 않음):
 * K-1번 반복:
 * queue.poll()해서 queue.offer()로 뒤로 보내기
 * removed = queue.poll() // K번째 제거
 * result에 추가
 * 
 * result 출력
 */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N, K 입력받기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Queue에 1~N까지 삽입
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        // StringBuilder result
        StringBuilder result = new StringBuilder();

        result.append("<");
        while (!queue.isEmpty()) {
            // K-1번 반복
            for (int j = 0; j < K - 1; j++) {
                // queue.poll()해서 queue.offer()로 뒤로 보내기
                queue.offer(queue.poll());
            }
            // removed = queue.poll()
            result.append(queue.poll());
            if (!queue.isEmpty()) {
                result.append(", ");
            }
        }
        result.append(">");
        // result 출력
        System.out.print(result);

    }
}
