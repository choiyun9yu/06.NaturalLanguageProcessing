package JavaStudy;

public class ex44_익명클래스 {
//	4. 익명 중첩 클래스 
	
//	public abstract class Action {
//		public abstract void exec();
//	}
//	
//	public class MyAction extends Action {
//		@Override
//		public void exec() {
//			System.out.println("exec");
//		}
//	}
	
	
	public static void main(String[] args) {
//		기존에 사용하던 방식 
//		Action action = new MyAction();
//		action.exec();
		
//		익명 클래스 방식 : MyAction을 따로 만들지 않고 Action을 상속받은 익명클래스 만들어서 사용  
// 		Action은 추상클래스 여서 구체화 되지 않는다. 
		Action action = new Action() {
//			이름없는 객체를 만들어서 사용하는 것			
			@Override
			public void exec() {
				System.out.println("exec2");
			}
		};
		action.exec();
	}

}
