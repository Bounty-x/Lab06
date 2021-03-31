import java.util.Random;

public class Test {

    SortedList<String> list;
    Random r = new Random();

    public Test(int i){
        if( i == 1)
            list = new SortedArrayList<String>();
        else if (i == 0){
            list = new SortedLinkedList<String>();
        }
    }

    void testRemove(int pos){
        SortedList<String> temp = new SortedArrayList<>();
        temp.add("A");
        temp.add("B");
        temp.add("C");
        System.out.println("Before remove("+ pos +")" + temp.toString());

        try {
            System.out.println("Remove returns: " + temp.remove(pos));
        }catch(Exception e){}
        System.out.println("After remove("+pos+"): " + temp.toString());

    }

    void testPositions(){
        System.out.println("Testing bad positions get(99) & remove(99)");
        try {
            list.get(99);
        }catch(Exception e){
            System.out.println("Get: Index out of bounds thrown...");
        }
        try{
            list.remove(99);
        }catch(Exception e){
            System.out.println("Remove: Index out of bounds thrown");
        }

    }

    void testOrder(){
        for(int i = 0; i<list.size()-1; i++){
            try {
                if (list.get(i).compareTo((String) list.get(i + 1)) > 0) {
                    System.out.println("NOT IN ORDER...");
                }
            }catch(Exception e){System.out.println("Out of bounds...");}
        }
        System.out.println("ORDER TEST COMPLETE");
    }

    void testEmpty(){
        if(list.size() != 0)
            System.out.println("Size is not 0 at initialization");
        try{System.out.println("testing get error handling... get(99)");
            list.get(99);
        }catch(Exception e){System.out.println("Error passed");}
            System.out.println("Empty test passed...");

    }

    void testAdd(int n){
        String[] l = new String[]{"A","B","C","D","E","F","G","H"};
        System.out.println("Adding "+ n +" Items...");
        for(int i = 0; i<n; i++){
            String item = l[r.nextInt(7)];
            list.add(item);
            System.out.println("SIZE: " + list.size());
        }
        System.out.println("Testing get...");
        for(int j = 0; j<list.size(); j++){
            try {
                System.out.println(list.get(j));
            }catch(Exception e){System.out.println("out of bounds...");}
        }
        if(list.size() != n){
            System.out.println("List not equal to size!");
        }
        System.out.println(list.toString());
        System.out.println("Add test complete");
    }


    public static void main(String[] args){

        SortedList<String> intArrayList = new SortedArrayList<>();
        SortedList<String> ll = new SortedLinkedList<>();
        //Using 1 for constructor creates SORTEDARRAYLIST
        //Using 0 for constructor creates SORTEDLINKEDLIST
        Test arrayList = new Test(1);
        Test linkedList = new Test(0);


        linkedList.testEmpty();
        System.out.println();
        linkedList.testAdd(6);
        System.out.println();
        linkedList.testOrder();
        System.out.println();
        linkedList.testPositions();
        System.out.println();
        linkedList.testRemove(0);

        //COMMENT OUT DIFFERENT TESTS
        System.out.println("++++++++++++++++++++ ARRAYLIST TESTS ++++++++++++++++++++");

        arrayList.testEmpty();
        System.out.println();
        arrayList.testAdd(6);
        System.out.println();
        arrayList.testOrder();
        System.out.println();
        arrayList.testPositions();
        System.out.println();
        arrayList.testRemove(0);
//
//        System.out.println(intArrayList.toString());
//        intArrayList.add("C");
//        System.out.println(intArrayList.toString());
//        intArrayList.add("A");
//        System.out.println(intArrayList.toString());
//        intArrayList.add("B");
//        System.out.println(intArrayList.toString());
//        intArrayList.add("B");
//        System.out.println(intArrayList.toString());
//        try {
//            intArrayList.remove(3);
//        }catch(Exception e){}
//        System.out.println(intArrayList.toString());
//
//        System.out.println(ll.toString());
//        System.out.println("Size: " + ll.size());
//        ll.add("B");
//        System.out.println(ll.toString());
//        System.out.println("Size: " + ll.size());
//        ll.add("A");
//        System.out.println(ll.toString());
//        System.out.println("Size: " + ll.size());
//        ll.add("C");
//        System.out.println(ll.toString());
//        System.out.println("Size: " + ll.size());
//        ll.add("F");
//        System.out.println(ll.toString());
//        System.out.println("Size: " + ll.size());
//        ll.add("E");
//        System.out.println(ll.toString());
//        System.out.println("Size: " + ll.size());
//        ll.add("D");
//        System.out.println(ll.toString());
//        System.out.println("Size: " + ll.size());
//        try{ll.remove(0);}catch(Exception e){}
//        System.out.println(ll.toString());
//        System.out.println("Size: " + ll.size());
//        try{ll.remove(4);}catch(Exception e){}
//        System.out.println(ll.toString());
//        System.out.println("Size: " + ll.size());
//
//        try{System.out.println("GET(3): " + ll.get(3));}catch(Exception e){}

    }

}
