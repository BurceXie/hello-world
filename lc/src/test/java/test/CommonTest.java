package test;

import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

public class CommonTest {

	@Test
	public void testReplaceAll() {
		String s = "qin-chuan@joyy.sg,|，；huang_chang_hu@joyy.sg";
		if (StringUtils.isNotBlank(s)) {
			s = s.replaceAll("[,，；\\|]+", ";");
		}
		System.out.println(s);
	}
}
