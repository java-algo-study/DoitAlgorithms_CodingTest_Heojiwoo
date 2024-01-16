package Doit1week;

import java.util.Scanner;

public class 숫자의합 {
    public static void main(String[] args) {
        // 숫자 입력 받기
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // 문자열로 입력 받기
        String s = sc.next();
//        toCharArray : String 문자열을 char형 배열로 바꿔서 반환해주는 메서드
        // 사용하여 'c' 라는 배열에 담기
        char[] c = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
//            c는 ASCII 코드 값을 가지고 있기 때문에 - '0' 이나 - 48을 해줘야 정수를 사용할 수 있음
            sum += c[i] - '0'; // 문자 값을 정수 형으로 변환하여 더해주기
        }
        System.out.print(sum);
    }

}
