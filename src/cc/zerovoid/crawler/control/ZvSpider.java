package cc.zerovoid.crawler.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import cc.zerovoid.crawler.entity.Zhihu;

/**
 * 
 * 爬虫
 * 
 * @author 绯若虚无
 * 
 *         Create by zv on 160601.Modify by zv on 160607.
 * 
 * @version 虚无蜘蛛①号
 *
 */
public class ZvSpider {

	/**
	 * 使用正则表达式
	 * 
	 * @param targetString
	 * @param patternString
	 * @return
	 */
	public static ArrayList<String> regular(String targetString,
			String patternString) {
		ArrayList<String> results = new ArrayList<String>();
		// 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
		// 相当于埋好了陷阱匹配的地方就会掉下去
		Pattern pattern = Pattern.compile(patternString);
		// 定义一个matcher用来做匹配
		java.util.regex.Matcher matcher = pattern.matcher(targetString);
		boolean isFind = matcher.find();
		// 使用循环将句子里所有的kelvin找出并替换再将内容加到sb里
		while (isFind) {
			// 添加成功匹配的结果
			results.add(matcher.group(1) + "\n");
			// 继续查找下一个匹配对象
			isFind = matcher.find();
		}
		return results;
	}

	/**
	 * 使用indexOf和substring();
	 * 
	 * @param source
	 * @return
	 */
	public static String index(String source) {
		String result = "";
		ArrayList<HashMap<String, Integer>> list = new ArrayList<HashMap<String, Integer>>();
		if (source != null) {
			int beginIndex = 0;
			int endIndex = 0;
			// 遍历返回的结果
			for (int i = 0; i < source.length(); i++) {
				// 从上次结尾开始
				source = source.substring(endIndex);
				// 重新查找 tag=img
				beginIndex = source.indexOf("<img");
				// 如果没有就退出
				if (beginIndex == -1) {
					break;
				}
				source = source.substring(beginIndex);
				endIndex = source.indexOf(">");
				if (endIndex != -1) {
					String img = source.substring(0, endIndex + 1);
					result = result + img + "\n";
				}
			}
		}
		return result;
	}

}
