package structure;

public class DoublyLinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private class Node{
        private Object data;
        private Node prev = null;
        private Node next = null;

        public Node(Object input){
            this.data = input;
        }

        public String data(){
            return String.valueOf(this.data);
        }

        public String prev(){
            if(this.prev!=null){
                return String.valueOf(this.prev.data);
            }else{
                return null;
            }
        }

        public String next(){
            if(this.next!=null){
                return String.valueOf(this.next.data);
            }else{
                return null;
            }
        }
    }

    private void createLinkedList(Object input){
        head = new Node(input);
        tail = head;
        size++;
    }

    private Node searchNode(int index){
        if(index==0){
            return this.head;
        }else if(index==size-1){
            return this.tail;
        }else if(index>=size || index<0){
            return null;
        }else if(size/2 > index){
            Node node = head;
            for(int i=0; i<index; i++){
                node = node.next;
            }
            return node;
        }else{
            Node node = tail;
            for(int i=0; i<size-index-1; i++){
                node = node.prev;
            }
            return node;
        }
    }

    public void addNodeFirst(Object input){
        if(head == null){
            createLinkedList(input);
        }else{
            Node newNode = new Node(input);
            newNode.next = head;
            head.prev = newNode;
            this.head = newNode;
            size++;
        }
    }

    public void addNodeLast(Object input){
        if(head == null){
            createLinkedList(input);
        }else{
            Node newNode = new Node(input);
            newNode.prev = tail;
            tail.next = newNode;
            this.tail = newNode;
            size++;
        }
    }

    public void add(int index, Object input){
        if(index == 0){
            addNodeFirst(input);
        }else if(index == size){
            addNodeLast(input);
        }else {
            // index번째 노드
            Node searchedNode = searchNode(index);
            // 새로 삽입될 노드
            Node newNode = new Node(input);

            if(searchedNode != null){
            /*searchedNode.next.prev = newNode;
            newNode.next = searchedNode.next;
            searchedNode.next = newNode;
            newNode.prev = searchedNode;*/
                newNode.next = searchedNode;
                newNode.prev = searchedNode.prev;
                searchedNode.prev.next = newNode;
                searchedNode.prev = newNode;
                size++;
            }
        }
    }

    public void printAll(){
        if(head==null) System.out.println("Empty List.");
        Node node = head;
        int index = 0;
        System.out.println("size - " + this.size);
        System.out.println("head - " + headData());
        while(node!=null){
            System.out.println(index + " - data : " + node.data() + ", prev : " + node.prev() + ", next : " + node.next());
            index++;
            node = node.next;
        }
        System.out.println("tail - " + tailData());
    }

    public String headData(){
        return String.valueOf(this.head.data);
    }

    public String tailData(){
        return String.valueOf(this.tail.data);
    }

    private Object remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        if(node != head) prevNode.next = nextNode;
        if(node != tail) nextNode.prev = prevNode;
        if(node == head) this.head = nextNode;
        if(node == tail) this.tail = prevNode;
        size--;
        Object returnData = node.data;
        node = null;
        return returnData;
    }

    public Object removeIndex(int index){
        if(index<0 || index>=size){
            return null;
        }else {
            Node node = searchNode(index);
            return remove(node);
        }
    }

    public Object get(int index){
        return searchNode(index).data;
    }
}