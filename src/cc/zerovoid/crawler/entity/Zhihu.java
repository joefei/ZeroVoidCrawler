package cc.zerovoid.crawler.entity;

import java.util.ArrayList;

public class Zhihu {

	public String question;
	public String zhihuURL;
	public String questionDescription;// 问题描述
	public ArrayList<String> answerList;

	public Zhihu() {
		question = "";
		zhihuURL = "";
		answerList = new ArrayList<String>();
	}

	@Override
	public String toString() {
		return "问题：" + question + "\n描述：" + questionDescription + "\n链接："
				+ zhihuURL + "\n回答：" + answerList + "\n";
	}

}
