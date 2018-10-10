public class Test {
    public static void main(String[] args) {
        Mylinkedlist<Integer> list = new Mylinkedlist<Integer>(), ltemp = new Mylinkedlist<Integer>();
        list.addFirst(4);
        list.addFirst(7);
        list.addFirst(3);
        list.printList();
        System.out.println(list.contains(7));
        System.out.println(list.indexOf(7));
        list.printList();

        list.clone(ltemp);
        ltemp.printList();
    }
}
