package structure;

public class BinarySearchTree {
    Node head = null;

    public class Node{
        Node left = null;
        Node right = null;
        int value;

        public Node(int data){
            this.value = data;
        }
    }

    public boolean insertNode(int data){
        if(head == null){
            this.head = new Node(data);
            return true;
        }else{
            Node node = this.head;
            while(node != null){
                if(data < node.value){
                    if(node.left != null){
                        node = node.left;
                    }else{
                        node.left = new Node(data);
                        break;
                    }
                }else if(data > node.value){
                    if(node.right != null){
                        node = node.right;
                    }else{
                        node.right = new Node(data);
                        break;
                    }
                }else{
                    return false;
                }
            }
            return true;
        }
    }

    public void printAll(){
        Node node = this.head;
        System.out.println(node.value);

    }

    public Node searchNode(int data){
        if(this.head == null){
            return null;
        }else{
            Node node = this.head;
            while(node != null){
                if(data < node.value){
                    node = node.left;
                }else if(data > node.value){
                    node = node.right;
                }else{
                    return node;
                }
            }
            return null;
        }
    }

    public boolean delete(int data){
        if(head == null){
            return false;
        }

        Node parentNode = null;
        Node currNode = this.head;
        while(currNode != null){
            if(data < currNode.value){
                parentNode = currNode;
                currNode = currNode.left;
            }else if(data > currNode.value){
                parentNode = currNode;
                currNode = currNode.right;
            }else{
                break;
            }
        }

        // CASE 1: currNode == leafNode
        if(currNode.left == null && currNode.right == null){
            if(parentNode != null){
                if(parentNode.right == currNode){
                    parentNode.right = null;
                }else{
                    parentNode.left = null;
                }
            }else{
                this.head = null;
            }
            return true;
            // CASE 2: currNode.childNode.count = 1
        }else if(currNode.left == null || currNode.right == null){
            if(currNode.left == null){
                if(parentNode.right == currNode){
                    parentNode.right = currNode.right;
                }else{
                    parentNode.left = currNode.right;
                }
            }else{
                if(parentNode.right == currNode){
                    parentNode.right = currNode.left;
                }else{
                    parentNode.left = currNode.left;
                }
            }
            return true;
            // CASE 3: currNode.childNode.count = 2
        }else{
            Node leftNode = currNode.left;
            Node leftParNode = currNode;
            while(leftNode.left != null){
                leftParNode = leftNode;
                leftNode = leftNode.left;
            }
            leftParNode.left = null;
            parentNode.left = leftNode;
            return true;
        }
    }
}