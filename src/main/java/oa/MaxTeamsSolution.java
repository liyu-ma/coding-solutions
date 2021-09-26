package oa;

import java.util.Arrays;
import java.util.BitSet;

public class MaxTeamsSolution {

    final static int TEAM_SIZE = 3;

    // 5 1 2 1 4 5
    static int maxTeams(int maxDiff, int[] skills) {
        // sorted: 1 1 2 4 7 8 9
        // greedy:
        // maxDiff = 2

        Arrays.sort(skills);

        int teams = 0;
        int l = 0, r = 0;

        int count = 1;
        for (int i = 0; i < skills.length; i++) {
            if (i == l) continue;
            if (skills[i] - skills[l] <= maxDiff) {
                count++;
                if (count == TEAM_SIZE) { // can form a team
                    teams++;
                    l = i + 1;
                    count = 1;
                }
            } else if (skills[i] - skills[l + 1] <= maxDiff) {
                l++;
            } else {
                l = i;
                count = 1;
            }
        }

        return teams;
    }

    public static void main(String[] args) {
        BitSet bitSet = new BitSet(3);
        bitSet.set(0);
        bitSet.set(1);

        BitSet other = new BitSet(3);
        other.set(0);
        other.set(1);

        bitSet.xor(other);

        System.out.println(bitSet.cardinality());
    }
}
