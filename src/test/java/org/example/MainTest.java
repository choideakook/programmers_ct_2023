package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void name() {
        int N = 0;  // 전체 스테이지의 수
        int [] stages ={2, 1, 2, 6, 2, 4, 3, 3};  // 플레이어가 위치하는 스테이지
        int [] answer = new int [N];

        // f :클리어o / c : 도달o ,클리어 X (확률 구할때 소숫점이 필요해서 double)
        double f =0.0; double c = 0.0;
        double m = 0.0; int p = 0;  // 확률을 구하기위한 변수
        int [] answer1 = new int [N]; // 스테이지 별 실패율

        // 스테이지 별로 플레이어가 클리어 했는지 못했는지 구별하는 코드
        for (int i =1 ; i<N+1 ; i++) {
            f=0; c=0;   // 하나의 스테이지 판별이 완료되면 값을 0으로 리셋해줌
            for (int j=0 ; j< stages.length; j++) {
                if (i <= stages[j]) f++;
                if (i == stages[j]) c++;
            }
            // 확률 구하는 코드 (m 으로 실패 확률 구한후 int 로 변경해서 p에 담음)
            m = (c/f)*100; p = (int) m;
            answer1[i-1] = p;   // 스테이지 별로 확률을 담음
            answer [i-1] = i;   // 스테이 번호를 담아줌
        }

        // 확률별로 내림차순 한 스테이지 번호를 재분배 하는 코드
        for (int j = 1 ; j<N ; j++) {   //선택 정렬 사용해서 내림차순 하는 코딩
            for (int i = 1 ; i<N ; i++) {
                if (answer1[i-1]<answer1[i]) {
                    p = answer1[i-1]; answer1[i-1]=answer1[i]; answer1[i]=p;
                    p = answer[i-1]; answer[i-1]=answer[i]; answer[i]=p;
                }
            }}

//        System.out.println(answer);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}