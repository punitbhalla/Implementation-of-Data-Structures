package arrays_and_strings;

public class AddBinaryNumbers {
    static String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        int num1, num2, sum, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            num1 = (i >= 0) ? a.charAt(i) - '0' : 0;
            num2 = (j >= 0) ? b.charAt(j) - '0' : 0;
            sum = num1 + num2 + carry;
            sb.insert(0, sum % 2);
            carry = sum > 1 ? 1 : 0;
            i--;
            j--;
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "01";
        System.out.println(addBinary(a, b));
    }
}
