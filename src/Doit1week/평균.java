package Doit1week;

import java.util.Scanner;

public class 평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 과목의 수 입력받기
        int num = sc.nextInt();
        // 과목의 수만큼 과목별 점수를 넣을 수 있는 배열 만들기
        int score[] = new int[num];

        // 위에서 입력 받은 과목의 수만큼 과목별 점수 입력받아서 배열에 넣기
        for (int i = 0; i < num; i++) {
            score[i] = sc.nextInt();
        }

        int sum = 0;
        int max = 0;

        // 최댓값 찾기
        for (int j = 0; j < num; j++) {
            if (score[j] > max) {
                max = score[j];
            }
            // 최댓값이 아닌 나머지들의 합 구하기
            sum = sum + score[j];
        }
//        (과목1/최댓값*100+과목2/최댓값*100+과목3/최댓값*100)/3 = (국어+수학+영어)*100/최댓값/3
        System.out.println(sum * 100.0 / max / num);
    }
}
