package org.example.collections.arrays;

/**
 * This algorithm works if the input is a sorted array
 */
public class BinarySearch {

    /**
     * My implementation
     * @param input
     * @param n
     * @return
     */
    public static boolean bSearch(int[] input, int n){
        System.out.println("---bSearchV1 Gonna search -> "+n+" -------------");
        int from = 0;
        int to = input.length-1;

        for(int i = 0; i<=input.length/2; i++){
            System.out.println("i-> "+i);
            System.out.println("from-> "+from);
            if(input[from] == n || input[to] == n){
                return true;
            }

            if(n > input[from]){
                from = from + (to-from)/2;
            }else{
                to = from;
                from = to/2;
            }
        }

        return false;
    }


    /**
     * Course im
     * @param input
     * @param n
     * @return
     */
    private static boolean bSearchV2(int[] input, int n){
        System.out.println("---bSearchV2 Gonna search -> "+n+" -------------");
        int from = 0;
        int to = input.length-1;
        while(from<=to){
            System.out.println("from-> "+from);
            System.out.println("to-> "+to);
            int mid = (from+to)/2;
            if(input[mid] == n){
                return true;
            }

            if(n > input[mid]){
                from = mid + 1;
            }else{
                to = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        /*System.out.println(bSearch(new int[]{0,7,10,20,39,50,92}, 0));
        System.out.println(bSearch(new int[]{0,7,10,20,39,50,92}, 7));
        System.out.println(bSearch(new int[]{0,7,10,20,39,50,92}, 10));
        System.out.println(bSearch(new int[]{0,7,10,20,39,50,92}, 20));
        System.out.println(bSearch(new int[]{0,7,10,20,39,50,92}, 39));
        System.out.println(bSearch(new int[]{0,7,10,20,39,50,92}, 50));
        System.out.println(bSearch(new int[]{0,7,10,20,39,50,92}, 92));
        System.out.println(bSearch(new int[]{0,7,10,20,39,50,92}, 100));*/

        System.out.println(bSearchV2(new int[]{0,7,10,20,39,50,92}, 0));
        System.out.println(bSearchV2(new int[]{0,7,10,20,39,50,92}, 7));
        System.out.println(bSearchV2(new int[]{0,7,10,20,39,50,92}, 10));
        System.out.println(bSearchV2(new int[]{0,7,10,20,39,50,92}, 20));
        System.out.println(bSearchV2(new int[]{0,7,10,20,39,50,92}, 39));
        System.out.println(bSearchV2(new int[]{0,7,10,20,39,50,92}, 50));
        System.out.println(bSearchV2(new int[]{0,7,10,20,39,50,92}, 92));
        System.out.println(bSearchV2(new int[]{0,7,10,20,39,50,92}, 100));
    }
}
