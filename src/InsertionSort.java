import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Connor Heagy
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    for (int i = 0; i < values.length - 1; i++) {
        T key = values[i + 1];
        for (int j = i; j >= 0; j--) {
            if (order.compare(values[j], values[j + 1]) > 0) {
              values[j + 1] = values[j];
              values[j] = key;  
            }
            else {
              break;
            }
          } 
   
      }
  } // sort(T[], Comparator<? super T>
} // class InsertionSort
