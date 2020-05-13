public class Main {

//    public static void main(String[] args) {
//        String s1 = "abc";
//        String s2 = "abc";
//        System.out.println(s1 == s2); // true
//    }

//    public static void main(String[] args) {
//        String s1 = new String("abc");
//        String s2 = new String("abc");
//        System.out.println(s1 == s2); //false
//    }
//
//    public static void main(String[] args) {
//        String s1 = "abc";
//        String s2 = "a";
//        String s3 = "bc";
//        String s4 = s2 + s3;
//        System.out.println(s1 == s4); //false
//    }
//
//    public static void main(String[] args) {
//        String str1 = "abc";
//        String str2 = new String("abc");
//        String str3 = str2.intern();
//        System.out.println(str1 == str2);//false
//        System.out.println(str1 == str3);//true
//    }

//    public static void main(String[] args) {
//
//        String abc = "abc";
//        final String abcFinal = "abc";
//
//        String str1 = "abc01";
//        String str2 = "abc" + "01";
//        String str3 = abc + "01";
//        String str4 = abcFinal + "01";
//        String str5 = new String("abc01").intern();
//
//        System.out.println(str1 == str2);//true
//        System.out.println(str1 == str3);//false
//        System.out.println(str1 == str4);//true
//        System.out.println(str1 == str5);//true
//    }
//
//    public static void main(String[] args) {
//        String str2 = new String("abc") + new String("01");
//        str2.intern();
//        String str1 = "abc01";
//        System.out.println(str2 == str1);//true
//    }

//    public static void main(String[] args) {
//        String str1 = "abc01";
//        String str2 = new String("abc") + new String("01");
//        str2.intern();
//        System.out.println(str2 == str1);//false
//    }

    public static void main(String[] args) {
        String str1 = "abc01";
        String str2 = new String("abc") + new String("01");
        str2 = str2.intern();
        System.out.println(str2 == str1);//true
    }
}
