public class Radix{
  public static void radixsort(int[]data){
    int mod = 10;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    MyLinkedList set = new MyLinkedList();
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList[0];
    }
    for (int i = 0; i < data.length; i++){
      if (data[i] > largest){
        largest = data[i];
      }
    }
    Integer.toString(largest).subString(0,1).add(largest);
    }

  }
