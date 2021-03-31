
public class SortedLinkedList<T extends Comparable<T>> implements SortedList {


    class Node<T extends Comparable<T>> {
        Comparable data;
        Node next = null;
        public Node(Comparable data){
            this.data = data;
        }
    }

    Node head;
    int size;

    public SortedLinkedList(){
//        Node dummy = new Node(null);
        head = null;
        size = 0;
    }

    @Override

    public boolean add(Comparable item) {// adds a new node containing item in its Comparable order.
        Node node = new Node(item);
        Node prev = head;
        if(head == null){
            head = node;
            size++;
            return true;
        }

        for(int i = 0; i < size -1; i++){
            if(prev.next.data.compareTo(item) > 0){//if prev's next is greater than our item
                node.next = prev.next;
                prev.next = node;
                size++;
                return true;
            }
            prev = prev.next;
        }
        if(size == 1){//if we need to change the head
            node.next = head;
            head = node;
            size++;
            return true;
        }
        else{//if the node is in order at the end of the list
            prev.next = node;
            size++;
            return true;
        }
    }


//    public boolean add(Comparable item) {
//        Node node = new Node(item);
//        Node prev = head;
//        Node walk = head.next;
//        if(prev == null){
//            head = node;
//            size++;
//            return true;
//        }
//        if(head.data.compareTo(item) > 0){
//            node.next = head.next;
//            head = node;
//        }
//        for(int i = 1; i<size; i++) {
//            System.out.println("walk.compareTo(item): "+(walk.data.compareTo(item)));
//            if (walk.data.compareTo(item) > 0) {
//
//            }
//
//        }
//        return false;
//    }


//    public boolean add(Comparable item) {// adds a new node containing item in its Comparable order.
//        Node node = new Node(item);
//        boolean firstItem = true;
//        if(head == null){//special case if first item
//            head = node;
//            size++;
//            return true;
//        }
//        else{//else need to loop to find its place in order
//            Node walk = head;
//            for(int i = 0; i<size; i++){
//                //check current walk
//                System.out.println("walk.compareTo(item): "+(walk.data.compareTo(item)));
//                if(walk.data.compareTo(item) > 0){
//                    //if true start swap sequence
//                     if(walk == head) { //special case
//                         node.next = head;
//                         head = node;
//                         size++;
//                         return true;
//                     }
//                    node.next = walk;
//
//                }
//                walk = walk.next;
//            }
//        }
//
//        return false;
//    }

    @Override
    public Comparable remove(int pos) throws Exception{
        Node remove;
        Node prev = head;
        if(pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(pos == 0){
            remove = head;
            head = head.next;
            size--;
            return remove.data;
        }

        for(int i = 0; i < pos - 1; i++){
            prev = prev.next;
        }
        remove = prev.next;
        prev.next = remove.next;
        size--;
        return remove.data;
    }

    @Override
    public Comparable get(int pos) throws Exception{ //loops the linkedlist pos -1 times and returns next data.
        if(pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException();
        Node node = head;
        for(int i = 0; i < pos-1; i++){
            node = node.next;
        }
        return node.next.data;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString(){
        String ans = "[ ";
        Node node = head;
        try {
            while (node != null) {
                ans += node.data + " ";
                node = node.next;
            }
        }catch(Exception e){System.out.println("Empty");}
        ans += "]";
        return ans;
    }

}
