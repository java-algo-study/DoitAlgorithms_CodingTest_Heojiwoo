package Doit1week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기 {
    public static void main(String[] args) throws IOException {
        // 받는 데이터가 많을 때는 Scanner 보다 BufferedReader 를 사용하는 것이 효과적임 (더 빠르기 때문)
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer : BufferedReader 를 사용하면 라인 단위로 읽어들일 수 밖에 없기 때문에 특정 문자에 따라 문자열을 나누고 싶을 때 사용
        // 읽어온 한줄을 공백을 기준으로 토큰으로 분리해줌
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 문자열로 반환되기 때문에 int 형으로 바꿔서 suNo 에 저장함
        int suNo = Integer.parseInt(stringTokenizer.nextToken());   // 숫자의 개수
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());  // 질의의 개수

        long[]S = new long[suNo + 1];   // 배열은 0번째 인덱스부터 갖고 있기 때문에 편의를 위해서 +1을 사용
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // 합 배열 생성
        // 합 배열 공식 : S[i] = S[i - 1] + A[i]
        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        // 질의 생성
        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i - 1]);    // 합 배열 공식 : S[j] - S[i - 1]
        }
    }
}
