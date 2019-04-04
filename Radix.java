public class Radix{
  public static void radixsort(int[]data){
    int mod = 10;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    MyLinkedList set = new MyLinkedList();
    for (int i = 0; i < 20; i++){
      if (buckets[i] == null){
        buckets[i] = new MyLinkedList[0];
    }
  }
    int num = 0;
    for(int i = 0; i < data.length; i++){

      if(ans > num){
        num = ans;
      }
    }
  }
  //function to parse through placevalue for the buckets
  private static int getDigit(int data, int placeValue) {
		int pos = data;
    pos = pos / (int) Math.pow(10, placeValue) % 10;
		if (data < 0) {
			return pos = pos * -1;
		}
		return pos;
  }
}
