package org.isaacsoriano.unit8;

public class TreasureChest {
    public final int goldDoubloonWeight;
    public final int gemstoneWeight;


    private TreasureChest(int goldDoubloonWeight, int gemstoneWeight){
        this.goldDoubloonWeight = goldDoubloonWeight;
        this.gemstoneWeight = gemstoneWeight;
    }

    public static TreasureChest newInstance(){
        return new TreasureChest(0,0);
    }

    public static TreasureChest newInstanceWithGoldDoubloonWeight(int doubloonWeight){
        return new TreasureChest(doubloonWeight, 0);
    }

    TreasureChest newInstanceWithGemstoneWeight(int gemstoneWeight){
        return new TreasureChest(0, gemstoneWeight);
    }

    TreasureChest newInstanceWithGoldDoubloonAndGemstoneWeight(int doubloonWeight, int gemstoneWeight){
        return new TreasureChest(doubloonWeight, gemstoneWeight);
    }
}
