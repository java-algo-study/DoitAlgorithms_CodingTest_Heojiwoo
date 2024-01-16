package Doit1week;

import java.io.*;
import java.util.Stack;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());    // 수열의 개수

        int[] A = new int[n];   // 입력으로부터 공백을 기준으로 분리된 수열을 저장할 배열 A를 선언

        // 각 수열의 원소를 입력으로부터 읽어들여 A 배열에 저장
        String[] str = bf.readLine().split(" ");    // split 을 사용하여 공백을 기준으로 구분하여 배열에 저장
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(str[i]);
        }

        int[] ans = new int[n];     // 오큰수를 저장하는 배열 ans 선언

        Stack<Integer> myStack = new Stack<>();

        // 처음에는 항상 스택이 비어있으므로 최초 값을 push하여 초기화
        myStack.push(0);

        // 주어진 수열을 오른쪽으로 탐색하면서 오큰수 찾기
        for (int i = 1; i < n; i++) {
            // 스택이 비어있지 않고, 현재 수열 A[i]이 스택의 top에 해당하는 인덱스의 수열 A[myStack.peek()]보다 큰 경우를 검사
            while (!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
                // 정답 배열에 오큰수를 현재 수열로 저장하기
                ans[myStack.pop()] = A[i];
            }

            // 신규데이터 push
            myStack.push(i);
        }

        // 반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌 때 까지
        while (!myStack.empty()) {
            // 스택에 쌓인 index에 -1을 넣고
            ans[myStack.pop()] = -1;
        }

        // 출력을 위한 BufferedWriter 선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정답 배열을 출력
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }

        // 개행 문자 출력
        bw.write("\n");

        // 출력 버퍼 비우기
        bw.flush();
    }
}
