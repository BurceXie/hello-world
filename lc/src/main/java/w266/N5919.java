package w266;

import java.util.HashMap;
import java.util.Map;

/**
 *5919. 所有子字符串中的元音(2)
 *https://leetcode-cn.com/contest/weekly-contest-266/problems/vowels-of-all-substrings/
 */
public class N5919 {

	public static void main(String[] args) {
		Solution s = new N5919().new Solution();

		long start = System.currentTimeMillis();
//		System.out.println(s.countVowels("aba"));
//		System.out.println(s.countVowels("abc"));
//		System.out.println(s.countVowels("ltcd"));
//		System.out.println(s.countVowels("noosabasboosa"));
		System.out.println(s.countVowels2("nsezukxxfizmsyklbnapslntyoxcqringkizyfwrkzlnrnlngpfbrnvjgarsnsnwpcypisjzwdulvywhamnilpsxnikkobaozgptrxsdavgnixjillcvrayliscjizartkfsfdmukxxctslolfezijrysjpqxgatdkhoggxqifewcuctgwviudzjwigbjacreernsoampabfnysygtxzkgkgxopgajgxdzjicwtvacqvrxndlqyzothxkwmhaxljbjrnybgjlllcxwzuzagpamznwtjdwxsyxooamybmcmurafztbapmqvhdbfbutuqqwhphwhpaddikphtztrttpjrffzydanseiueeboywpmifxbbytipxtgmmxpvbsvlwhodqzfqjqgywlgkkpedsypqtcxzncxknwqlbranuizejweoiesutcbteisociddiukjyobxpucmgyayythrpgwalljklfjtigedzgxntxnrmsbkugjtkpuxyxfiyctaucbpkjkjiwcwegqonqivauvchbfeyqqxkzvojphogqrnjnmsxnikjwktoyppoubttoljwvdcgahjbxgdlhcafpomugaivakyazwtqfmrymbijbisoncqthfrftgjqdzrxllnbxajqnwyleloohwidiphhoscagvxmskvfrrnbgjbcjaljcxyuxzgbanlltcqnvbyjdmclqrcjjylshjvvvhhxckipbyglfobhfgldtwdapzjberhcsnphfmdopruonmduyrpyiagufgqdtbiswbfymexqgakdlpaybplicrgczhtbfgxwktxebrpybkrtohaheupiupsshrevvwyrtygnwlogdrwqqzonvifgacejcrdgzhyhqqrpmnptxnqkplnsiyovgmrurlausdbxaabmkpmjvpiambnskgqwztithfimhwchkhfjsrfplcquuudsnwjaqfawrvlolljhvwakxzduhgbebmkenrbwqevdhlfilnkwdcpszesndxolzkuktkscsllyyznpumobduznxahsbxqycbjgsgiwyvtklbsfvdbkxeqfmhtxqhmhrmwbaowjqdjlcvmxhbtmzbyjsrvnmtgjpxgklqwatsptkkasidwnhgrmiikbkecmfornqmavpfrzofbmbrpcoqkfytabmofeunbkfenzdcjsdifogdbdqlmvemysardeqtkzmkorsfyyrwdnwzzbegvvisgyysxcymhwhjuknndaitdmpvunjqyixbvlppxwdthxdaoncgcerwlppbutidftdtkgdzsenesdjygemzcoeodzjmdqbfgklceraliklwxjkmlbhmdipniockgvoapygigckodzqzvnwdwkleizczmzxhymmhinyqhmsdvtovngmyiijcuclgmkjixcclgvgqqzuoqkpfydldnfszyukorxelckvhsxzpjpdkjjhbqjytaboiokyusruatgletshahrojebgtzdarnxysokrziozjzvxquqyoyuooeaqhlnfitrhzkzdfxcdsgghhuulsechzqetuasrzzkyncrmyjoivzlrtjmrhbymrfpjgpryxzaszzlscvijasodwikwfkmoswxozhtwydqxulxjrkehjjxofzkciefrqjnvktnmcdgnggoaxeyzneavaqosdulixypszajupzbcchpblndcaxsftdotxlfspvenbriecngbexicuskjvbeyuxmxavzsuylpigppxqrzghuwsdaqblcvwosyvjfpeemuuzpcjqfzkwrjuzjopztgfateppxlptvonnhunlorgnleagjhrdktrrhdzvdxuhestapdnhcmjblqfwupdoryqksniagolbohjbhxwbomiqlneovwacvtfuhammbbcbriqtqfliemykgxgwulqdnscnagurwkpxgpzrushqzdqxehcykambiquakuobglljxailhawagtuztcocrdgafdnnvyqwfvpzdttibnsircuyhzscmazdpnrxqiihyseckuuscfqdestyxyjificmkuipnesvzceldbkonnrkxafukfitojfonkrvwkcyqsgbsfdrfgndtkrtthccaowdgjfhwqzfpgoezvoclafmkimldrbzmmpfyhayeihenlgnolenjtobuochionknyqtkjprramkiecykygceyabjyzbqiyjrwhcixaxjwzdhqiutgghareewnvuqahitbclbsqxnpskfmdnbtndkuzjhzwczojfrjzdapvgbaajksavywbefdnfhzezttuarnolgwnngenowfgfunrktkzokkikfanmzxdjitzmcdwzsouvxbwasinwcyjfjazhnsjrqomjrvsssjjfiuvylylyxrhapitoqqfxnvpjbbutpalkpjmazapijoqygducnnpvijlraangsonwfbsecwxsnjwabpbhdallslnrrgbkeugbsesifbqcsezibxzcplikejmdxnqwahoixkxyrgdwldvrsdtcfnxqjmrcpmqglwyzgovrjdbnjfwnfgcwibttwchttpnnffgfktjbasoovtdyyrvqojlktcythiiknfkujdpdviebdkvpyvrgjplnykmwyoawspdcyhsxnimsufmdkpqyftzongmrqqbhmpviudpgcnarksiinurujqtilhzfairthkknkthkjdoalcdyogdhjuceyrnwweftwjonduknxvlzfsqgixnshgsvfhsxkmfgqhioiurtpyqnyndrghsxyfpyipsocwchxokkmdjhefzrdajgfozvekaqffyavhtmaefyurozcbnewxtodncsxnxqsbmhcmczussaoufvihsqqymxmndefgmzkqvdxckmfiwuqxlukdwawwnqmwiystjwudifeobnkoknjufejicwrnsuwjqbkjcmvnitmfqghueoyblmckxlgtyggyenwrpprqxummkrntomyhpjksqwvguqvkqnmflrscvwdpiwtvqiwbvugqdszvzvizyvljfiafzctnydmwlnjibeoedqnbfvwbxgulhuonegotkgsegnrmagkqcgaenhjhdatxschbpqpztjvgguqpbtfgytjdoplodbrhcvomicgehzffjvvacpvturbwjbufjwzmmmyghrfeetkpgfhoakttfcixzkaipcfwcshmqbqbcvdvmlmwjsdxyzeabobrubrymqgqaocdxmgpzatxxjkudecwxaxfakkengowpcdqwtktadhddbuoxymecwlcdghvvvelfqawzkrkiinijnmjckbohbwiwufhigdoexxxjjnnuqxqyveybmvmokyantahfqrsjwjfvxiwxepkyylxdreezbqbewpqqppygumxeyiykdjhuwyxpejyvrposbqkjhpujfjhcsddtddsucovlqbetwulnsladlsnmyllsgqunlfdqziqpyefngcczqxcjimgwdrxqfuegzxcnkkdunlbtgwgjodejzucpriucdxmhfrjcvtyoxgqpbzwspdtqpkpwvuqbjiungwofjcejamupervujtnttjzdwlzidbubxlklpisioqkntafxywufdkevtigttzjindfgihbviuqluevhdzcjobungncfrcqvwseyvakmhhsjfzgmkfcbylbjyfjutescycpjrtmqbgcgvrmnminygxjxeavfwqlosnvsgqugtcdqwkcuyuhsissowvqkjrizbylhdtkxszhzbpyabnhtyubcmocxjpwfxaigmwiqonmahndrxpdxjldioxjpoymocrczvxqbquwbvhtvzlpmydbkbnbwrsysbfeyfqtfbujhixcvqohzewstvbhqxcxfsmwyrlcvvajqdghvabnvtkzeiujwsmvjrihwytmefpqvffgyyhitgewkjgapripytxjnlwgockjxrmsidxovkrzsmtonidhealqgsnfbnyxekpushoinxdubasulmoajeginofnicxeoeifnkoobfduakmwtslgqdmdykknmtemrthydkbklmlkqaecivitbtloclydspwkvwceftlswytmoaicrmyjovfizklwsndnchcltcocxmxyjcbgscrxvnimriekfljbeuerjhihlladoggxzjjqhbmaeyjnrhfyptdrlmrfafumjylvbgystphsaczikvrbvcehzglopkwqmljuqyhpcjioekehhrkdtewwkhdlewpckffkjqgwvojfaukqsuewjtpqlevscephujbtjgiwfwvrsavhakorbqdsxknayodflaoufhpulhdzcvmuzaipoljhnfdboqxercxagcigtyvpdchcyxjteorlvmawrzwdxhuxfdplhvqxbjjrzlgfljhgvqnltyyrohligqqlnqzzkpiypjhqlbbhvmdaknrgvrvxptriqxkfugggifkhgqmuppkegatyaukdfcqilxgnhybipmhtumqgcmvbopblzkphncpxnkcjzkqrghnsichaqmzyivqfmjxbbexrjvxjcdutrpjcbefpchctgndhltpslvdbawjvyayajnccwqawuqhdnlqdavtxycejucskyqpxifvcoahvmbiqbiluvstrvlqzdyvbprqchqsejmvwszljroahuqlsngecakouztvraowdxxinfycvybirfojqsdcedgfsotduipfzcotnetfiuzrponrlxsrjzsijxttxqegbeufqkfyqngamrllixqtgxxwdzwvqvfyohlajzymghjkinigfdvhvncjviufwlkjbkmmingfvtwsuizlfihawbbrzsimpputsuccppbhzhfddunpcmwsrcfobabjvqxytvswqowofjattomvumortqceyqltrtvnoibhusymyddxkdjowbgdiupotqktyxwmzaungijrncjxlsztkgfrotyljmuofdossrztzprvzwntocfkbmllrdpmnmbakqxowkgsimceapeqlslrwvkkbrdikfzisnxuwsjecqjrwqmhezratdnwnwagcmckhpqvlqqtpteqqqpthjyiwsirirovjeubjgmvnmkzyekjsdxngdngpnzygtksmxfrivisnptcbdffiwynummdlpvvwiunpjlncisysbllkzgsjhtiihmsyrhcxmgxmbagamfpnbmcaudzwaoekyvbrsrxgrafqyorsmdhpujmusqcfmvafzvwmsmpjzirgvtpzxjiqcspbgzftyaigbgdnhcavxvhpnzfmsbxvcgpsbqfkessbrxbugmwfxmutbbuhclyoyomjusqenxthhhucbnibaozsfbotwuggvawnvienrdbuzusmrengwbytisgcgmyqgqpbjkkqhxtpyzsqthedrekqvytbnbfumagbinsjcqcglikbkztayzqpsypdsmmxgltrlarlckdcrkwxloavcqowkxhvsugevagrkjofjvbrkzqbuxealkfprijzfkazplvrkzhhzhkkmbiloajpxvtpfhpqzszphmfmkqaunpihwvacqvhmqfuoukpxugblambuebrrqjfrmzckijyokpjvvomsjisijjcxixichdrusmdouoshlyjhimdizsgmepvdbqyomumyotabkinpseisnyksgfkoypmkekpevbdgfrrzseejcdotcmwyivfbhizotsbhzsbricnwhovdbjjkhzabeagatcikzdaszlcjtqneppuvsdfnzcvstbrzxhsjpkslovkhgcwxdpdzbztxbqtwhjqqnmbqcmuwiwbtlnsjvvccsootvteiauejvxsmtkfawsmqounjrvimhtmzkhgmfsokdsdwlknweulxzpmnbicmvzwxyfkprlngldmeynmegvroysjelxlqshqibhxmrmdkgvealqgwlvuryuzeghghyjwsgrfjmemduzbnmgoturzjdfrjrzxgeqymkuskdjhzymxhbfnbpsnoomrifittejmwtgvyrbwjkywtokfmnkigiskwaeybtctysfgjxaauailphzbzawoborceztbvicswsukjrjwdnzyigxhtdmqpdidhftsjogftnpzfnfpjfpluutsnucrzqeewbjinbxqisuhtxxlxbssbwfvzwfvvbkhlaisoonyeffsjaubksaxvmwfwhnvgloqlcjrqujkaflhjtqkrhmgftqqivtxmbmloxbgyyjqnyohdockbaajyetjyvnsnbuuntfzrfradjjdazdybvupovjtbsoegwwxopohzhiyjwmacjsnbxkohrtaspadpjcguxouucdztefirwpjommteizibejifpsecddjtvsdiufldowiceajdgkfxwxckshwdfgmvjbdidezjkzswpjaqhabwuhbspykbqqrlcsnigxppyjgammuxvhrpzbgtmdmxdbbtldhmhgfnppudwibhorhrijzynfjlntfyekatvvvzkspmxbzuznjklypgrroksbtxmzrwvlguxjncodploerwpvtxkxymqljopsyxfolqzrujfwngfameyywhfwmnaljquoiijrrkmjnibkzhjyjmowizununoizzywbfkyftvuwxqtvolhccnaxfjyskxigcpjsfmhaskrklvhmseubroaybbdfhjwhzlmgbptwpdhwgpgjdqoswqzzykhimsqrkjrxuqfqbkyajlgwssnxrefquupsmxquzzjtiiemahzajbbqralnmtpfjmeqlkdmqhxlrpkhellihilpahlhrawmbzytetppydayrorjdzixguigspsullvqdrsruhapvdniqrjflzxeqvknekpszhifbylltyfdoupvzgnxumxxgzgnplbgpzcofvmpzrnumbyoweonxdowdyyednatwpwqnkjswrucfwntboaldlvmcnunvwszjxwgisilgfvjwwqgsqspqxlcbxecmtdytzmijtvqdybdtlukbfwgqpldaqkrbzkscjuidkgoxopioxlzrjqxrvnmchzqetvwczycljrisqaiuxzhkrwxqzetyvwefwvmfjaqtgsniedciamfxalbynpvodmyvckcyqycmqgnmbgfdkneiwxwudnlkzcdbprhpkrckvkxwfmymstprilkvdiuxlbtvhbsbzrpmseeeujrkvwvagiifdrkzlaysxveikwysdmdtkrjqfqxjfctbbflgotduhjftzkehypatwlwtwfmoxfldsvjxegxsunihagfuhygijlzbxpviljmwdtwdshjjwvhscdnnvdgcmlismwhmlqnyhqvbhpcupgztlxwvqxuafxfmjatsbeeytjkflwvwxsnnddzzclgltnloewenyqgurcwywkzyxcbrseatcfwxdaaanflbkxpbstqjtuvskegwcbydhvnagafdbgpksjwjqmigupddgppykwzhvfmcqearhakgubwlxofoltqdpmoftzvhjajwosbmyeruaalubiuymrgfccewwssejrkivxdneizgtjdnngqhnulgpdkmnmgdqojihxlmudkzfmtawrxcyvcsruxqhgfoggucotispysmovjvwuehvmfvkvibfwfeurpxlipkkadyqrjhecujhesbxyvwzidwizrigyxzibifovlpkypaapmtjfdnlszaevnofakztggsmejiszdlebnyiuerikoghtfclorhwjqubohfimwggucignvqgqkbfmovlwypmbptozsrewkweowbwdtgoefpputijbsytizhfviohygookicugaofzcynmpnhhrhwpxyhrdiqfymzfwabqxuqvtnovdpjrrfyrxslvwvltmzkahywccagfznvctqvtjydjetyscatgbczlhhicksqzvfgdjfvbwctbffioezuvmdsyyhjkqfsppsxnpviizpxgeuwqyxqmzuxjjwmnqduarvurrplorxgwytrhqqhcsqlkmljjvnicmpuuahoygtgvofslelwctcpgzznnpojvtpodqkuaqdfbhnozeetrvbgtjhdlwnnxovzblojiuroqrmddhsdmubpxsrluzeiniwmjepsdyukgqnfrbafsdviwshceqwcnznrhjqgbejlobrfvykvbuahjjatguzybreejxbqttiyamexqueuclxamhrkpdknxtattbamkmxcnxxynttqiwjqbqlylryfapfpcqikmmajajyihzyjenyxkixwutlfietkfppntcbihfdushuiyusqcgwezproawghyoohyjvxkjipiepoqmuwszjsltgjkctsvsyqsznmtyffisgbqhkasmcqqtnoxwubyjtrgvehidkozfeiriwpnrtxgvyjnegpzywahnnftynhgmcnamsuebgebcuoalnpcnhptehopecwulhrxlzdxvgbpkdesvvdgyntkcvqgehwumxfrphndjitiokbtxznbvgwqvkpxjqkjimvpwduobamyxpendsqhtqgsqkphmypgyioiageuuhvqdaysnliljbtcqostpismsnzlvnpcaf"));
		System.out.println(System.currentTimeMillis() - start);
	}

class Solution {
	public long countVowels(String word) {
		String newWord = word.replaceAll("[eiou]{1}", "a");
		System.out.println(newWord);
		newWord = newWord.replaceAll("[^a]{1}", "b");
		System.out.println(newWord);
		if (newWord.indexOf('a') < 0) {
			return 0L;
		}

		long count = 0;
		Map<String, Integer> countMap = new HashMap<>();
		long nano = System.nanoTime();
		for (int i = 0; i < newWord.length(); i++) {
			for (int j = i + 1; j <= newWord.length(); j++) {
				String subStr = newWord.substring(i, j);
				Integer subCount = countMap.get(subStr);
				if (subCount != null) {
					count += subCount;
				} else {
					String replaceStr = subStr.replace("b", "");
					if (replaceStr.length() > 0) {
//						System.out.println(subStr + "\t" + replaceStr);
						count += replaceStr.length();
						countMap.put(subStr, replaceStr.length());
					} else {
						countMap.put(subStr, 0);
					}
				}
			}
			System.out.println(i + "\t" + (System.nanoTime() - nano));
		}

		return count;
	}

	public long countVowels2(String word) {
		long count = 0;
		for (int i = 0; i < word.length(); i++) {
			if ("aeiou".indexOf(word.charAt(i)) >= 0) {
				count += (i + 1L) * (word.length() - i);
			}
		}
		return count;
	}
}
}
