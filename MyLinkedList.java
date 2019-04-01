public class MyLinkedList{
  private class Node{
    private Object data;
    private Node next,prev;
    public Node(Node ReferenceFrom, Object Number, Node ReferenceTo){
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
    public Object setData(Object other){
      Object temp = data;
      data = other;
      return temp;
    }
    public Object getData(){
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
  // Returns the size of the MyLinkedList
  public int size(){
    return size;
  }
  public boolean add(Object value){
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
  private Node getNth(int x){
    Node workspace = start;
    for (int i = 0; i < x; i++){
      workspace = workspace.next();
    }
    return workspace;
  }
  public Object get(int index){
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException("Index is not in range");
    }
    Node work = getNth(index);
    return work.getData();
  }
  public Object set(int index, Integer v){
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException("Index is not in range");
    }
    Node work = getNth(index);
    Object temp = work.getData();
    work.setData(v);
    return temp;
  }
  public boolean contains(Object v){
    for (int i = 0; i < size; i++){
      if (getNth(i).getData() == v){
        return true;
      }
    }
    return false;
  }
  public int indexOf(Object v){
    if (contains(v)){
      for (int i = 0; i < size; i++){
        if (getNth(i).getData() == v){
          return i;
        }
    }
  }
    return -1;
}
  public void add(int i, Object v){
    if (i >= size || i < 0){
      throw new IndexOutOfBoundsException("Index is not in range");
    }
    if (i == size){
      add(v);
    }
    Node add = new Node(null, v, null);
    if (i == 0){
      add.setPrev(null);
      add.setNext(getNth(0));
      start = add;
      size++;
    }
    else{
      Node work = getNth(i);
      Node before = getNth(i -1);
      before.setNext(add);
      work.setPrev(add);
      add.setPrev(before);
      add.setNext(work);
      size++;
    }
  }
  public Object remove(int i){
    if (i >= size || i < 0){
      throw new IndexOutOfBoundsException("Index is not in range");
  }
    Node prev;
    Node next;
    Object temp = get(i);
    Node work = getNth(i);
    if (i == 0){
      next = work.next();
      next.setPrev(null);
      start = next;
      size --;
    }
    else if (i == size - 1){
      size--;
    }
    else{
      prev = getNth(i -1);
      next = getNth(i + 1);
      prev.setNext(next);
      next.setPrev(prev);
      size--;
    }
    // work.prev().setNext(work.next());
    // work.next().setPrev(work.prev());
    // size--;
    return temp;
}
  public boolean remove(Object integer){
    if (contains(integer) == false){
      return false;
    }
    remove(indexOf(integer));
    return true;
  }
  public void extend(MyLinkedList other){
    if (this.size == 0){
      this.size = other.size;
      this.start = other.start;
      this.end = other.end;
    }
    else{
      this.size = this.size + other.size;
      this.end.setNext(other.start);
      this.end = other.end;
      other.clear();
    }
  }
  public Object removeFront(Object e){
    return remove(indexOf(e));
  }
  public String toString(){
    if (size ==0){
      return "[]";
    }
    String returnvalue = "[";
    for (int i = 0; i < size - 1 ; i++){
      returnvalue += getNth(i).getData() + ", ";
      }
    returnvalue+=  getNth(size -1).getData() + "]";
    return returnvalue;
}

  }
