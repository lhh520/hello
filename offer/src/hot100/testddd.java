package hot100;

public class testddd {




        public static String addBigNum(String num1, String num2) {
            char[] num1Chars = new StringBuffer(num1).reverse().toString().toCharArray();
            char[] num2Chars = new StringBuffer(num2).reverse().toString().toCharArray();

            int num1Length = num1Chars.length;
            int num2Length = num2Chars.length;

            int maxLength = num1Length;
            if (num2Length > num1Length)
                maxLength = num2Length;
            int[] result = new int[maxLength + 1];

            for (int i = 0; i < result.length; i++) {

                int aint = i < num1Length ? (num1Chars[i] - '0') : 0;
                int bint = i < num2Length ? (num2Chars[i] - '0') : 0;

                result[i] += aint + bint;


                if (result[i] >= 10) {
                    result[i + 1] += result[i] / 10;
                    result[i] %= 10;
                }
            }


            StringBuffer sb = new StringBuffer();

            if (result[result.length-1] == 1)
                sb.append(1);
            for (int i = result.length-2; i >= 0; i--) {
                sb.append(result[i]);
            }
            return sb.toString();
        }

        public static void main(String[] args) {
           //"1000000000000000","2000000000000000"
            String num1 = "1000000000000000";
            String num2 = "2000000000000000";

            String result = addBigNum(num1, num2);
            System.out.println("result: " + result);
        }



}
