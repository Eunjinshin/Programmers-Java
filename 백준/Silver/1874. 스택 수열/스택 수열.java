import java.io.*;
import java.util.*;

/**
 * 문제 풀이 일 : 2026.03.20
 * 
 * LIFO (Last In First Out) = 스택(Stack)
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int cur = 1;

        for(int i = 0; i < n; i++){
            //스택 top이 arr[i]가 될 때까지 push를 계속한다
             while (cur <= arr[i]){
                stack.push(cur++);
                sb.append("+\n");
             }

             if(stack.peek().equals(arr[i])){
                    stack.pop();
                    sb.append("-\n");
                }
            else{
                System.out.print("NO");
                return;
            }

        }

        System.out.print(sb);
        
    }
}