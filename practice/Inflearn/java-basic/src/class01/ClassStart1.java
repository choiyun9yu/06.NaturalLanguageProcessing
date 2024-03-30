package class01;

public class ClassStart1 {

    public static void main(String[] args) {
        String student1Name = "학생1";
        int student1Age = 15;
        int student1Grade = 90;

        String student2Name = "학생2";
        int student2Age = 16;
        int student2Grade = 80;

        System.out.println("이름:" + student1Name +" 나이:" + student1Age + " 성적:" + student1Grade);
        System.out.println("이름:" + student2Name +" 나이:" + student2Age + " 성적:" + student2Grade);
    }
    /*
    * 이 코드의 문제는 유지보수가 어렵다는 것이다.
    * 학생이 늘어나거나 변할 때마다 수정해야하는 코드가 너무 많기 때문이다.
    */
}