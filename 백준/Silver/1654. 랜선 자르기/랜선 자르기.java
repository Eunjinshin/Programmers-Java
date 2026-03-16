import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가지고 있는 랜선의 개수
        int K = Integer.parseInt(st.nextToken());

        // 필요한 랜선의 개수
        int N = Integer.parseInt(st.nextToken());

        int LANcable[] = new int[K];
        long high = 0;

        for (int i = 0; i < K; i++) {
            LANcable[i] = Integer.parseInt(br.readLine()); // 줄바꿈 입력 처리
            if (high < LANcable[i])
                high = LANcable[i]; // 정렬 대신 최댓값 찾기
        }

        long low = 1; // 0으로 나누기 방지 및 최소 길이
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += (LANcable[i] / mid);
            }

            if (count >= N) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(result);
    }
}
