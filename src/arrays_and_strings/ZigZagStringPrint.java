package arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class ZigZagStringPrint {
    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }

        boolean toggle = false;
        int currRow = 0;
        for (char ch : s.toCharArray()) {
            list.get(currRow).append(ch);
            if (currRow == 0 || (currRow == numRows - 1)) {
                toggle = !toggle;
            }
            currRow += toggle ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list) {
            result.append(sb.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String string = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(string, numRows));
    }
}
