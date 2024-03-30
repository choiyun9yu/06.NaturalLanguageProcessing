package class01.ex;

/*
* 기존 문제에 배열을 도입하고, 영화 리뷰를 배열로 관리하자.
* 리뷰를 출력할 때 배열과 for문을 사용해서 System.out.println을 사용하자.
*/

public class MovieReviewMain2 {

    public static void main(String[] args) {
        MovieReview inception = new MovieReview();
        inception.title = "인셉션";
        inception.review = "인생은 무한 루프";

        MovieReview aboutTime = new MovieReview();
        aboutTime.title = "어바웃 타임";
        aboutTime.review = "인생 시간 영화";

        MovieReview[] movies = {inception, aboutTime};

        for (MovieReview m : movies) {
            System.out.println("영화 제목: " + m.title + ", 리뷰: " + m.review);
        }
    }
}
