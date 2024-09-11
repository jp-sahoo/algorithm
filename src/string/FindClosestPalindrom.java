package string;

public class FindClosestPalindrom {
    public static void main(String[] args) {
        System.out.println(new FindClosestPalindrom().nearestPalindromic("111010"));
    }
    public String nearestPalindromic(String n) {
        long nl = Long.parseLong(n);
        int len = n.length();

        //
        // Corner cases
        //

        // <= 10 or equal to 100, 1000, 10000, ...
        if (nl <= 10 || (nl % 10 == 0
                && Long.parseLong(n.substring(1)) == 0)) {
            return "" + (nl - 1);
        }

        // 11 or 101, 1001, 10001, 100001, ...
        if (nl == 11 || (nl % 10 == 1
                && n.charAt(0) == '1'
                && Long.parseLong(n.substring(1, len - 1)) == 0)) {
            return "" + (nl - 2);
        }

        // 99, 999, 9999, 99999, ...
        if (isAllDigitNine(n)) {
            return "" + (nl + 2);
        }

        //
        // Construct the closest palindrome and calculate absolute difference with n
        //
        boolean isEvenDigits = len % 2 == 0;

        String palindromeRootStr
                = (isEvenDigits) ? n.substring(0, len / 2) : n.substring(0, len / 2 + 1);

        int palindromeRoot = Integer.valueOf(palindromeRootStr);
        long equal = toPalindromeDigits("" + palindromeRoot, isEvenDigits);
        long diffEqual = Math.abs(nl - equal);

        long bigger = toPalindromeDigits("" + (palindromeRoot + 1), isEvenDigits);
        long diffBigger = Math.abs(nl - bigger);

        long smaller = toPalindromeDigits("" + (palindromeRoot - 1), isEvenDigits);
        long diffSmaller = Math.abs(nl - smaller);

        //
        // Find the palindrome with minimum absolute differences
        // If tie, return the smaller one
        //
        long closest = (diffBigger < diffSmaller) ? bigger : smaller;
        long minDiff = Math.min(diffBigger, diffSmaller);

        if (diffEqual != 0) { // n is not a palindrome, diffEqual should be considered
            if (diffEqual == minDiff) { // if tie
                closest = Math.min(equal, closest);
            } else if (diffEqual < minDiff){
                closest = equal;
            }
        }

        return "" + closest;
    }

    private long toPalindromeDigits(String num, boolean isEvenDigits) {
        StringBuilder reversedNum = new StringBuilder(num).reverse();
        String palindromeDigits = isEvenDigits
                ? num + reversedNum.toString()
                : num + (reversedNum.deleteCharAt(0)).toString();
        return Long.parseLong(palindromeDigits);
    }

    private boolean isAllDigitNine(String n) {
        for (char ch : n.toCharArray()) {
            if (ch != '9') {
                return false;
            }
        }
        return true;
    }
    public String nearestPalindromicBak(String n) {
        int length = n.length();
        if(length%2 == 0) {
            String first = n.substring(0, (length/2));
            String reverse = new StringBuilder(first).reverse().toString();
            String palim = first + reverse;
            if(Integer.parseInt(palim) < Integer.parseInt(n)) {
                return palim;
            } else {
                String pos1 = first.substring(0, first.length()-1) + (char)(first.charAt(first.length() -1) -1) + "" + (char)(first.charAt(first.length() -1) -1) + reverse.substring(1);
                String pos2 = first.substring(0, first.length()-1) + (char)(first.charAt(first.length() -1) +1) + "" + (char)(first.charAt(first.length() -1) +1) + reverse.substring(1);
                return Integer.parseInt(pos2) - Integer.parseInt(n) > Integer.parseInt(n) - Integer.parseInt(pos1) ? pos1 : pos2;
            }
        } else {
            String first = n.substring(0, length/2);
            String reverse = new StringBuilder(first).reverse().toString();
            String palim = first + n.charAt(length/2) + reverse;
            if(Integer.parseInt(palim) < Integer.parseInt(palim)) {
                return palim;
            } else {
                return first + (n.charAt(length/2) -1) + reverse;//handle 0
            }
        }
    }
}
