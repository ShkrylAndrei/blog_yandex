package info.shkryl.array;

public class FindMinElement {

    public static void main(String[] args) {
        int[] array = {62,42,74,41,31,53,16,24};
        int minValue = array[0];
        int minIndex = 0;

        for (int i = 2; i < array.length; i++) {
            if (array[i]<minValue){
                minValue = array[i];
                minIndex=i;
            }
        }

        System.out.println("Index of min element equals: "+minIndex);
        System.out.println("Min element equals: "+minValue);
    }
}
