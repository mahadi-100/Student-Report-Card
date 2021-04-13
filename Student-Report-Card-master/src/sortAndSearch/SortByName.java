package sortAndSearch;

import records.RecordInfo;

import java.util.ArrayList;

public class SortByName {

    public void quickSort(ArrayList<RecordInfo> list, int low, int high){
        if (low < high){
            int pi = partition(list, low, high);

            quickSort(list, low, pi - 1);

            quickSort(list, pi + 1, high);
        }
    }

    private int partition(ArrayList<RecordInfo> list, int low, int high){
        RecordInfo pivot = list.get(high);       //set rightmost index as pivot
        int i = (low - 1);                       //left most index - 1

        for (int j = low; j < high; j++){         //from leftmost index to rightmost index
            if (list.get(j).getName().compareTo(pivot.getName()) <= 0){    //index at j less than or equal pivot then
                i++;                                                       // increment I by one

                RecordInfo temp = list.get(i);                          //i index element swap with j index element
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        RecordInfo temp = list.get(i + 1);         //swap pivot element with (i+1) element
        list.set(i+1, list.get(high));
        list.set(high, temp);
        return (i + 1);               //return (i+1) index.
    }
}
