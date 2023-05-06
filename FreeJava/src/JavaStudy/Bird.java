package JavaStudy;

public abstract class Bird {	
//	중괄호는 구현되었다고 보는데 이건 구현된건 아니니까 중괄호 사용X
//	추상 메소드는 abstract를 붙여준다. 
//	클래스의 메소드중 하나라도 추상 메소드이면 그 클래스는 전체가 추상 클래스로 봐서 클래스 앞에도 abstract 붙여준다. 
	public abstract void sing(); 
//	그러나 추상 클래스가 추상 메소드만 갖는 것은 아니다 일반 클래스도 가질 수 있다.
	public void fly() {
		System.out.println("날다.");
	}
}
