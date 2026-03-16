import java.io.*;
import java.util.*;

/**
 * 문제 풀이일 : 2026.03.16
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;
        // 나무 높이 바구니
        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(trees);
        int low = 0; // 낮은 나무
        int high = trees[N - 1]; // 높은 나무

        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid)
                    sum += (trees[i] - mid);
            }

            if (sum >= M) {
                result = mid;
                low = mid + 1;// low를 올림으로써 탐색 범위를 더 높은 쪽으로 좁힘
            } else {
                high = mid - 1;
            }

        }

        System.out.println(result);

    }
}