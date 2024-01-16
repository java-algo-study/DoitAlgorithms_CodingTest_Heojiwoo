package Doit1week;

import java.io.IOException;
import java.util.Scanner;

public class 나머지합 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 숫자의 개수 입력 받기
        int M = sc.nextInt();   // 나눌 수 입력 받기
        long[] S = new long[N]; // 부분합 구하는 배열
        long[] C = new long[M]; // 부분합을 M 으로 나눴을 때의 나머지 값의 개수가 저장되는 배열
        long answer = 0;    // 나머지가 0일 때, 즉 부분합 자체가 M으로 나누어 떨어지는 경우의 개수를 저장
        S[0] = sc.nextInt();

        // 부분합 배열 만들기 (부분합 공식 사용)
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + sc.nextInt();
        }

        // 부분합의 나머지 계산하고 개수 카운팅
        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);   // 합배열의 모든 값에 %연산 수행하기
            if (remainder == 0)
                answer++; // 0~i까지의 구간합 자체가 0인 경우 정답에 더해주기
            C[remainder]++; // 같은 나머지를 가진 인덱스의 개수 카운팅 해주기
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer = answer + (C[i] * (C[i] - 1) / 2); // 같은 나머지를 가진 인덱스들중 2개를 뽑는 경우의 수를 더해주기
            }
        }
        System.out.println(answer);
    }
}
