package z_lld.ratelimit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimitApplication {
    public static void main(String[] args) throws InterruptedException {
        UserSlidingWindow app = new UserSlidingWindow(1);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        ExecutorService executorService = Executors.new;
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> app.accessApplication(1));
            if(i%10 == 0) {
                Thread.sleep(2000);
            }
        }
        executorService.shutdown();
    }
}
