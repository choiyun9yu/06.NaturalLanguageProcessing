# Java
- 컴파일 : (해당 경로에서) javac 파일명.java / javac -d [바이트코드파일저장위치] [소스경로/*.java]	
- 실행 : (해당 경로에서) java 파일명.java / java -cp [바이트코드파일위치] [패키지…클래스명]

## JDK(for Mac)
- sdkman 설치 // 자바 뿐만아니라 프로그래밍 언어 버전관리 도와줌
  - [터미널 창] curl -s "https://get.sdkman.io" | bash 
  - [터미널 창] source "$HOME/.sdkman/bin/sdkman-init.sh"
  - [터미널 창] sdk version // 설치 확인
  - [터미널 창] sdk list java // 설치할 수 있는 자바 목록 보기
  - [터미널 창] sdk install java 11.0.19-amzn // 리스트로 확인한 것 중 다운받을 버전 넣기
  - [터미널 창] sdk use java 11.0.19-amzn // 사용하기
  - [터미널 창] sdk current java // 현재 사용 버전 확인
  - [터미널 창] echo $JAVA_HOME // 환경변수 자동 설정 확인
    
- JDK 설치
- [터미널 창] open ~/.zshrc
- 환경변수 추가
  export JAVA_HOME=/Library/Java/JavaVirtualMachines/zulu-17.jdk/Contents/Home.   
  export PATH=${PATH}:$JAVA_HOME/bin. 
- java --version
  javac --version 제대로 출력되면 설치 된 것

- tomcat 설치
  - 다운 받고 압축 풀고 홈디렉토리로 옮기면 끝
  - Mac home 디렉토리 이동 방법 파일열고 [command + shifht + H]
  - cd ~/톰켓디렉토리경로/bin
  - ./startup.sh <- 톰캣 실행
  - ./sutdown.sh <- 톰캣 종료

## JDK(for Win)
- JDK 설치
- [터미널 창] path <- 환경변수 경로 확인
- [터미널 창] setx path "%path%'경로"
- [터미널 창] java --version
- [터미널 창] javac --version 
  
## Eclipse
- 코드서명이 깨져서 응용 프로그램을 열 수 없다고 뜨는 경우  
  [터미널 창] codesign --force --deep --sign - /Applications/Eclipse.app/Contents/MacOS/eclipse

## STS
- M1 mac 가이드 : https://codechobo.tistory.com/28

## IntenliJ
- M1 mac 가이드 : moonong.tistory.com/41
- 얼티메이트버전은 스프링을 제공하여 maven으로 프로젝트 생성 후 add framework 옵션에서 스프링을 선택하면 된다.
- 커뮤니티버전은 스프링을 제공하지 않아서 손수 한땀 한땀 환경 구축을 해주어야 한다. 
