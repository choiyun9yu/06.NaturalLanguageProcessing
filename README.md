# Java
- 컴파일 : (해당 경로에서) javac 파일명.java / javac -d [바이트코드파일저장위치] [소스경로/*.java]	
- 실행 : (해당 경로에서) java 파일명.java / java -cp [바이트코드파일위치] [패키지…클래스명]

## JDK
- JDK 설치
- [터미널 창] open ~/.zshrc
- 환경변수 추가
  export JAVA_HOME=/Library/Java/JavaVirtualMachines/zulu-17.jdk/Contents/Home.   
  export PATH=${PATH}:$JAVA_HOME/bin. 
- java --version
  javac --version 제대로 출력되면 설치 된 것
  
## Eclipse
- 코드서명이 깨져서 응용 프로그램을 열 수 없다고 뜨는 경우  
  [터미널 창] codesign --force --deep --sign - /Applications/Eclipse.app/Contents/MacOS/eclipse

## STS
- Spring Framework Home Page Download
- Git으로 이동한 뒤 운영체젱 맞는 것 다운로드
- STS.ini 파일 찾아서 JDK 경로 설정
- -vm  
  경로
