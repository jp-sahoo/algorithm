package playground;

import java.util.*;

public abstract class MasterPublisher implements Publisher<Subscriber>{
    List<Subscriber> subscriberList = new LinkedList<>();
    @Override
    public void notifyAllSubscribers() {
        for(Subscriber s: subscriberList) {
            s.notifySelf();
            NavigableMap<Integer, SortedSet<Integer>> help = new TreeMap();
        }
    }
}
