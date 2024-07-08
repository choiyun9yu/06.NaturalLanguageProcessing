package exception.ex3;

import exception.ex3.exception.ConnectExceptionV3;
import exception.ex3.exception.NetworkClientExceptionV3;
import exception.ex3.exception.SendExceptionV3;

public class NetworkClientV3 {

    private final String address;
    public boolean connectError;    // boolean 의 default 는 false
    public boolean sendError;

    public NetworkClientV3(String address) {
        this.address = address;
    }

    public void connect() throws NetworkClientExceptionV3 {
        if (connectError) {
            throw new ConnectExceptionV3("connectError", address+" 서버 연결 실패");
        }
        // 연결 성공
        System.out.println(address + " 서버 연결 성공");
    }

    public void send(String message) throws NetworkClientExceptionV3 {
        if (sendError) {
            throw new SendExceptionV3("sendError", address + "서버에 데이터 전송 실패: " + message);
        }
        // 전송 성공
        System.out.println(address + " 서버에 데이터 전송: " + message);
    }

    public void disconnect() {
        // 연결 해제
        System.out.println(address + " 서버에 연결 해제");
    }

    public void initError(String data) {
        if (data.contains("error1")) {
            connectError = true;
        }
        if (data.contains("error2")) {
            sendError = true;
        }
    }
}
