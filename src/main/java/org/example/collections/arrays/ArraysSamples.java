package org.example.collections.arrays;

import java.util.Arrays;

/**
 * Arrays are efficient to access a specific item at a specific index in array.
 *
 * If you plan on searching for specific items in your data frequently, you should use a hashmap instead.
 */
public class ArraysSamples {
    private static void initialize(){
        int[] nums;
        double[] doubles = new double[5];
        String[] womenNames = new String[]{"lia","pao","nati"};
        String[] menNames = new String[]{"Matias","julian","luis","cesar"};

        nums = new int[1];
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(doubles));
        System.out.println(Arrays.toString(womenNames));
        System.out.println(Arrays.toString(menNames));
    }

    private static void swapItemsBetween(String[] arr1, String[] arr2, int position){
        String arr1Element = arr1[position];
        arr1[position] = arr2[position];
        arr2[position] = arr1Element;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * Mindset: Me: In an interview Try to star with imperative style (for instead a stream)
     * Example:
     * input:  [3,5,7,2,1]
     * output: 35 (5*7)
     * @param intArray
     * @complexity: O(n log(n)) + O(n)
     * @return
     */
    private static int maximumProductMySolution(int[] intArray){
        System.out.println("::::::::maximumProduct:::::::::");
        int result = 0;
        Arrays.sort(intArray);
        for(int nextPosition = 1; nextPosition < intArray.length; nextPosition++){
            if((intArray[nextPosition]*intArray[nextPosition-1]) > result){
                result = intArray[nextPosition]*intArray[nextPosition-1];
            }
        }
        return result;
    }

    /**
     * It is not neccessary to go through a loop for finding the maxProduct (my solutions feels :( )
     * @param intArray
     * @return
     * @complexity: O(n log(n))
     */
    private static int maximumProductBetter2(int[] intArray){
        System.out.println("::::::::maximumProductBetter2:::::::::");
        int result = 0;
        Arrays.sort(intArray);
        return intArray[intArray.length-2] * intArray[intArray.length-1];
    }

    /**
     * O(n)
     * @param intArray
     * @return
     */
    private static int maximumProductBetterMySolutionV1(int[] intArray){
        System.out.println("::::::::maximumProductBetterMySolutionV1:::::::::");
        int max1 = 0;
        int max2 = 0;

        int indexMax1 = 0;
        for(int position =0; position < intArray.length; position++){
            int positionValue = Math.abs(intArray[position]);
            if(positionValue > max1){
                max1 = positionValue ;
                indexMax1 = position;
            }
        }
        for(int position = 0; position < intArray.length; position++){
            int positionValue = Math.abs(intArray[position]);
            if(positionValue>max2 && position!= indexMax1){
                max2 = positionValue;
            }
        }

        return max1 * max2;
    }

    private static int maximumProductBetterV2(int[] intArray){
        System.out.println("::::::::maximumProductBetterV2:::::::::");
        int max1 = intArray[0];
        int max2 = 0;

        for(int position =1; position < intArray.length; position++){
            int positionValue = Math.abs(intArray[position]);
            if(positionValue > max1){
                max2 = max1 ;
                max1 = positionValue;
            }else if(positionValue > max2){
                max2 = positionValue;
            }
        }
        return max1 * max2;
    }

    public static void main(String[] args) {
        initialize();
        swapItemsBetween( new String[]{"lia","pao","nati"}, new String[]{"Matias","julian","luis","cesar"}, 1);
        System.out.println(maximumProductMySolution(new int[]{3,5,2,7,1}));
        System.out.println(maximumProductBetter2(new int[]{3,5,2,7,1}));
        System.out.println(maximumProductBetterMySolutionV1(new int[]{7,3,5,2,1, -8}));
        System.out.println(maximumProductBetterV2(new int[]{3,5,2,1,7, -8}));
        System.out.println(maximumProductBetterV2(new int[]{7,3,5,2,1,}));
    }
}
