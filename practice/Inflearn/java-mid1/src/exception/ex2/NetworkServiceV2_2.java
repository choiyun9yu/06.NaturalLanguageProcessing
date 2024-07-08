package exception.ex2;

import jdk.jshell.spi.ExecutionControl;

public class NetworkServiceV2_2 {

    public void sendMessage(String data) {
        String address = "http://example.com";

        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        try {
            client.connect();
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지:" + e.getMessage());
            return;
        }
        try {
            client.send(data);

        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지:" + e.getMessage());
            return;
        }
        client.disconnect();
    }
}
