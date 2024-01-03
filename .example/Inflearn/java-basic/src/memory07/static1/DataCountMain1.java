package memory07.static1;

public class DataCountMain1 {
    public static void main(String[] args) {
        Data1 data1 = new Data1("A");
        System.out.println("data1 count = " + data1.count);

        Data1 data2 = new Data1("B");
        System.out.println("data2 count = " + data2.count);

        Data1 data3 = new Data1("C");
        System.out.println("data3 count = " + data3.count);
    }
}
