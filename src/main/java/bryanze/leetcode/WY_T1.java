package bryanze.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lizelin
 * @date 2024/09/11
 */
public class WY_T1 {
    public ArrayList<ArrayList<Long>> diff (ArrayList<Long> leftIds, ArrayList<String> leftValues,
                                            ArrayList<Long> rightIds, ArrayList<String> rightValues) {
        // write code here
        ArrayList<ArrayList<Long>> result = new ArrayList<>();
        ArrayList<Long> modified = new ArrayList<>();
        ArrayList<Long> deleted = new ArrayList<>();
        ArrayList<Long> added = new ArrayList<>();

        Map<Long, String> oldMap= new HashMap<>();
        Map<Long, String> newMap= new HashMap<>();
        int oldIndex = 0;
        for (Long leftId : leftIds) {
            oldMap.put(leftId, leftValues.get(oldIndex));
            oldIndex++;
        }
        int newIndex = 0;
        for (Long rightId : rightIds) {
            newMap.put(rightId, rightValues.get(newIndex));
            newIndex++;
        }

        for (Map.Entry<Long, String> entry : oldMap.entrySet()) {
            long key = entry.getKey();
            String oldValue = entry.getValue();
            if (!newMap.containsKey(key)) {
                deleted.add(key);
            } else {
                String newValue = newMap.get(key);
                if (!oldValue.equals(newValue)) {
                    modified.add(key);
                }
            }
        }

        for (Long id : newMap.keySet()) {
            if (!oldMap.containsKey(id)) {
                added.add(id);
            }
        }

        modified.sort(Long::compare);
        added.sort(Long::compare);
        deleted.sort(Long::compare);
        result.add(added);
        result.add(modified);
        result.add(deleted);

        return result;
    }
}
