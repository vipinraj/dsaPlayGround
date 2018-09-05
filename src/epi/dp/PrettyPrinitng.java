package epi.dp;
import java.util.Arrays;

public class PrettyPrinitng {
	public static void main(String[] args) {
		String[] words = {"qziunj", "hpwtqoat", "kozysf", "syvw", "doyxevdw", "zprhkj", "bpqaqtp", "eotiiswbh", "sbhifxyzgq", "rm", "qvnwkol", "kkhrqcgqun", "h", "wjxquf", "oudnfurisg", "qyvth", "ttyjnqeza", "i", "w", "wqgrud", "rmrqcdavgz", "v", "or", "ixalaobw", "od", "q", "raj", "vstdkvaui", "pmyijq", "batigxj", "ghscf", "n", "aqbndjovom", "ubtzg", "y", "uonv", "xt", "tiijbpimwz", "jhqc", "uyk", "v", "teh", "rfwchchzts", "xzh", "qaa", "px", "yxkry", "fhnl", "pzgrymd", "enrqb", "nnsndsmha", "rlpbhenv", "ozkfspkds", "ev", "olm", "evu", "zsrraw", "mza", "llk", "hnhptwqht", "waodjd", "apjhwikfuq", "uevuitezg", "fftwwvjp", "lhd", "nccfst", "c", "gc", "i", "burgifgvf", "t", "vmhvjacn", "uktmnfrv", "pfovcszygy", "j", "zoi", "urcjzgj", "linro", "uivhe", "b", "abdeagumj", "mi", "yeapbzpe", "frtb", "hfajhufv", "yyuikhyvv", "q", "swuwwhwu", "fltoe", "dwgywjhqmc", "rrdce", "nytt", "s", "xrohftjcd", "zdfpalzptv", "ifqmdvgri"};
		int L = 14;
		System.out.println(getMinMessiness(words, L));
	}
	
	public static int getMinMessiness(String[] words, int L) {
		int[] dp = new int[words.length];
		Arrays.fill(dp, -1);
		
		return getMinMessinessHelper(words, words.length - 1, L, dp);
	}
	
	public static int getMinMessinessHelper(String[] words, int pos, int L, int[] dp) {
		if (pos < 0) {
			return 0;
		}
		
		if (dp[pos] == -1) {
			int len = words[pos].length();
			int remain = L - len;
			
			int minMess = Integer.MAX_VALUE;
			int tPos = pos;		
			
			while (remain >= 0 ) {
				int tMinMess = remain * remain + getMinMessinessHelper(words, tPos - 1, L, dp);
				minMess = Math.min(minMess, tMinMess);
				tPos = tPos - 1;
				
				if (tPos < 0) {
					break;
				}
				
				remain = remain - (words[tPos].length() + 1);
			}
			
			dp[pos] = minMess;
		} 
		// System.out.println("Pos : " + pos + ", MinMess: " + dp[pos]);
		return dp[pos];
	}
}