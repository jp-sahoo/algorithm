package z_lld.ratelimit;

import java.util.HashMap;
import java.util.Map;

public class UserSlidingWindow {
    private Map<Integer, SlidingWindow> bucket;

    public UserSlidingWindow(int userId) {
        bucket = new HashMap<>();
        bucket.put(userId, new SlidingWindow(1, 5));
    }

    public void accessApplication(int userId) {
        if(bucket.get(userId).grantAccess()) {
            System.out.println(Thread.currentThread().getName() + " got access");
        } else {
            System.out.println(Thread.currentThread().getName() + " was not allowed");
        }
    }
}
