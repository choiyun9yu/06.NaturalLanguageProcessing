package class1;

public class ClassStart2 {

    public static void main(String[] args) {
        String[] studentNames = {"학생1", "학생2"};
        int[] studentAges = {15, 16};
        int[] studentGrades = {90, 80};

        for (int i = 0; i < studentNames.length; i++) {
            System.out.println("이름:" + studentNames[i] + " 나이:" + studentAges[i] + " 성적:" + studentGrades[i]);
        }
        /*
        * 이 코드는 코드 변경을 최소화 하는데 성공했다. 그러나 문제가 존재한다.
        * 한 명의 학생의 정보가 3개의 변수로 나뉘어 저장되어 있다.
        * 한명의 학생의 데이터를 변경할 때 3개의 변수에서 작업을 해야한다.
        * 사람이 관리하기에 좋은 방식은 아니다.
        */
    }
}
