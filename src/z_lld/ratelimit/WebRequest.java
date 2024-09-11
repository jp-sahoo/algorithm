package z_lld.ratelimit;

public class WebRequest {
    String ip;
    String userId;
    Long timeStamp;
    WebRequest(String ip, String userId, Long timeStamp) {
        this.ip = ip;
        this.userId = userId;
        this.timeStamp = timeStamp;
    }
}
