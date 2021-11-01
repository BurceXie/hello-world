package bw64;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 5899. 两个最好的不重叠活动(2)
 * https://leetcode-cn.com/contest/biweekly-contest-64/problems/two-best-non-overlapping-events/
 */
public class N5899 {

	public static void main(String[] args) {
		Solution s = new N5899().new Solution();
		
		System.out.println(s.maxTwoEvents(new int[][] {{10118,21160,2235},{62243,65839,5392},{42815,79102,8861},{74417,80519,9621},{27941,58771,3648},{54765,67382,198},{13982,29247,5671},{39937,88624,9291},{68318,90039,2749},{69340,95878,7665},{89616,90907,5370},{64181,69458,8464},{92587,93895,3678},{78316,82181,1848},{35022,71208,1874},{62798,89205,7075},{15914,55884,4605},{44134,92640,6704},{96557,96834,2082},{91978,97816,1497},{73770,99986,881},{62800,80401,2471},{10932,78641,3986},{17858,33506,7892},{46756,56196,2781},{30000,42042,9662},{85009,98654,125},{4128,56128,8210},{56326,73799,3659},{93514,97163,6561},{32143,65722,7499},{53275,63036,1617},{87785,93788,2417},{32501,80711,6198},{79076,95641,5159},{49273,97962,3014},{21643,59128,9873},{49185,56166,9425},{37007,61424,5102},{62476,97779,3510},{73649,91310,9201},{68021,99927,5180},{12107,63323,5268},{57893,89637,5717},{4590,25194,9755},{76584,81649,7448},{50698,87297,9363},{68637,81215,24},{26668,84171,8842},{16559,90426,8255},{78907,86735,1844},{70871,75516,356},{5958,62733,4079},{6324,77666,5196},{56944,83461,6200},{58991,66806,4334},{86039,86536,9549},{92186,93252,7718},{80651,87555,604},{1607,84294,9303},{32848,94139,730},{41858,81609,5013},{36029,92648,5597},{8010,81036,5902},{44447,97752,262},{21194,72931,1908},{34658,75395,7409},{64672,89144,8951},{67054,93159,3403},{63332,75681,6661},{38496,73547,8028},{11582,42913,926},{69818,92696,9391},{13096,72396,3711},{63407,95739,3915},{61622,88102,5084},{63082,81660,7041},{10302,91007,5485},{73800,83475,1060},{5217,78071,9992},{30557,47355,7054},{58131,97306,7782},{34523,74869,4915},{44139,53092,6618},{51370,55421,7851},{95559,97226,8138},{61548,80292,3410},{3075,92342,2445},{45272,88047,6962},{91148,99045,6586},{30103,81549,5320},{7295,21945,2060},{98071,98954,6197},{88951,89845,7988},{65978,81432,8657},{33206,85620,2661},{47802,96965,822},{49758,58518,3145},{43867,48372,2742},{41926,95258,7217},{45036,54960,5108},{45504,54716,6093},{72773,90342,2444},{90232,99897,2321},{79016,98389,4328},{85220,97467,4877},{27202,50404,9953},{20432,71907,8522},{68069,84449,5136},{58593,95508,3148},{60927,61864,1473},{15508,49549,1406},{8846,53559,4253},{14030,65641,7243},{18535,25224,8001},{62698,78594,6767},{58966,76661,5708},{90267,90543,3228},{23948,77807,2976},{65499,66633,5627},{65168,73025,5974},{72268,84956,3743},{77683,81963,3014},{56761,85568,2974},{69665,99858,2809},{86539,89078,7461},{78936,91203,3856},{37678,56250,8639},{46747,50142,1059},{1274,6757,6370},{31266,97888,3366},{44389,52512,3732},{37952,38358,3292},{29237,72858,8296},{48868,90719,6918},{11758,76938,1209},{47319,66700,1986},{52373,99113,562},{16416,92414,1695},{26285,45057,1192},{10090,19623,329},{93202,99346,9556},{63829,82391,512},{10061,39874,9531},{81571,94076,4214},{96883,97837,9838},{99568,99750,7904},{30075,46454,5989},{2323,19251,7917},{55673,78959,2365},{30534,57416,9678},{78483,81896,9314},{89107,96730,2766},{8859,51235,5850},{71175,73135,9938},{17315,86050,2979},{31547,54078,5692},{47440,67115,6111},{69137,73815,135},{79517,82649,3747},{25739,75458,9275},{91609,98552,7594},{94384,94685,9204},{5378,15505,2940},{91898,98931,8548},{78805,99475,3105},{21897,42545,9898},{17963,33669,6630},{22269,34028,8775},{51201,59939,508},{81008,81550,3709},{11142,65825,695},{50419,93706,7736},{59480,93893,4479},{22193,52168,6833},{42923,85189,6792},{57658,59750,7488},{30644,99716,637},{57960,80163,8912},{42451,52650,8974},{98173,98652,321},{16814,86530,3720},{84991,87150,3395},{48201,59774,1984},{21672,39218,5741},{45463,64103,9369},{99781,99992,3715},{15374,47098,8182},{94004,95480,2956},{83332,88146,5413},{26239,76961,5012},{64399,96854,6908},{74512,86891,7055},{67353,88954,5968},{16828,50659,9383},{33255,74688,4603},{52994,77554,5385},{7411,10435,7536},{89034,92294,4747},{17965,92020,748},{26336,91254,5868},{92407,99237,8265},{62991,90887,2323},{25768,49707,9504},{83300,85657,1544},{11791,71955,8609},{63506,86478,2467},{8394,12821,1713},{76840,86606,1907},{19491,83471,471},{95626,97077,4496},{65308,75818,6150},{22430,93258,6641},{6065,42625,6929},{16028,27956,6993},{73205,87534,3061},{25046,79854,7187},{85972,97807,7467},{34387,57902,2619},{73977,78806,3754},{97760,98111,361},{68479,70520,1382},{61121,94700,2483},{52495,60439,6189},{8202,47209,6390},{49416,92526,2504},{8669,72446,8669},{83969,93898,6581},{80583,94960,571},{17791,62382,807},{20086,64053,3907},{19261,65302,6259},{14666,48609,8256},{42595,60737,1091},{66392,91501,8640},{63296,83614,764},{25236,73351,5932},{75683,84395,9560},{99979,99981,4264},{94390,95322,4233},{43273,80140,557},{72391,91506,9265},{70027,93839,3866},{54913,63908,9325},{16980,42920,6430},{90884,96544,1357},{65338,93456,3426},{31145,75848,6913},{78076,92814,8818},{30522,39560,269},{5893,27632,7301},{80000,88507,6090},{18259,49989,1411},{39281,78239,4493},{96664,97178,5647},{39297,60410,1127},{32628,77341,5245},{99785,99874,8170},{68187,80287,3567},{27168,34383,9980},{46275,53086,37},{63172,68303,5883},{48379,59197,1760},{73888,88251,9018},{85771,86508,8092},{46440,60719,3280},{22481,29823,5527},{67902,70321,2471},{31234,94121,7866},{87365,98066,7208},{81129,99046,4195},{66534,84269,1013},{20359,47705,9020},{53246,92180,2252},{91420,96099,6151},{23182,72717,353},{96639,99487,6447},{77554,79924,5984},{6095,45084,6605},{21614,61527,6143},{16174,58585,8844},{6309,52947,209},{1077,36647,5069},{37217,61655,3524},{25248,38600,4337},{26430,52903,7820},{61174,72518,7901},{81920,93353,8838},{44454,78786,6722},{36565,46507,3227},{80195,80675,2620},{1142,48269,4982},{87110,94039,4951},{77542,91980,7906},{92068,97895,2468},{7019,91972,7178},{71171,79618,1672},{5757,71205,6972},{3520,95145,8536},{81318,86465,5565},{33589,75244,3747},{10250,61857,6549},{43714,98132,5479},{51210,57083,2478},{96667,99956,2123},{32597,56803,6001},{58593,95498,303},{48079,50674,2208},{45019,54964,7786},{84920,99546,6648},{90648,91311,8715},{86532,92352,2659},{56766,59075,3273},{73377,92306,8553},{14772,82723,2505},{27735,39365,522},{43836,52998,4241},{43751,86756,5552},{56384,67198,5769},{12444,34089,3180},{94967,96000,7628},{30423,46454,5927},{51987,85040,5515},{7522,51826,2241},{69318,87404,8146},{13014,74465,5161},{48333,85617,2377},{86727,92484,2669},{84218,94081,6849},{19098,28995,8677},{72253,92320,5572},{13813,81498,2500},{95139,98375,6496},{41427,55642,2379},{80795,94659,5513},{2442,43831,6682},{68426,95074,8995},{7507,68621,3927},{9439,24082,7134},{51850,56232,7106},{65956,74498,2907},{11522,67009,4024},{82545,88247,2008},{77629,83032,1275},{39969,58620,6750},{62125,72826,9842},{36641,96471,4568},{61123,68885,8719},{45015,74284,4003},{55534,69783,9052},{56913,92645,8151},{7410,91827,2809},{96406,98765,1916},{26267,85203,4418},{12896,89764,5468},{82316,93882,1331},{23531,91161,4099},{92880,97184,3464},{22709,78992,4227},{37417,79973,7579},{26521,96329,669},{3932,41880,1324},{31140,85920,9695},{75332,88212,3475},{94372,99848,9453},{42682,70913,9579},{59708,82071,892},{14760,92618,3302},{75867,79673,4151},{15539,33770,8519},{96175,97570,3586},{82265,97829,2283},{61796,82125,3556},{16938,49258,273},{84021,99839,3713},{97896,98981,1375},{73842,91914,1067},{23268,87921,8831},{92166,93376,3796},{13080,89402,3620},{49271,55297,24},{64903,89358,3364},{73416,91447,2972},{46822,90310,4600},{40331,40788,2},{27318,79880,3591},{82350,83593,2770},{54455,90196,8086},{22137,88681,9300},{71265,73589,5456},{77365,99950,5615},{7168,44558,6271},{67535,82798,8131},{13028,22478,1240},{75361,78114,7651},{1980,7313,1934},{1608,94411,2181},{82863,91533,6926},{19802,28587,8662},{4378,13919,2782},{50109,86182,9592},{55840,64653,6291},{15997,64646,893},{35882,83091,1291},{24766,67523,4874},{74788,92287,5850},{895,15198,4504},{74200,97793,4213},{88292,96645,557},{48009,76359,6128},{31060,77626,4477},{7733,47252,9236},{45858,65443,5297},{59718,81941,2725},{70619,99456,8504},{85569,86372,8376},{12138,86397,6151},{38487,88130,7113},{91414,98501,5168},{52388,58321,5218},{42945,77970,3626},{78539,95815,5377},{95687,96467,9877},{82489,98660,3015},{59841,76613,1245},{58929,90409,5865},{53058,76296,8834},{84127,97193,3363},{12507,29431,7592},{91832,97955,9870},{46773,55447,8203},{30707,37357,4808},{86489,98418,5968},{8273,21156,2793},{97238,99582,9762},{98118,99185,4063},{92844,93677,5865},{88704,92660,1854},{25157,26676,1622},{1316,57460,3342},{95828,96999,5814},{58907,67355,3765},{60141,61574,8301},{71534,82933,7290},{44730,53323,3527},{76710,78638,1805},{7482,73616,830},{8313,49105,745},{80616,81775,7100},{32439,46517,3377},{18398,90103,137},{84999,93681,2940},{10387,26291,4421},{46365,54349,1608},{53436,71954,7228},{5139,84500,9633},{46456,94638,2395},{44264,68737,1676},{26978,98424,6803},{33832,45038,3517},{19411,68195,2969},{37567,49818,2298},{17683,22607,4632},{17399,19066,6893},{42316,45146,3702},{39876,63063,4953},{88111,90492,5806},{49255,93323,2736},{33010,34280,4272},{38711,69034,9491},{62893,76277,6230},{67985,94785,4768},{64716,80783,2530},{11868,31333,4648},{25012,61320,3931},{72272,91883,5612},{39127,91906,1668},{23822,96714,5004},{4556,96233,4304},{33294,68938,3911},{56221,64644,3987},{24358,77810,1310},{67027,80670,5224},{12226,31935,4886},{53585,96314,8858},{51453,94699,1651},{6320,56843,3041},{39281,85123,9006},{28736,51836,9832},{7715,54448,9999},{51300,65227,4262},{69883,92957,7556},{15363,84459,2980},{81419,97151,6323},{35939,94787,7576},{26579,68197,9540},{4745,65370,1830},{1499,68493,4125},{16553,50750,5983},{74624,97825,5109},{34304,44891,8913},{67928,71614,7527},{2533,10940,5236},{83913,84737,7244},{10230,89031,7647},{29265,90249,4829},{71749,73886,7062},{25995,38156,2673},{2666,32220,2034},{75804,86184,4700},{79153,97058,2221},{23766,57357,218},{10628,86375,7259},{82466,96521,1445},{96666,98492,5538},{56833,84068,2185},{51348,82027,147},{83836,90279,2883},{42019,71824,6365},{86265,98068,4878},{95667,95854,8965},{55822,71124,675},{22885,61325,3183},{69017,80299,8753},{7055,64841,3418},{51063,90156,55},{80656,84454,8451},{32783,72931,6675},{3643,82655,7893},{88728,96227,2915},{13372,94892,2970},{61957,94087,2008},{13084,96226,2282},{86853,94414,96},{92845,99938,5887},{34453,66148,3496},{55514,58576,3831},{74723,86884,6978},{40246,59996,3099},{42546,90258,1336},{26059,71844,5037},{27904,97181,7247},{73191,81782,9984},{96800,96988,4729},{7848,49335,8258},{70101,73623,6027},{17848,68841,2754},{70324,89895,9741},{28016,92992,7223},{53696,93037,2487},{17434,96352,8417},{80454,81245,454},{32139,91001,163},{10692,77466,228},{33968,57903,7060},{98986,99650,1851},{73469,75886,4487},{97757,99548,9703},{4625,35861,6976},{49070,71478,7952},{65225,97399,4181},{7418,58556,2700},{72327,83252,4960},{11893,55441,8125},{88184,98467,9861},{9400,20127,2245},{55521,97988,1740},{41979,59258,7470},{44669,50257,9759},{80021,92644,5829}}));
	}

class Solution {
    public int maxTwoEvents(int[][] events) {
		long start = System.currentTimeMillis();
    	int maxValue = 0;
    	System.out.println(events.length);
    	
    	int badCount = 0;
    	for (int i = 0; i < events.length; i++) {
    		boolean isBad = false;
    		if (events[i][2] > maxValue) {
    			maxValue = events[i][2];
			}
    		for (int j = i + 1; j < events.length; j++) {
    			if (events[j][2] == 0) {
    				continue;
    			}
    			if (events[i][2] <= events[j][2] && events[i][0] <= events[j][0] && events[i][1] >= events[j][1]) {
					badCount++;
					isBad = true;
					break;
    			}
    		}
    		if (isBad) {
    			events[i][2] = 0;
    		}
    	}
		System.out.println(System.currentTimeMillis() - start);

		int[][] goodEvents = new int[events.length - badCount][];
		for (int i = 0, j = 0; i < events.length; i++) {
			if (events[i][2] > 0) {
				goodEvents[j++] = events[i];
			}
		}
    	System.out.println(events.length + "\t" + badCount + "\t" + goodEvents.length);
		System.out.println(System.currentTimeMillis() - start);
    	
    	for (int i = 0; i < goodEvents.length; i++) {
    		for (int j = i + 1; j < goodEvents.length; j++) {
    			if (goodEvents[i][2] + goodEvents[j][2] <= maxValue) {
    				continue;
    			}
    			if ((goodEvents[i][0] <= goodEvents[j][1] && goodEvents[i][1] >= goodEvents[j][0]) ||
    					(goodEvents[j][0] <= goodEvents[i][1] && goodEvents[j][1] >= goodEvents[i][0])) {
    				continue;
    			}
    			int value = goodEvents[i][2] + goodEvents[j][2];
    			if (value > maxValue) {
    				maxValue = value;
    			}
    		}
    	}
		System.out.println(System.currentTimeMillis() - start);
    	
    	return maxValue;
    }
    
    public int maxTwoEvents2(int[][] events) {
		long start = System.currentTimeMillis();
    	int maxValue = 0;
    	System.out.println(events.length);
    	
    	Set<Integer> badSet = new HashSet<>();
    	for (int i = 0; i < events.length; i++) {
    		boolean isBad = false;
    		if (events[i][2] > maxValue) {
    			maxValue = events[i][2];
			} 
    		for (int j = i + 1; j < events.length; j++) {
    			if (badSet.contains(Integer.valueOf(j))) {
    				continue;
    			}
    			if (events[i][2] <= events[j][2] && events[i][0] <= events[j][0] && events[i][1] >= events[j][1]) {
					isBad = true;
					break;
    			}
    		}
    		if (isBad) {
				badSet.add(i);
    			break;
    		}
    	}
    	System.out.println(events.length + "\t" + badSet.size() + "\t" + (events.length - badSet.size()));
		System.out.println(System.currentTimeMillis() - start);

		int[][] goodEvents = new int[events.length - badSet.size()][];
		for (int i = 0, j = 0; i < events.length; i++) {
			if (!badSet.contains(Integer.valueOf(i))) {
				goodEvents[j++] = events[i];
			}
		}
		System.out.println(System.currentTimeMillis() - start);
    	
    	for (int i = 0; i < goodEvents.length; i++) {
    		for (int j = i + 1; j < goodEvents.length; j++) {
    			if (goodEvents[i][2] + goodEvents[j][2] <= maxValue) {
    				continue;
    			}
    			if ((goodEvents[i][0] <= goodEvents[j][1] && goodEvents[i][1] >= goodEvents[j][0]) ||
    					(goodEvents[j][0] <= goodEvents[i][1] && goodEvents[j][1] >= goodEvents[i][0])) {
    				continue;
    			}
    			int value = goodEvents[i][2] + goodEvents[j][2];
    			if (value > maxValue) {
    				maxValue = value;
    			}
    		}
    	}
		System.out.println(System.currentTimeMillis() - start);
    	
    	return maxValue;
    }
}
}

