public class Radix{
  public static void radixsort(int[]data){
    int largest = 0;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < 20; i++){
      String x = (Integer.toString(i));
      MyLinkedList<Integer>[] x = new MyLinkedList[0];
    }
    for (int i = 0; i < data.length; i++){
      if (data[i] > largest){
        largest = data[i];
      }
    }
    Integer.toString(largest).subString(0,1).add(largest);
    }

  }
