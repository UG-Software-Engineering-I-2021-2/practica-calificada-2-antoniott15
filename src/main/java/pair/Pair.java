package pair;

public final   class Pair<T, D> {
    private final  T first;
    private final D second;

    public Pair(T first, D second) {
        this.first  = first;
        this.second = second;
    }

    public T first() {
        return first;
    }

    public D second() {
        return second;
    }
}
