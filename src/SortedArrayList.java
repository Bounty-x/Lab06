import java.util.Iterator;


public class SortedArrayList<T extends  Comparable<T>> implements SortedList<T> {

    protected int size;
    protected T[] a;

    public SortedArrayList() //makes new array list and sets size at 0
    {
//        throw new UnsupportedOperationException("Not yet implemented!");
        a = (T[]) new Comparable[0];
        size = 0;
    }

    @Override
    public boolean add(T item) {
        if(size+1 >= a.length)
            growArray();
        if(size == 0) {
            a[0] = item;
        }

        for(int i = 0;i <= size; i++){
            if(a[i] == null) {
                growArray();
                a[i] = item;
                size++;
                return true;
            }
            else if(a[i].compareTo(item) > 0){ // if a[i] is larger than item
                shift(i);
                a[i] = item;
                size++;
                return true;
            }
        }
        size++;
        return false;
    }

    @Override
    public Comparable<T> get(int pos) throws Exception{
        if(pos >= size)
            throw new IndexOutOfBoundsException();
        return a[pos];
    }


    @Override
    public Comparable<T> remove(int pos) throws Exception{
        if(pos >= size)
            throw new IndexOutOfBoundsException();
//        if(a[pos] == null)
//            throw new NullPointerException();
        Comparable<T> item = a[pos];

        for(int i = pos; i<=size-1; i++){
            a[i] = a[i+1];
        }
        size--;

        return item;
    }

    @Override
    public int size() {
        return size;
    }

    private void growArray(){
        T [] new_arr;
        if(size == 0)
            new_arr = (T[]) new Comparable[1];
        else
            new_arr = (T[]) new Comparable[a.length*2];
        for(int i = 0; i<size; i++){
            new_arr[i] = a[i];
        }
        a = new_arr;
    }

    private void shift(int pos){ //moves items over by 1 starting at pos
        if(size+1 == a.length)
            growArray();
        for(int i = size-1; i >= pos; i--){
            a[i+1] = a[i];
        }
    }

    public String toString(){
        String ans = "[";
        for(int i = 0; i < size; i++){
            ans += a[i] + " " ;
        }
        ans += "]";
        return ans;
    }

}
