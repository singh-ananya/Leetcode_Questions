class BrowserHistory {
    class Node {
        String url;
        Node prev;
        Node next;
        
        Node(String url){
            this.url = url;
        }
    }
    Node head;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
    }
    
    public void visit(String url) {
        Node temp = new Node(url);
        
        temp.prev = head;
        temp.next = null;
        
        head.next = temp;
        head = temp;
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps && head.prev != null; i++){
             head = head.prev;
        }
        return head.url;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps && head.next != null; i++){
            head = head.next;
        }
        return head.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */