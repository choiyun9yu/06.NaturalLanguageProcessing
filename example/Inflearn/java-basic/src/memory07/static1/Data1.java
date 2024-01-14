package memory07.static1;

// 객체가 생성될 때마다 count를 증가시켜 객체가 몇 개 생성되어 있는지 확인

public class Data1 {
    public String name;
    public int count;

    public Data1(String name) {
        this.name = name;
        count++;
    }
}
