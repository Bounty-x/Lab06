public interface SortedList<T extends Comparable<T>> {

    public boolean add(T item);

    public Comparable<T> remove(int pos) throws Exception;

    public Comparable<T> get(int pos) throws Exception;

    public int size();

}
