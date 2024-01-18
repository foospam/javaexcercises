package combinations;

import java.util.*;

public class Simulation2 {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            List<List<Integer>> result = shuffler(13, 4, 2);
            checkResults(result, 13, 4, 2);
        }

    }

    public static List<List<Integer>> shuffler(int n, int m, int k) {

        List<Integer[]> result = new ArrayList<>();

        Integer[] current = new Integer[n];
        for (int i = 0; i < n; i++) {
            current[i] = i;
        }

//        System.out.println(Arrays.toString(current));

        result.add(current);
        for (int i = 0; i < n + (n - k * m); i++) {
            Integer[] last = result.get(i);
            Integer[] excluded = Arrays.copyOfRange(last, k * m, last.length);
//            System.out.println("Excluded "+Arrays.toString(excluded));
            Integer[] included = Arrays.copyOfRange(last, 0, k * m);
            shuffleArray(included);
            Integer[] nextIncluded = new Integer[k * m];
            System.arraycopy(excluded, 0, nextIncluded, 0, excluded.length);
            System.arraycopy(included, 0, nextIncluded, excluded.length, k * m - excluded.length);
//            System.out.println("Next included "+Arrays.toString(nextIncluded));

            Integer[] nextExcluded = Arrays.copyOfRange(included, included.length - excluded.length, included.length);
//            System.out.println("Next excluded"+Arrays.toString(nextExcluded));
            shuffleArray(nextIncluded);
            Integer[] nextArray = new Integer[n];
            System.arraycopy(nextIncluded, 0, nextArray, 0, nextIncluded.length);
            System.arraycopy(nextExcluded, 0, nextArray, nextIncluded.length, nextExcluded.length);
//            System.out.println(Arrays.toString(nextArray));
            result.add(nextArray);
        }

        List<List<Integer>> resultList = new ArrayList<>();

        result.stream().forEach(game -> resultList.add(Arrays.asList(game)));
        return resultList;

    }

    public static void checkResults(List<List<Integer>> resultList, int n, int m, int k) {
        List<Integer> playedGameList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int gamesPlayed = 0;
            for (List<Integer> game : resultList) {
                if (game.indexOf(i) < m * k) {
                    gamesPlayed++;
                }
            }

//            System.out.println(i+ " played "+gamesPlayed+" games.");
            playedGameList.add(gamesPlayed);
        }

        int max = 0;
        int min = 100;

        for (int x : playedGameList) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }

        int maxDiff = max - min;

        System.out.println(maxDiff);

        if (maxDiff <= 1) {
            System.out.println(resultList);
        }

        if (maxDiff >= 2) {
            return;
        }

        int couplingDiff = 10;
        int countCouplings = 0;

        while (true) {
            resultList.forEach(game -> Collections.shuffle(game));

            int[][] couplings = new int[n][n];

            List<List<List<Integer>>> allLists = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                int index = i;
                List<List<Integer>> singleGroup = new ArrayList<>();
                resultList.forEach((List<Integer> longlist) -> singleGroup.add(longlist.subList(m * index, m * (index + 1))));
                allLists.add(singleGroup);
            }

            for (List<List<Integer>> singleGroupLists : allLists) {
                for (List<Integer> singleGroup : singleGroupLists) {
                    for (int i = 0; i < singleGroup.size(); i++) {
                        for (int j = 0; j < singleGroup.size(); j++) {
                            if (i != j) {
                                couplings[singleGroup.get(i)][singleGroup.get(j)]++;
                            }
                        }
                    }
                }
            }

            int maxCoupling = 0;
            int minCoupling = 100;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i!=j) {
                        maxCoupling = Math.max(maxCoupling, couplings[i][j]);
                        minCoupling = Math.min(minCoupling, couplings[i][j]);
                    }
                }
            }

//            for (int[] player : couplings) {
//                System.out.println(Arrays.toString(player));
//            }
            couplingDiff = maxCoupling - minCoupling;
            if (couplingDiff <= 4) {
            System.out.println(countCouplings+" Coupling diff: "+couplingDiff);}

            countCouplings++;
        }


    }





    // Fisher-Yates shuffle algorithm for int array
    static void shuffleArray(Integer[] array) {
        int n = array.length;
        Random random = new Random();

        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Swap array[i] with the element at random index j
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

}
