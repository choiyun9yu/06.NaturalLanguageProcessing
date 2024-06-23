package exception.ex1;

public class NetworkClientV1 {

    private final String address;
    public boolean connectError;    // boolean 의 default 는 false
    public boolean sendError;

    public NetworkClientV1(String address) {
        this.address = address;
    }

    public String connect() {
        if (connectError) {
            System.out.println(address + " 서버 연결 실패");
            return "connectError";
        }
        // 연결 성공
        System.out.println(address + " 서버 연결 성공");
        return "success";
    }

    public String send(String message) {
        if (sendError) {
            System.out.println(address + " 서버에 데이터 전송 실패: " + message);
            return "sendError";
        }
        // 전송 성공
        System.out.println(address + " 서버에 데이터 전송: " + message);
        return "success";
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
