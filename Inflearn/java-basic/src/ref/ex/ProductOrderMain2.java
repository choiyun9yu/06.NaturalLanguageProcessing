package ref.ex;

/*
* 문제 설명
* 앞서 만든 상품 주문 시스템을 사용자 입력을 받도록 개선해보자.
*
* 요구사항
* 1. 아래 입력, 출력 예시를 참고해서 다음 사항을 적용하자.
*   주문 수량을 입력 받자. (예: 입력할 주문의 개수를 입력하세요:)
*   가격, 수량, 상품명을 입력 받자.
*   입력시 상품 순서를 알 수 있게 "n번째 주문 정보를 입력하세요"라는 메시지를 출력 하자
* 2. 입력이 끝나면 총 결제 금액을 출력하자.
*/

import java.util.Scanner;

public class ProductOrderMain2 {
    public static void main(String[] args) {
        // 스캐너 생성
        Scanner scanner =  new Scanner(System.in);

        // 주문 수 입력
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int orderAmount = scanner.nextInt();
        scanner.nextLine();
        ProductOrder[] orders = new ProductOrder[orderAmount];

        // 주문 입력
        for (int i=0; i<orderAmount; i++){
            System.out.println(i+1 + "번째 주문 정보를 입력하세요.");
            orders[i] = createOrder(scanner);
        }

        // 주문 출력
        for (ProductOrder o : orders) {
            printOrders(o);
        }

        // 총 결제 금액 출력
        int totalPrice = getTotalAmount(orders);
        System.out.println("총 결제 금액: " + totalPrice);
    }

    static ProductOrder createOrder(Scanner scanner) {
        ProductOrder order = new ProductOrder();
        System.out.print("상품명: ");
        order.productName = scanner.nextLine();
        System.out.print("가격: ");
        order.price = scanner.nextInt();
        System.out.print("수량: ");
        order.quantity = scanner.nextInt();
        scanner.nextLine(); // 입력 버퍼를 비우기 위한 코드
        return order;
    }

    static void printOrders(ProductOrder p) {
        System.out.println("상품명: " + p.productName + ", 가격: " + p.price + ", 수량: " + p.quantity);
    }

    static int getTotalAmount(ProductOrder[] arrO) {
        int currentPrice = 0;
        for (ProductOrder o : arrO) {
            currentPrice += o.price * o.quantity;
        }
        return  currentPrice;
    }
}
