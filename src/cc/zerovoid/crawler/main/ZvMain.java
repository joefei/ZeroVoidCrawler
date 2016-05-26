package cc.zerovoid.crawler.main;

import cc.zerovoid.crawler.util.CharFinder;
import cc.zerovoid.crawler.util.HttpUtil;

/**
 * 
 * [Java]知乎下巴第1集：爬虫世界百度不仅仅可以拿来测网速 - 汪海的实验室 - 博客频道 - CSDN.NET
 * 
 * http://blog.csdn.net/pleasecallmewhy/article/details/17594303
 * 
 * Create by ZV on 160526.Modify by on.
 * 
 * @author 绯若虚无
 */
public class ZvMain {

	// 使用到的类：URL URLConnection BufferedReader InputStreamReader
	public static void main(String[] args) {
		// 定义即将访问的链接
		// String url =
		// "http://freewgf.blog.163.com/blog/static/1973828682015961330887/";
		String url = "http://www.baidu.com";
		// 定义一个字符串用来存储网页内容
		String result = new HttpUtil().request(url);
		System.out.println(new CharFinder().index(result));
		new CharFinder().regular();
	}

}
