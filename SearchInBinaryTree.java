class Node {
    int data;
    Node left;
    Node right;
    
    Node(){}
    
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
    
    int getData(){
        return data;
    }
    
    Node getLeft(){
        return left;
    }
    
    Node getRight(){
        return right;
    }
    
    void setLeft(Node node){
        left = node;
    }
    
    void setRight(Node node) {
        right = node;
    }
}

class BTree {
    Node root;
    
    BTree(){
        root = null;
    }
    
    public void insertDataInBTree(int data){
        root = insertNode(root, data);
    }
    
    private Node insertNode(Node node, int data){
        if(node == null) {
            node = new Node(data);
        }
        else if(node.getData() > data){
            node.setLeft(insertNode(node.getLeft(), data));
        }
        else if(node.getData() < data) {
            node.setRight(insertNode(node.getRight(), data));
        }
        return node;
    }
    
    public void printInorder(){
        if(root == null) {
            System.out.println("Empty BTree");
        }
        else {
            inorderTraversal(root);
        }
    }
    
    private void inorderTraversal(Node node) {
        if(node != null) {
            inorderTraversal(node.getLeft());
            System.out.println(node.getData());
            inorderTraversal(node.getRight());
        }
    }
    
    public void searchDataInBTree(int data){
        System.out.println("\n==============================================\nStarting search for: " + data);
        Node foundNode = searchNode(root, data);
    }
    
    private Node searchNode(Node node, int data) {
        if(node == null) {
           System.out.println("Not Found");
           return null;
        }
        else {
            System.out.println("checking " + node.getData());
            
            if(node.getData() == data) {
            System.out.println("Found " + node.getData());
            return node;
        }
        else if(node.getData() > data) {
            
            return searchNode(node.getLeft(), data);
        }
        else {
            return searchNode(node.getRight(), data);
        }

        }
    }
}

public class SearchInBinaryTree.java
{
	public static void main(String[] args) {
	
		BTree btree = new BTree();
		
		btree.insertDataInBTree(8);
		btree.insertDataInBTree(5);
		btree.insertDataInBTree(2);
		btree.insertDataInBTree(3);
		btree.insertDataInBTree(6);
		btree.insertDataInBTree(10);
		
		btree.printInorder();
		
		btree.searchDataInBTree(8);
		btree.searchDataInBTree(5);
		btree.searchDataInBTree(3);
		btree.searchDataInBTree(2);
		btree.searchDataInBTree(6);
		btree.searchDataInBTree(10);
		btree.searchDataInBTree(1);
	}
}
