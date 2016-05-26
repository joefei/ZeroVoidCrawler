package cc.zerovoid.crawler.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;


/**
 * 
 * @author 绯若虚无
 * 
 * @version 绯若寻踪①号
 *
 */
public class CharFinder {

	// 使用正则表达式
	public String regular() {
		// 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容  
		// 相当于埋好了陷阱匹配的地方就会掉下去 
		Pattern pattern = Pattern.compile("href=\"(.+?)\"");  
		// 定义一个matcher用来做匹配  
		java.util.regex.Matcher matcher = pattern.matcher("＜a href=\"index.html\"＞我的主页＜/a＞");  
		// 如果找到了  
		if (matcher.find()) {  
		    // 打印出结果  
		    System.out.println(matcher.group(1));  
		}  
		return "";
	}

	//使用indexOf和substring();
	public String index(String source) {
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
