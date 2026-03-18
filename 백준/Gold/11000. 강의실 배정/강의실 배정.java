import java.io.*;
import java.util.*;

class Main {
    // static 메서드인 main에서 사용하기 위해 static 클래스로 선언합니다.
    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture other) {
            if (this.start == other.start) {
                return Integer.compare(this.end, other.end);
            }
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N이 0일 경우에 대한 예외 처리가 있으면 더 안전합니다.
        String line = br.readLine();
        if (line == null)
            return;
        int N = Integer.parseInt(line);

        List<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(s, e));
        }

        // 1. 시작 시간 기준 정렬
        Collections.sort(lectures);

        // 2. 우선순위 큐로 종료 시간 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 3. 첫 수업 처리
        if (N > 0) {
            pq.offer(lectures.get(0).end);
        }

        for (int i = 1; i < N; i++) {
            Lecture current = lectures.get(i);

            // 가장 빨리 끝나는 강의실이 내 시작 시간보다 같거나 일찍 끝난다면 재사용
            if (!pq.isEmpty() && pq.peek() <= current.start) {
                pq.poll();
            }
            pq.offer(current.end);
        }

        // 4. 결과 출력
        System.out.println(pq.size());
    }
}