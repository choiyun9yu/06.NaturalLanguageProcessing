package ref.ex;

/*
* 문제 설명
* 앞서 만들었던 당므 클래스에 있는 '상품 주문 시스템'을 리팩토링 하자.
*
* 당신은 온라인 상점의 주문 관리 시스템을 만들려고 한다.
* 먼저, 상품 주문 정보를 담을 수 있는 ProductOrder 클래스를 만들어보자.
*/

public class ProductOrderMain {
    public static void main(String[] args) {
        // 여러 상품의 주문 정보를 담는 배열 생성
        ProductOrder[] orders = new ProductOrder[3];

        // createOrder()를 여러번 사용해서 상품 주문 정보들을 생성하고 배열에 저장
        orders[0] = createOrder("두부", 2000, 2);
        orders[1] = createOrder("김치", 5000, 1);
        orders[2] = createOrder("콜라", 1500, 2);

        // printOrders()를 사용해서 상품 주문 정보 출력
        for (ProductOrder o : orders) {
            printOrders(o);
        }

        // getTotalAmout()를 사용해서 총 결제 금액 계산
        int totalPrice = getTotalAmount(orders);

        // 총 결제 금액 출력
        System.out.println("총 결제 금액: " + totalPrice);
    }

    static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder p = new ProductOrder();
        p.productName = productName;
        p.price = price;
        p.quantity = quantity;
        return p;
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
