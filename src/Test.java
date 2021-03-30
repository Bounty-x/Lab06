import java.util.Random;

public class Test {

    SortedList<String> list;
    Random r = new Random();

    public Test(){
        list = new SortedArrayList<String>();
    }

    void testRemove(int pos){
        SortedList<String> temp = new SortedArrayList<>();
        temp.add("A");
        temp.add("B");
        temp.add("C");
        System.out.println("Before remove()" + temp.toString());

        try {
            System.out.println("Remove returns: " + temp.remove(pos));
        }catch(Exception e){}
        System.out.println("After remove("+pos+"): " + temp.toString());

    }

    void testPositions(){
        System.out.println("Testing bad positions");
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
        else
            System.out.println("Empty test passed...");

    }

    void testAdd(int n){
        String[] l = new String[]{"A","B","C","D","E","F","G","H"};
        System.out.println("Adding "+ n +" Items...");
        for(int i = 0; i<n; i++){
            String item = l[r.nextInt(7)];
            list.add(item);
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
        Test t = new Test();


        t.testEmpty();
        System.out.println();
        t.testAdd(6);
        System.out.println();
        t.testOrder();
        System.out.println();
        t.testPositions();
        System.out.println();
        t.testRemove(2);
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
    }

}
