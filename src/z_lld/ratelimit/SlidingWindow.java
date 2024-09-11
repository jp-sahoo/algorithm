package z_lld.ratelimit;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow {
    private int timeWindow;
    private int allowedRequestCount;
    private Queue<Long> window;

    public SlidingWindow(int timeWindow, int allowedRequestCount) {
//        Directory d = new Directory()
//                File f = new File("").lis;
//                Paths.get("").get;
//                if(f.)
//        MessageDigest.getInstance("MD5");
//        List<Integer> list = new LinkedList<>();
//        list.remove(list.size())
        this.timeWindow = timeWindow;
        this.allowedRequestCount = allowedRequestCount;
        this.window = new ConcurrentLinkedQueue<>();
    }
    public boolean grantAccess() {
        long current = System.currentTimeMillis();
        checkAndUpdate(current);
        if(window.size() < allowedRequestCount) {
            window.offer(current);
            return true;
        }
        return false;
    }
    private void checkAndUpdate(Long currentTime) {
        if(window.isEmpty()) return;
        long calculate = (currentTime - window.peek())/1000;
        while(calculate > timeWindow) {
            window.poll();
            if(window.isEmpty()) break;
            calculate = (currentTime - window.peek())/1000;
        }
    }
}
