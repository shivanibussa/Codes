import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs.length == 0) return logs; // Handle empty input.

        Arrays.sort(logs, (log1, log2) -> {
            // Split each log into identifier and content.
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            // Determine if logs are digit-logs or letter-logs.
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            // Both logs are letter logs: sort by content, then by identifier.
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]); // Compare contents.
                if (cmp != 0) return cmp;                // If contents differ, return comparison result.
                return split1[0].compareTo(split2[0]);   // If contents are the same, compare identifiers.
            }

            // If one is a digit log, the other is a letter log: letter logs come first.
            if (isDigit1 && !isDigit2) return 1;  // Digit log comes after letter log.
            if (!isDigit1 && isDigit2) return -1; // Letter log comes before digit log.

            // Both are digit logs: maintain original order.
            return 0;
        });

        return logs; // Return the sorted array.
    }
}
