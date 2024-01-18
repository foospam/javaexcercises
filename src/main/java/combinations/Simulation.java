package combinations;

import org.assertj.core.api.ComparableAssert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Simulation {

    public static void main(String[] args) {


    }

    public static void getCombinations(PlayerTable players){

    }

}

class PlayerTable {

    List<Player> players = new ArrayList<>();
    int size;
    int[][] table;

    PlayerTable(int size) {
        this.size = size;
        this.table = new int[size][size];
        for (int i = 0; i < this.size; i++) {
            addPlayer();
        }
    }

    void addPlayer() {
        if (players.size() < this.size) {
        players.add(new Player(players.size()));}
    }

}

class Player implements Comparable {
    int id;
    public boolean playedLast = false;
    Set<Player> lastRivals = new HashSet<>();

    Player(int id) {
        this.id = id;
    }


    @Override
    public int compareTo(Object o) {
        if (this.playedLast == false){
            return 1;
        }
        else if (this.playedLast == true && ((Player) o).playedLast == false) {
            return -1;
        }
        else return 0;
    }
}
