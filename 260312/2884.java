import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        min -= 45;

        if (min < 0) {
            // 빌려온 값 적용
            min += 60;
            hour -= 1;

            // 시간이 음수가 되었는지 확인
            if (hour < 0) {
                hour += 24;
            }
        }

        System.out.println(hour + " " + min);

    }
}