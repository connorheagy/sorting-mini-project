import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Connor Heagy
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  
public <T> void mergeHelper(T[] vals, int lo, int hi, Comparator<? super T> comparator) {
  int midVal = vals.length / 2;
  if (lo == midVal - 1) {
    if (comparator.compare(vals[lo], vals[midVal]) >= 0) {
      T tmp = vals[lo];
      vals[lo] = vals[midVal];
      vals[midVal] = tmp;
    }
  }
  else {
    mergeHelper(vals, lo, midVal, comparator);
  }
  merge(vals, lo, midVal, hi, comparator);
  if (hi == midVal + 1) {
    if (comparator.compare(vals[hi], vals[midVal]) < 0) {
      T tmp = vals[hi];
      vals[hi] = vals[midVal];
      vals[midVal] = tmp;
    }
  }
  else {
    mergeHelper(vals, midVal, hi, comparator);
  }
}

public <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
   T lowVal = vals[lo];
   T midVal = vals[mid];
   T[] sortedVals = Arrays.copyOfRange(vals,lo, hi);
   int lowIn = lo;
   int midIn = mid;
   int index = 0;
   while ((lowIn != mid) && (midIn != hi)){
     if (comparator.compare(lowVal, midVal) <= 0){
       sortedVals[index] = lowVal;
       lowIn++;
       lowVal = vals[lowIn]; 
     } else {
       sortedVals[index] = midVal;
       midIn++;
       midVal = vals[midIn]; 
     }
     index++;
   }
   if (lowIn == mid){
     while (index != hi){
       sortedVals[index] = vals[midIn];
       index++;
       midIn++;
     }
   } else { 
     while (index != hi){
       sortedVals[index] = vals[lowIn];
       index++;
       lowIn++;
     }
   } 

  }

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values == null || values.length <= 1) {
      return; // Base case: array is already sorted or empty
  }
  mergeHelper(values, 0, values.length - 1, order);
    
  } // sort(T[], Comparator<? super T>
} // class MergeSort
