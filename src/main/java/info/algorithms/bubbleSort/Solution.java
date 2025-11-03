package info.algorithms.bubbleSort;

import java.util.Arrays;

public class Solution {

    public void bubbleSort(int[] input){

        boolean wasChangedElement;

        for (int i = 0; i <input.length-1; i++) {
            wasChangedElement=false;
            for (int j = 1; j < input.length-i; j++) {
                if (input[j-1]>input[j]){
                    swap(input,j-1,j);
                    wasChangedElement=true;
                }
            }
            if (!wasChangedElement){
                break;
            }
        }
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i]=input[j];
        input[j]=temp;
    }

    public static void main(String[] args) {
        int[] input = {1,10,2,12,3,15,4,18,7,20,13};
        System.out.println("массив до применения сортировки");
        System.out.println(Arrays.toString(input));
        Solution solution = new Solution();
        solution.bubbleSort(input);
        System.out.println("массив после применения сортировки");
        System.out.println(Arrays.toString(input));
    }
}
