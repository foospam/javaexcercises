package combinations;

import java.util.*;
import java.util.regex.Pattern;

public class Simulation3 {


    public static void pairing(int n, int m, int k) {
        int[][] couplings = new int[n][n];

        int minCouplings = 0;

        while (true) {

            List<Integer> buffer = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (couplings[i][j] == minCouplings) {
                        if (buffer.size() < 3) {
                            if (!buffer.contains(i) && !buffer.contains(j)) {
                                buffer.add(i);
                                buffer.add(j);
                            }
                        }
                        else if (buffer.size() == 3) {
                            if (buffer.contains(i) && !buffer.contains(j)) {
                                buffer.add(j);
                            }
                            if (buffer.contains(j) && !buffer.contains(i)) {
                                buffer.add(i);
                            }
                        }
                    }
                }
            }
        }

    }

    static int sumArrayList(ArrayList<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    static boolean checkCandidate(List<Integer> candidate, int[][] counts, int minCount){
        Collections.sort(candidate);

        for (int i = 0; i < candidate.size()-1; i++) {
            for (int j = i+1; j < candidate.size(); j++) {
                if (counts[i][j] > minCount) {
                    return false;
                };
            }
        }
        return true;
    }


}

class PairingMap {

    HashMap<String, Integer> pairingData = new HashMap<>();
    int groupSize;
    int minSimplePairingValue;
    int minComplexPairingValue;


    PairingMap(int n, int m) {

        groupSize = m;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String key = i + " " + j;
                pairingData.put(key, 0);
            }
        }
    }
}

//    public ArrayList<ArrayList<Integer>> minimalValuePairments() {
//
//        String regex = "(\\d+)\\s+(\\d+)";
//        Pattern pattern = Pattern.compile(regex);
//
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//        for (String key: pairingData.keySet()) {
//            if (pairingData.get(key) <= minSimplePairingValue) {
//
//            }
//        }
//    }
//
//    public boolean checkPairings(List<Integer> pairing, int maxValue) {
//        if len
//    }
//
//}
