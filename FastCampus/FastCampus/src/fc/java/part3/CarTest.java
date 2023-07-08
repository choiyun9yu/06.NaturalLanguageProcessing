package fc.java.part3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {
        // Q. 자동차의 정보를 키보드로부터 입력 받아서 다른 메서드로 이동 해야 되는 경우를 생각해보자

        // 키보드로부터 입력받기 위해 사용
        Scanner scan=new Scanner(System.in);
        System.out.println("자동차일련번호:");
        int carSn = scan.nextInt();

        // nextInt()은 숫자입력과 개행을 하는데 개행문자는 포함되지 않는다.
        // 만약 그다음 nextLine()을 하면 개행문자가 가장 처음에 위치하게된다.
        // 따라서 버퍼를 한 번 비우고 가야한다.

        scan.nextLine(); // 버퍼 비우기

        System.out.println("자동차이름:");
        String carName = scan.nextLine();

        System.out.println("자동차가격:");
        int carPrice = scan.nextInt();

        scan.nextLine(); // 버퍼 비우기

        System.out.println("자동차소유자:");
        String carOwner = scan.nextLine();

        System.out.println("자동차연식:");
        int carYear = scan.nextInt();

        scan.nextLine(); // 버퍼 비우기

        System.out.println("자동차타입:");
        String carType = scan.nextLine();

//        System.out.println(carSn+"\t"+carName+"\t"+carPrice+"\t"+carOwner+"\t"+carYear+"\t"+carType);
    }
    // Q. 매개변수로 자동차의 정보를 받아서 출력하는 메서드를 정의하시오.

}
