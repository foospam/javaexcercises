package combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationGenerator {

    public static void main(String[] args) {
        System.out.println(returnAllCombinations(6, 2).size());
    }

    public static List<int[]> returnAllCombinations(int n, int k){
        ArrayList<int[]> combinationContainer = new ArrayList<>();
        int[] firstCombination = new int[k];
        for (int i = 0; i < k; i++) {
            firstCombination[i] = i;
        }

        combinationContainer.add(firstCombination);

        int containerIndex = 0;
        int containerSize = combinationContainer.size();

        while (containerIndex < containerSize) {
            int[] combination = combinationContainer.get(containerIndex);
            int j = findRightmostReplaceable(combination, k, n);
            System.out.println("Combination: "+Arrays.toString(combination)+" "+" Rightmost replaceable "+j);
            if (j > -1) {
                int[] newCombination = new int[k];
                for (int i = 0; i < k; i++) {
                    if (i < j) {
                        newCombination[i] = combination[i];
                    }
                    else {
                        newCombination[i] = combination[j] + (i-j+1);
                    }
                }
                combinationContainer.add(newCombination);
            }

            containerIndex++;
            containerSize = combinationContainer.size();
//            System.out.println(containerIndex);
//            System.out.println(containerSize);
        }

        return combinationContainer;
    };


    public static int findRightmostReplaceable(int[] combination, int k, int n) {
        k--;
        int j = k;

        while (j >= 0 && combination[j] == n-1-k+j) {
            j--;
        }

        if (j >= 0) {
            return j;
        }
        else return -1;
    }

}
