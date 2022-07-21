class Node{
    String value;
    Node next;
    Node prev;
    Node(String value){
        this.value=value;
    }
}
class BrowserHistory {
    Node head;
    Node curr;

    public BrowserHistory(String homepage) {
        head=new Node(homepage);
        this.curr=head;
    }
    
    public void visit(String url) {
        Node n=new Node(url);
        n.prev=curr;
        curr.next=n;
        curr=n;
    }
    
    public String back(int steps) {
        for(int i=0;i<steps;i++){
            if(curr.prev!=null){
                curr=curr.prev;
            }
        }
        return curr.value;
    }
    
    public String forward(int steps) {
        for(int i=0;i<steps;i++){
            if(curr.next!=null)
                curr=curr.next;
        }
        return curr.value;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */