package w264;

import java.util.regex.Matcher;
import java.util.stream.Stream;

/**
 * 2047. 句子中的有效单词数(1)
 * https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence/
 */
public class N5906 {

	public static void main(String[] args) {
		Solution s = new N5906().new Solution();
		
//		System.out.println(s.countValidWords("cat and  dog"));
//		System.out.println(s.countValidWords("!this  1-s b8d! -"));
//		System.out.println(s.countValidWords("alice and  bob are playing stone-game10"));
		System.out.println(s.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener. j-ppy"));
//		System.out.println(s.countValidWords(". ! 7hk  al6 l! aon49esj35la k3 7u2tkh  7i9y5  !jyylhppd et v- h!ogsouv 5"));
		System.out.println(s.countValidWords(" 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif "));
		
//		System.out.println("dh-i2dhi".matches(".*[\\-].*[\\-].*"));
//		System.out.println("1-2-3".matches(".*[\\-].*[\\-].*"));
//		System.out.println("wge-".matches(".*[\\-].*[\\-].*"));
		System.out.println("j".matches("([^a-z])"));
	}

class Solution {
	public int countValidWords(String sentence) {
		String[] tokens = sentence.split("[ ]+");

		int result = 0;
		for (String token : tokens) {
			if ("".equals(token)) {
				continue;
			}
			if (token.matches(".*[0-9].*")) {
				continue;
			}
			if (token.matches(".*[\\-].*[\\-].*|.*[^a-z][\\-].*|.*[\\-][^a-z].*|[\\-].*|.*[\\-]")) {
				continue;
			}
			if (token.matches(".*[\\.,\\!].*[\\.,\\!].*|.*[\\.,\\!].+")) {
				continue;
			}
			result++;
		}

		return result;
	}
}
}

