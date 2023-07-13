//package org.demoqa.utilities;
//
//public class httpHelper {
//    public void checkTheLink(String url){
//        url = it.next().getAttribute("href");
//
//        System.out.println(url);
//
//        if(url == null || url.isEmpty()){
//            System.out.println("URL is either not configured for anchor tag or it is empty");
//            continue;
//        }
//
//        if(!url.startsWith(homePage)){
//            System.out.println("URL belongs to another domain, skipping it.");
//            continue;
//        }
//
//        try {
//            huc = (HttpURLConnection)(new URL(url).openConnection());
//
//            huc.setRequestMethod("HEAD");
//
//            huc.connect();
//
//            respCode = huc.getResponseCode();
//        }
//    }
//
//}
//
