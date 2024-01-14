package memory07.static1;

public class DataCountMain2 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Data2 data1 = new Data2("A", counter);
        System.out.println("data1 count = " + counter.count);

        Data2 data2 = new Data2("B", counter);
        System.out.println("data2 count = " + counter.count);

        Data2 data3 = new Data2("C", counter);
        System.out.println("data3 count = " + counter.count);
    }
}
