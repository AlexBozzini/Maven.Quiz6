package rocks.zipcode.io.collections;

import java.util.*;

/**
 * @author leon on 10/01/2019.
 */
public class PowerSet<TypeOfSet> {
    protected final Set<TypeOfSet> originalSet;

    public PowerSet(TypeOfSet[] originalSet) {
        this.originalSet = new HashSet<>(Arrays.asList(originalSet));
    }

    /**
     * @return the powerset of `originalSet`
     */
    public Set<Set<TypeOfSet>> permute() {
        return powerSet(originalSet);
    }

    public Set<Set<TypeOfSet>> powerSet(Set<TypeOfSet> originalSet){
        Set<Set<TypeOfSet>> sets = new HashSet<>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }
        List<TypeOfSet> list = new ArrayList<>(originalSet);
        TypeOfSet head = list.get(0);
        Set<TypeOfSet> rest = new HashSet<>(list.subList(1, list.size()));
        for (Set<TypeOfSet> set : powerSet(rest)){
            Set<TypeOfSet> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    /**
     * @return `originalSet`
     */
    public Set<TypeOfSet> getOriginalSet() {
        return originalSet;
    }
}
