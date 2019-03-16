package cn.bdqn.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CookieUtil {

	public static String addValue(String oldStr, String id) {
		// 如果没有，就直接return。
		if (oldStr == null || oldStr.equals("")) {
			return id;
		}
		String[] arr = oldStr.split(",");
		// 将数组转换为集合
		List<String> li = Arrays.asList(arr);
		LinkedList<String> ll = new LinkedList<String>(li);
		if (ll.size() < 3) {// 小于3个
			if (ll.contains(id)) {
				ll.remove(id);
			}
		} else {// 大于3个
			if (!ll.contains(id)) {
				ll.removeLast();
			} else {
				ll.remove(id);
			}
		}
		ll.addFirst(id);
		StringBuffer sdf = new StringBuffer();
		for (String temp : ll) {
			sdf.append(temp + ",");
		}
		String s = sdf.substring(0, sdf.length() - 1);
		return s;
	}
}
