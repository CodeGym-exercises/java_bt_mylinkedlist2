public class Mylinkedlist<T> {
    private Node<T> head;
    private int numNodes;

    public Mylinkedlist() {
        this.head = null;
        this.numNodes = 0;
    }

    public void add(int index, T data){
        Node<T> node = new Node<T>(data);
        if(this.head==null){
            this.head=node;
        }else if(index ==0){
            node.next = this.head;
            this.head = node;
        }else{
            Node<T> pointer=this.head;
            for(int i = 0; i < index-1; i++){
                pointer=pointer.next;
            }
            node.next = pointer.next;
            pointer.next = node;
        }
        numNodes++;
    }

    public void addFirst(T data){
        Node<T> node = new Node<T>(data);
        if(this.head==null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
        numNodes++;
    }

    public void addLast(T data){
        Node<T> node = new Node<T>(data);
        if(this.head==null){
            this.head = node;
        }else{
            Node<T> pointer = this.head;
            while(pointer.next!=null){
                pointer=pointer.next;
            }
            pointer.next = node;
        }
        numNodes++;
    }

    public T remove(int index){
        Node<T> node, pointer = this.head;
        if(index==0){
            node = this.head;
            this.head = this.head.next;
            node.next = null;
        }else{
            for(int i = 0; i < index-1; i++){
                pointer=pointer.next;
            }
            node = pointer.next;
            pointer.next = node.next;
            node.next = null;
        }
        numNodes--;
        return node.getData();
    }

    public boolean remove(T data){
        Node<T> pointer = this.head;
        for(int i = 0; i < numNodes; i++){
            if(pointer.data==data){
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    public int size(){
        return this.numNodes;
    }

    public T get(int index){
        Node<T> pointer = head;
        for(int i = 0; i < index; i++){
            pointer = pointer.next;
        }
        return pointer.getData();
    }

    public void clone(Mylinkedlist<T> list){
        Node<T> pointer = head;
        for(int i = 0; i < this.numNodes; i++){
            list.addLast(pointer.data);
            pointer=pointer.next;
        }
    }

    public boolean contains(T data){
        Node<T> pointer = head;
        for(int i = 0; i < this.numNodes; i++){
            if(pointer.getData()==data){
                return true;
            }
            pointer=pointer.next;
        }
        return false;
    }

    public int indexOf(T data){
        Node<T> pointer = head;
        for(int i = 0; i < this.numNodes; i++){
            if(pointer.getData()==data){
                return i;
            }
            pointer=pointer.next;
        }
        return -1;
    }

    public void printList(){
        Node<T> pointer = this.head;
        if(this.head.next ==null){
            System.out.print(this.head.data+ " ");
        }
        else{
            while(pointer!=null){
                System.out.print(pointer.data + " ");
                pointer = pointer.next;
            }
            System.out.println("");
        }
    }

    private class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
        public T getData() {
            return data;
        }
    }
}
