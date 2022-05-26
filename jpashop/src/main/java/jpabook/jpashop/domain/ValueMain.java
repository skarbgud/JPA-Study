package jpabook.jpashop.domain;

public class ValueMain {

    public static void main(String[] args) {
        // 자바의 기본 타입은 절대 공유 X
        int a = 10;
        int b = a; // 값이 복사

        b = 20;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }
}
