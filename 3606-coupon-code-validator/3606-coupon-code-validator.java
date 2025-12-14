import java.util.*;

class Solution {

    private static final List<String> ORDER =
        Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<Pair> valid = new ArrayList<>();
        int n = code.length;

        for (int i = 0; i < n; i++) {
            if (isValid(code[i], businessLine[i], isActive[i])) {
                valid.add(new Pair(businessLine[i], code[i]));
            }
        }

        // Sort by businessLine order, then by code lexicographically
        Collections.sort(valid, (a, b) -> {
            int cmp = Integer.compare(
                ORDER.indexOf(a.business),
                ORDER.indexOf(b.business)
            );
            if (cmp != 0) return cmp;
            return a.code.compareTo(b.code);
        });

        // Extract only codes
        List<String> ans = new ArrayList<>();
        for (Pair p : valid) {
            ans.add(p.code);
        }
        return ans;
    }

    private boolean isValid(String code, String buss, boolean isActive) {
        if (!isActive || code.isEmpty()) return false;

        if (!buss.equals("electronics") &&
            !buss.equals("grocery") &&
            !buss.equals("pharmacy") &&
            !buss.equals("restaurant"))
            return false;

        for (char ch : code.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }
        return true;
    }

    // helper class
    static class Pair {
        String business;
        String code;
        Pair(String b, String c) {
            business = b;
            code = c;
        }
    }
}
