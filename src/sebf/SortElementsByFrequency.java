package sebf;

import java.util.*;

/**
 * Created by IntelliJ IDEA
 * User: Abhinav Bhardwaj
 * Date: 05/03/22
 * Time: 21:48
 */


public class SortElementsByFrequency {
    public static void SEBF (List<Integer> list, Integer [] arr) {
        int size = arr.length;

        final HashMap<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
        final HashMap<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();

        for (int index = 0; index < size; index++) {
            if (mapCount.containsKey(arr[index])) {
                mapCount.put(arr[index], mapCount.get(arr[index]) + 1);
            }
            else {
                mapCount.put(arr[index], 1);
                mapIndex.put(arr[index], index);
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                int freq1 = mapCount.get(n1);
                int freq2 = mapCount.get(n2);

                if (freq1 != freq2) {
                    return (freq2 - freq1);
                }
                else {
                    return mapIndex.get(n1)- mapIndex.get(n2);
                }
            }
        });

        System.out.println("\nSorted Array based on the frequency of the elements:");
        for(int index = 0; index < list.size(); index++){
            System.out.print(list.get(index) + " ");
        }
        System.out.println("\n");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nSize of the array: ");
        int size = sc.nextInt();

        Integer arr[] = new Integer[size];

        System.out.print("\nElements of the array (space seperated): ");
        for(int index = 0; index < size; index++) {
            arr[index] = sc.nextInt();
        }

        SEBF(Arrays.asList(arr), arr);
    }
}
