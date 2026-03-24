import java.io.*;
import java.util.*;

/**
 * 문제 풀이 일 : 2026.03.20
 */
class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트케이스의 수
        int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCount; i++){
            //[중요도 , 인덱스] 형식으로 저장
        Queue<int[]> queue = new ArrayDeque<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            //문서 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken()); 

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int priority = Integer.parseInt(st2.nextToken());
                queue.offer(new int[]{priority, j});
                maxHeap.offer(priority);
            }

            int count = 0;
            while(!queue.isEmpty()){
                int[] front = queue.poll();
                int frontMax = maxHeap.poll();

                if(front[0] == frontMax){
                    count ++;
                    if(front[1] == M){
                        System.out.println(count);
                        break;
                    }
                }else{
                    queue.offer(front);
                    maxHeap.offer(frontMax);
                }
            }

        }


    }
}