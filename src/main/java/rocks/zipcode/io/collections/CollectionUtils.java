package rocks.zipcode.io.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {

    /**
     * @param collection - object to be converted to list
     * @param <E>        - type of collection
     * @return list with identical contents
     */
    public static <E> List<E> toList(Collection collection) {
        List<E> genericList = (List<E>) new ArrayList<>();
        for (Object o : collection){
            genericList.add((E) o);
        }
        return genericList;
    }

    /**
     * @param nestedCollection - collection to be evaluated
     * @param collection       - collections to be sought within `nestedCollection`
     * @return true if `nestedCollection` contains a collection with contents identical to `collection`
     */
    public static Boolean contains(Collection<? extends Collection<?>> nestedCollection, Collection<?> collection) {
        for (Collection c : nestedCollection){
            if (c == collection){
                return true;
            }
        }
        return false;
    }

    /**
     * @param collections - collections to be nested
     * @return a single collection containing each of the collections passed in as an argument
     */
    public static Collection<? extends Collection<?>> nest(Collection<?>... collections) {
        Collection collection = new ArrayList();
        for (Collection c : collections){
            ((ArrayList) collection).add(c);
        }
        return collection;
    }

    /**
     * @param collections - collections to be combined
     * @return a single collection containing the aggregate contents of each collection passed in as an argument
     */
    public static Collection<?> flatten(Collection<?>... collections) {
        Collection collection = new ArrayList();
        for (Collection c : collections){
            for (Object o : c){
                ((ArrayList) collection).add(o);
            }
        }
        return collection;
    }
}
