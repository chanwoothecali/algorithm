package structure;

public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        public String key;
        public String value;
        public Slot next;
        Slot(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public Integer hashFunc(String key){
        return key.charAt(0) % this.hashTable.length;
    }

    public void set(String key, String data){
        Integer addr = hashFunc(key);
        boolean isSameKey = false;
        if(hashTable[addr] != null){
            Slot node = hashTable[addr];
            while(node.next != null){
                if(key.equals(node.key)){
                    node.value = data;
                    isSameKey = true;
                    break;
                }
                node = node.next;
            }
            if(!isSameKey){
                node.next = new Slot(key, data);
            }
        }else{
            hashTable[addr] = new Slot(key, data);
        }
    }

    public String get(String key){
        Integer addr = hashFunc(key);
        if(hashTable[addr] != null){
            if(hashTable[addr].key.equals(key)){
                return hashTable[addr].value;
            }else{
                Slot node = hashTable[addr];
                while(node.next != null){
                    node = node.next;
                    if(node.key.equals(key)){
                        break;
                    }
                }
                return node.value;
            }
        }else{
            return null;
        }
    }

    public void printAll(String key){
        Integer addr = hashFunc(key);
        Slot node = hashTable[addr];
        if(node != null){
            while(node!=null){
                System.out.println(node.value);
                node = node.next;
            }
        }
    }
}