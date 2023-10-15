package com.fulwin.jd.utils;

import com.fulwin.jd.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class HtmlParseUtil {
//    public static void main(String[] args) throws IOException {
//        new HtmlParseUtil().parseJd("go").forEach(System.out::println);
//    }

    public List<Content> parseJd(String keywords) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keywords;

        Document document = Jsoup.parse(new URL(url), 30000);
        Element jGoodsList = document.getElementById("J_goodsList");
        assert jGoodsList != null;
        Elements li = jGoodsList.getElementsByTag("li");

        ArrayList<Content> productsList = new ArrayList<>();

        for(Element el : li){
            if (el.attr("class").equalsIgnoreCase("gl-item")) {
                String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
                String price = el.getElementsByClass("p-price").eq(0).text();
                String title = el.getElementsByClass("p-name").eq(0).text();

                Content content = new Content();
                content.setImg(img);
                content.setPrice(price);
                content.setTitle(title);

                productsList.add(content);
            }
        }
        return productsList;
    }
}
