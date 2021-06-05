package compare;

public interface Compare<T1, T2> {
    boolean compare(T1 t1, T2 t2);
}
