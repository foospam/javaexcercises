package org.isaacsoriano.unit8;

import java.util.Comparator;

public class ElectronicDeviceComparator implements java.util.Comparator<ElectronicDevice> {

    @Override
    public int compare(ElectronicDevice o1, ElectronicDevice o2) {
        int w1 = o1.getWatt();
        int w2 = o2.getWatt();

        if (w1 < w2) return -1;
        else if (w1 == w2) return 0;
        else return 1;
    }
}
