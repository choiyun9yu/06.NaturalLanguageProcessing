package class1.ex;

/*
* 문제 설명
* 당신은 온라인 삼풍의 주문 관리 시스템을 만들려고 한다.
* 먼저, 상품 주문 정보를 담을 수 있는 ProductOrder 클래스를 만들어 보자.
*
* 요구 사항
* ProductOrderMain클래스 안에 main() 메서드를 포함하여 여러 상품의 주문 정보를 배열로 관리하고,
* 그 정보들을 출력하고, 최종 결제 금액을 계산하여 출력하자.
*/

public class ProductOrderMain {
    public static void main(String[] args) {
        ProductOrder[] productOrders = new ProductOrder[3];

        ProductOrder order1 = new ProductOrder();
        order1.productName = "두부";
        order1.price = 2000;
        order1.quantity = 2;
        productOrders[0] = order1;

        ProductOrder order2 = new ProductOrder();
        order2.productName = "김치";
        order2.price = 5000;
        order2.quantity = 1;
        productOrders[0] = order2;

        ProductOrder order3 = new ProductOrder();
        order3.productName = "콜라";
        order3.price = 1500;
        order3.quantity = 2;
        productOrders[0] = order3;

        int totalPrice = 0;
        
        for (ProductOrder o : productOrders) {
            System.out.println("상품명: " + o.productName + ", 가격: " + o.price + ", 수량: " + o.quantity);
            totalPrice += o.price * o.quantity;
        }

        System.out.println("총 결제 금액: "+ totalPrice);
    }
}
