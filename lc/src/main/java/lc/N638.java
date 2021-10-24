package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class N638 {

	public static void main(String[] args) {
		Solution s = new N638().new Solution();
		
		List<Integer> price = new ArrayList<>(Arrays.asList(9, 9));
		List<Integer> needs = new ArrayList<>(Arrays.asList(2, 2));
		List<List<Integer>> special = new ArrayList<>();
		special.add(new ArrayList<>(Arrays.asList(1,1,1)));
		System.out.println(s.shoppingOffers(price, special, needs));
	}

class Solution {
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		List<List<Integer>> usfulSpecial = new ArrayList<List<Integer>>();
		for (List<Integer> spe : special) {
			boolean isUsful = true;
			for (int i = 0; i < needs.size(); i++) {
				if (spe.get(i) > needs.get(i)) {
					isUsful = false;
					break;
				}
			}
			if (isUsful) {
				int discount = spe.get(needs.size()) * -1;
				for (int i = 0; i < spe.size() - 1; i++) {
					discount += (spe.get(i) * price.get(i));
				}
				if (discount > 0) {
					spe.add(discount);
					usfulSpecial.add(spe);
				}
			}
		}

		usfulSpecial = usfulSpecial.stream()
				.sorted((s1, s2) -> s2.get(s2.size() - 1).compareTo(s1.get(s1.size() - 1)))
				.collect(Collectors.toList());

		int totalPrice = 0;
		for (int i = 0; i < needs.size(); i++) {
			totalPrice += (needs.get(i) * price.get(i));
		}
		
		List<Integer> leftNeeds = new ArrayList<>(needs), currLeftNeeds = new ArrayList<>();
		for (List<Integer> spe: usfulSpecial) {
			boolean nextSpe = false;
			while (!nextSpe) {
				currLeftNeeds.clear();
				boolean buySpe = leftNeeds.size() == needs.size();
				for (int i = 0; i < leftNeeds.size(); i++) {
					if (leftNeeds.get(i) >= spe.get(i)) {
						currLeftNeeds.add(leftNeeds.get(i) - spe.get(i));
					} else {
						buySpe = false;
						break;
					}
				}
				if (buySpe) {
					totalPrice -= spe.get(spe.size() - 1);
					leftNeeds = new ArrayList<>(currLeftNeeds);
				} else {
					nextSpe = true;
				}
			}
		}

		return totalPrice;
	}
}
}

