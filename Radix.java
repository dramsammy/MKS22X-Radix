public class Radix{
  public static void radixsort(int[]data){
    int mod = 10;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    MyLinkedList set = new MyLinkedList();
    for (int i = 0; i < 20; i++){
      if (buckets[i] == null){
        buckets[i] = new MyLinkedList<Integer>();
    }
  }
    int k = 0;
    // parsing through to figure out if positive or negative value goes in the bucket
    for (int i = 0; i < data.length; i++){
      if (Math.abs(data[i]) > Math.pow(10, k)) {
        // checking length and comparing it to placevalues
        String holder = "" + data[i];
        k = holder.length();
      }
      // adding it to bucket
      set.add(data[i]);
    }
    MyLinkedList temp = new MyLinkedList();
    for (int i = 0; i < k; i++) {
     for (int a = 0; a < data.length; a++) {
       //getting the placevalue
       int digit = Math.abs(getDigit(data[a], i));
       if (data[a] > 0)
       // using buckets in correct order
         buckets[digit+10].add(data[a]);
       else {
         // added for negatives
         buckets[9-digit].add(data[a]);
     }
   }

   for (int x = 0; x < buckets.length; x++) {
     //extending buckets to original list
     if (buckets[x].size() > 0)
       temp.extend(buckets[x]);
     }
   for (int y = 0; y < data.length; y++) {
     // sorting the data in buckets
     data[y] = (int)temp.removeFront();
   }
 }
}


  //function to parse through placevalue for the buckets
  private static int getDigit(int data, int placeValue) {
		int pos = data;
    pos = pos / (int) Math.pow(10, placeValue) % 10;
		return pos;
  }
}
