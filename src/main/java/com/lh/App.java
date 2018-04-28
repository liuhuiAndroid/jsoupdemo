package com.lh;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    protected static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static String url = "http://jzsc.mohurd.gov.cn/dataservice/query/staff/list";

    public static List list = new ArrayList<>();

    public static String[] strings = new String[]{
            "11", "12", "13", "14", "15",
            "21", "22", "23",
            "31", "32", "33", "34", "35", "36", "37",
            "41", "42", "43", "44", "45", "46",
            "50", "51", "52", "53", "54",
            "61", "62", "63", "64", "65",
            "71", "81", "82"
    };

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < strings.length; j++) {
                    try {
                        for (int k = 1; k < 10; k++) {
                            try {
                                Connection conn = Jsoup.connect(url + "?timestamp=" + k);
                                conn.data("ry_reg_type", "RY_ZCLB_037");
                                conn.data("$pg", k + "");
                                conn.data("$pgsz", "30");
                                conn.data("ry_cardno", strings[j]);
                                conn.data("timestamp", k + "");
                                conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                                conn.header("Accept-Encoding", "gzip, deflate, sdch");
                                conn.header("Accept-Language", "zh-CN,zh;q=0.8");
                                conn.header("Cache-Control", "max-age=0");
                                conn.header("Connection", "keep-alive");
                                conn.header("Content-Type", "application/x-www-form-urlencoded");
                                conn.header("Host", "jzsc.mohurd.gov.cn");
                                conn.header("Origin", "http://jzsc.mohurd.gov.cn");
                                conn.header("Referer", "http://jzsc.mohurd.gov.cn/dataservice/query/staff/list");
                                conn.header("Upgrade-Insecure-Requests", 1 + "");
                                conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
                                Document doc = null;
                                doc = conn.post();
                                Elements elementsDiv = doc.getElementsByClass("mtop");
                                Elements elementsByTag = elementsDiv.first().getElementsByTag("tr");
                                for (int i = 1; i < elementsByTag.size() - 1; i++) {
                                    Element element = elementsByTag.get(i);
                                    Elements children = element.children();
                                    MUser mUser = new MUser();
                                    if (children.size() == 6) {
                                        String id = children.get(0).text();
                                        mUser.setId(id);
                                        String username = children.get(1).getElementsByTag("a").text();
                                        mUser.setUsername(username);
                                        String idcard = children.get(2).text();
                                        mUser.setIdcard(idcard);
                                        String type = children.get(3).text();
                                        mUser.setType(type);
                                        String no = children.get(4).text();
                                        mUser.setNo(no);
                                    }
                                    list.add(mUser);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        runnable.run();
        logger.info(list.toString());
        logger.info(list.size() + "");
    }

}
