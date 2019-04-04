public class MyLinkedList<E>{
  private class Node{
    private int data;
    private Node next,prev;
    public Node(Node ReferenceFrom, int Number, Node ReferenceTo){
      next = ReferenceTo;
      prev = ReferenceFrom;
      data = Number;
    }
    public Node next(){
      return next;
    }
    public Node prev(){
      return prev;
    }
    public void setNext(Node other){
      next = other;
    }
    public void setPrev(Node other){
      prev = other;
    }
    public Integer setData(Integer other){
      Integer temp = data;
      data = other;
      return temp;
    }
    public Integer getData(){
      return data;
    }
    public String toString(){
      return "" + data;
    }
  }
  private int size;
  private Node start,end;
  // Empty Constructor
  public MyLinkedList(){
    start = null;
    end = null;
    size = 0;
}
  public boolean add(int value){
    if (size == 0){
      Node first = new Node(null, value, null);
      start = first;
      end = first;
      size++;
      return true;
    }
    if (size >= 1){
      Node latest = new Node (null, value, end);
      end.setNext(latest);
      end = latest;
      size++;
      return true;
    }
    return true;
  }
  public void clear(){
    start = null;
    end = null;
    size = 0;
}
public int size(){
  return size;
}
  public void extend(MyLinkedList other){
    if (this.size == 0){
      this.size = other.size;
      this.start = other.start;
      this.end = other.end;
      other.clear();
    }
    else if (other.size() > 0){
      this.size = this.size + other.size;
      this.end.setNext(other.start);
      other.start.setPrev(end);
      this.end = other.end;
      other.clear();
    }
}
  public Integer removeFront(){
    if (size == 1){
      Integer value = start.getData();
      start = null;
      end = null;
      size = 0;
      return value;
    }
    Integer returnNumber = start.next().getData();
    Node temp = start;
    Node next;
    next = start.next();
    start = next;
    next.setPrev(null);
    temp.setNext(null);
    size--;
    return temp.getData();
  }
}
