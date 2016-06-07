package cc.zerovoid.crawler.control;

import java.util.ArrayList;

import cc.zerovoid.crawler.entity.Zhihu;

public class ZhihuSpider {
	public static ArrayList<Zhihu> getZhiHu(String targetString) {
		ArrayList<Zhihu> results = new ArrayList<Zhihu>();
		ArrayList<String> titleList = ZvSpider.regular(targetString,
				"question_link.+?>(.+?)<");
		ArrayList<String> urlList = ZvSpider.regular(targetString,
				"question_link.+?href=\"(.+?)\"");
		if (titleList != null && urlList != null) {
			for (int i = 0; i < titleList.size(); i++) {
				Zhihu zhihu = new Zhihu();
				zhihu.question = titleList.get(i);
				zhihu.zhihuURL = "http://www.zhihu.com" + urlList.get(i);
				results.add(zhihu);
			}
		}
		return results;
	}
}
