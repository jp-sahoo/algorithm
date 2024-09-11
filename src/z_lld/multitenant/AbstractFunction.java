package z_lld.multitenant;

import java.util.List;

public abstract class AbstractFunction<K, V> implements IFunction<K, V>{
    <T extends Integer> void filter(List<T> ok) {
        System.out.println(ok);
    }

    public K mainAddition(K k, V v) {
        System.out.println(k + " " + v);
        return k;
    }

    <T extends Integer> void execute(List<T> t, K k, V v, Class<T> kClass) {
        filter(t);
        add(k, v);
        mainAddition(k, v);
        System.out.println("");
    }

//    abstract void doSoemthing(K k, V v);
}
