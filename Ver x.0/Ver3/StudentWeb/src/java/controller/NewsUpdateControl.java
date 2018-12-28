/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import model.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Admin
 */
public class NewsUpdateControl extends Thread{
    public void run () {
        NewsUpdateControl newsCtr = new NewsUpdateControl();
    }
    public ArrayList<News> getNewsPost() throws IOException {
        ArrayList<News> newsList = new ArrayList<>();
        String url = "http://portal.ptit.edu.vn/";
        Document document = Jsoup.connect(url).get();
        
        Elements title = document.getElementsByClass("post-title");
        Iterator<Element> it = title.iterator();
        Elements urlNews = document.getElementsByClass("link");
        Iterator<Element> itUrl = urlNews.iterator();
        Elements image = document.getElementsByClass("wp-post-image");
        Iterator<Element> itImage = image.iterator();
        
        while(it.hasNext()) {
            Element aTitle = it.next();
            Element aUrl = itUrl.next();
            Element aImage = itImage.next();
            
            News news = new News(aTitle.text(), aUrl.attr("href"), aImage.attr("src"), "Tin tức");
            newsList.add(news);
        }
        return newsList;
    }
    
    public ArrayList<News> getNewsGiaoVu() throws IOException {
        ArrayList<News> newsList = new ArrayList<>();
        String url = "http://portal.ptit.edu.vn/giaovu/";
        Document document = Jsoup.connect(url).get();

        Elements title = document.getElementsByClass("post-title");
        Iterator<Element> it = title.iterator();
        Elements urlNews = document.select(".entry-title a");
        Iterator<Element> itUrl = urlNews.iterator();

        while (it.hasNext()) {
            Element aTitle = it.next();
            Element aUrl = itUrl.next();
            
            News news = new News(aTitle.text(), aUrl.attr("href"), "http://aocunhankimtrinh.com/upload/images/IMG_0123.JPG", "Giáo vụ");
            newsList.add(news);
        }
        return newsList;
    }
    
    public ArrayList<News> getNewsTTKT() throws IOException {
        ArrayList<News> newsList = new ArrayList<>();
        String url = "http://portal.ptit.edu.vn/ttkt/";
        Document document = Jsoup.connect(url).get();

        Elements title = document.getElementsByClass("post-title");
        Iterator<Element> it = title.iterator();
        Elements urlNews = document.select(".entry-title a");
        Iterator<Element> itUrl = urlNews.iterator();

        while (it.hasNext()) {
            Element aTitle = it.next();
            Element aUrl = itUrl.next();
 
            
            News news = new News(aTitle.text(), aUrl.attr("href"), "https://img2.infonet.vn/w660/Uploaded/2018/pjauldz/2017_11_10/ictnews_trao_bang_ptit.jpg", "Trung tâm Khảo thí");
            newsList.add(news);
        }
        return newsList;
    }
    
    public static void main(String[] args) throws IOException {
        NewsUpdateControl newsCtr = new NewsUpdateControl();
        ArrayList<News> newsList = newsCtr.getNewsGiaoVu();
        for(News news: newsList) {
            System.out.println("Title: " + news.getTitle());
            System.out.println("Url: " + news.getUrl());
            System.out.println("Image" + news.getImage());
        }
        
        System.out.println(newsList.get(0).getTitle());
    }
}
