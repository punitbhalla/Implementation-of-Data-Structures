package arrays_and_strings;

public class CheckPalindromeString {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        String str = s.toLowerCase();
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (isValidChar(str.charAt(low)) && isValidChar(str.charAt(high))) {
                if (str.charAt(low) != str.charAt(high)) {
                    return false;
                }
                low++;
                high--;
            } else if (!isValidChar(str.charAt(low))) {
                low++;
            } else {
                high--;
            }
        }
        return true;
    }

    private static boolean isValidChar(char ch) {
        int num = ch;
        if ((num >= 48 && num <= 57) || (num >= 97 && num <= 122)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String string = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(string));
    }
}
