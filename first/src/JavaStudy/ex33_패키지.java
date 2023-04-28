package JavaStudy;

//import : 다른 패키지에 들어있는 클래스르 사용하기 위한 키워
import  com.eightcruz.javastudy.*;	// .*를 쓰면 그 패키지 안에 있는 모든 클래스 다 쓰겟다고 알려주는 

public class ex33_패키지 {
//	패키지 : 관련된 클래스드을 폴더별로 관리하는 단위 
//		   패키지 이름은 대부분 도메인 이름을 거꾸로 적은 후 프로젝트 이름을 붙여 사용
//		   패키지가 있는 클래스를 사용할 때는 import 사용 
	  
	public static void main(String[] args) {
		Hello hello = new Hello();
		
//		만약 import 하지 않으려면 길게 다 적어줘야하는 불편함이 따른다.
		com.eightcruz.javastudy.Hello hello2 = new com.eightcruz.javastudy.Hello();
		

		
	}

}