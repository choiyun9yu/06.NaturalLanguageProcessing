package collection.compare;

public class MyUser implements Comparable<MyUser> {

    private String id;
    private int age;

    public MyUser(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    // 나와 넘어온 것을 비교
    @Override
    public int compareTo(MyUser o) {
        System.out.println(this + " vs " + o);
        return this.age < o.age ? -1 : this.age > o.age ? 1 : 0;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
