# Java
- 컴파일 : (해당 경로에서) javac 파일명.java / javac -d [바이트코드파일저장위치] [소스경로/*.java]	
- 실행 : (해당 경로에서) java 파일명.java / java -cp [바이트코드파일위치] [패키지…클래스명]
- 자바 클래스 생성도 안되고, 실행도 안될 때 -> 디렉토리 우클릭 -> Mark directory as -> Source root 지정하면 된다.

## JAVA(for Ubuntu)

    % sudo apt-get install openjdk-11-jdk
    % java -verison
    % javac -version
    
    # 환경변수 설정
    % sudo vi ~/.bashrc
    % export JAVA_HOME=$(readlink -f /usr/bin/java | sed "s:bin/java::")
    % source ~/.bashrc
    % echo $JAVA_HOME
    
    # 버전 관리
    % update-alternatives --list java    # 설치된 자바 버전 확인
    % sudo update-alternatives --config java
    % sudo update-alternatives --config javac
    
    % sudo apt-get purge poenjdk*    $ 자바 삭제

## JDK(for Mac)
#### sdkman 설치 // 자바 뿐만아니라 프로그래밍 언어 버전관리 도와줌

    % curl -s "https://get.sdkman.io" | bash
    % source "$HOME/.sdkman/bin/sdkman-init.sh"
    % sdk version                                 // 설치 확인
    % sdk list java                               // 설치할 수 있는 자바 목록 보기
    % sdk install java 11.0.19-amzn               // 리스트로 확인한 것 중 다운받을 버전 넣기
    % sdk use java 11.0.19-amzn                   // 사용하기
    % sdk current java                            // 현재 사용 버전 확인
    % echo $JAVA_HOME                             // 환경변수 자동 설정 확인
        
#### JDK 설치

    %  open ~/.zshrc

#### 환경변수 추가
  
    % export JAVA_HOME=/Library/Java/JavaVirtualMachines/zulu-17.jdk/Contents/Home.   
    % export PATH=${PATH}:$JAVA_HOME/bin. 

## Tomcat 
  - 다운 받고 압축 풀고 홈디렉토리로 옮기면 끝
  - Mac home 디렉토리 이동 방법 파일열고 [command + shifht + H]
  - cd ~/톰켓디렉토리경로/bin
  - ./startup.sh <- 톰캣 실행
  - ./sutdown.sh <- 톰캣 종료
