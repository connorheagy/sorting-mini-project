import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Connor Heagy and Bhandari, Pranav (in lab)

 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  public <T> void partition(T[] values, Comparator<? super T> order) {
    // choosing and swapping pivot
    T pivot = values[values.length / 2];
    T temp = values[0];
    values[0] = pivot;
    values[values.length / 2] = temp;
  
    // initializing pointers
    int small = 1, large = values.length;
  
    while(small < large) {
      if((order.compare(values[small], values[0]) < 0)) {
        if((order.compare(values[large], values[0]) > 0)) {
          temp = values[small];
          values[small] = values[large];
          values[large] = temp;
          large--;
        }
        small++;
      }
      if((order.compare(values[large], values[0]) > 0)) {
        large--;
      }
    }
  
    temp = pivot;
    pivot = values[small-1];
    values[small-1] = temp;
    }
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values == null || values.length == 0) {
      return;
  }
  //quickSort(values, 0, values.length - 1, order);
  } // sort(T[], Comparator<? super T>

  private <T> void quickSort(T[] arr, int low, int high) {
    if (low < high) {
      //  int pi = partition(arr, low, high);

        // Recursively sort elements before partition and after partition
       // quickSort(arr, low, pi - 1);
       // quickSort(arr, pi + 1, high);
    }
}


} // class Quicksort
