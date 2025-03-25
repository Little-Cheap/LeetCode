import java.util.Arrays;

public class Code205 {
    public static void main(String[] args) {
        String nums1 = "abcdefghijklmnopqrstuvwxyzva";
        String nums2 = "abcdefghijklmnopqrstuvwxyzck";
        ;
        System.out.println(new Code205().isIsomorphic(nums1, nums2));
        ;
//        System.out.println(nums1.indexOf("i"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int sL = s.length();
        int tL = t.length();
        int[] s1 = new int[sL];
        int[] s2 =  new int[tL];

        for (int i = 0; i <sL; i++) {
            char c = s.charAt(i);
            s1[i] = s.indexOf(c);

            char d = t.charAt(i);
            s2[i] = t.indexOf(d);
        }
        return Arrays.equals(s1,s2);
    }
}
