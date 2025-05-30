package 题库;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * 示例：
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 */
public class T3无重复字符的最长子串 {

    public static void main(String[] args) {
//        System.out.println(new T3无重复字符的最长子串().lengthOfLongestSubstring2(" "));
        System.out.println(new T3无重复字符的最长子串().lengthOfLongestSubstring2("asjrgapa"));
    }

    // 暴力法
    public int lengthOfLongestSubstring1(String s) {
        int max = !s.isEmpty() ? 1 : 0;
        Set<Character> puts = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (puts.contains(s.charAt(j))){
                    max = Math.max(max, puts.size());
                    puts.clear();
                    break;
                }
                puts.add(s.charAt(j));
            }
        }
        return max;
    }

    // 滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> puts = new HashSet<>();
        int max = 0,right =  0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i!=0){
                // 每次去除最左侧的字符
                puts.remove(s.charAt(i-1));
            }
            // 添加最右侧的字符，直至出现和窗口中重复的字符
            while (right < n && !puts.contains(s.charAt(right))) {
                puts.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - i);
        }
        return max;
    }
}
