package playground;

public interface Publisher<T extends Subscriber>{
    void addSubscriber(T t);
    void removeSubscriber(T t);
    void notifyAllSubscribers();
}
