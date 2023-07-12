package fc.java.part3;

import fc.java.model.CarDAO;
import fc.java.model.CarDTO;

import java.util.Scanner;

public class CarInsertTest {
    public static void main(String[] args) {
        // Q. 자동차 정보를 키보드로 부터 입력 받아서 DB 저장을 하세요. (JDBC)
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

        //System.out.println(carSn+"\t"+carName+"\t"+carPrice+"\t"+carOwner+"\t"+carYear+"\t"+carType);
        //carInfoPrint(carSn, carName, carPrice, carOwner, carYear, carType);
        CarDTO car = new CarDTO();
        car.carSn = carSn;
        car.carName = carName;
        car.carOwner = carOwner;
        car.carPrice = carPrice;
        car.carYear = carYear;
        car.carType = carType;

        CarDAO dao=new CarDAO();
        dao.carInsert(car);
    }

}
