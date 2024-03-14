package org.example.algo;

public class SearchAlgo {

    /**
     * It works just for sorted arrays
     * n= 4 [1,2,3,4,5]
     * 1. [1,2] [3,4,5]--> [3,4,5]
     * 2. [3] [4,5] --> [4,5]
     * 3. [4] [5] --> [4]
     * 5. return true
     * @param inArr
     * @param item
     * @return
     */
    public static boolean binarySearch(int[] inArr, int item){
        boolean result = false;
        int middle = inArr.length/2;
        int start = 0;
        int end = inArr.length -1;
        for(int i =start; i<=inArr.length/2; i++){
            System.out.print("start: "+start);
            System.out.print(" end: "+end);
            System.out.println(" middle: "+middle);
            if(item > inArr[middle]){
                start = middle;
            }else{
                end = middle;
            }
            if(item == inArr[i]){
                result = true;
                break;
            }

            middle = (end - start)/2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3,4,5}, 4 ));
    }
}
