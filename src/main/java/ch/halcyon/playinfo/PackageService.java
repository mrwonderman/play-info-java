package ch.halcyon.playinfo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class PackageService {

    private static String BASE_URL = "https://play.google.com/store/apps/details?id=";

    public static PackageInfo getPackageInfoByPackageName(String packagename) {

        PackageInfo info = new PackageInfo();
        try {
            String html = doGetRequest(packagename);
            Document doc = Jsoup.parse(html);

            // parses the title
            info.setTitle(getTitle(doc));

            // parses the category
            info.setCategory(getCategory(doc));

            // parses the price
            info.setPrice(getPrice(doc));

            // parses the meta-info
            Elements metaInfo = doc.getElementsByClass("meta-info");

            for (Element element : metaInfo) {
                Elements classEle = element.getElementsByClass("content");
                if (classEle.first().attr("class")
                        .equals("content contains-text-link")) {

                    Elements elementsByClass = classEle.first()
                            .getElementsByClass("dev-link");

                    // dev mail
                    String devmail = elementsByClass.get(1).attr("href")
                            .replace("mailto:", "");

                    info.setEmail(devmail);

                    // dev web
                    String devweb = elementsByClass.get(0).attr("href")
                            .replace("https://www.google.com/url?q=", "")
                            .split("&")[0];

                    info.setWebsite(devweb);

                }
                String attr = classEle.attr("itemprop");
                switch (attr) {
                    case "datePublished":
                        // last updated
                        info.setUpdated(classEle.text());
                        break;

                    case "numDownloads":
                        // total installs
                        info.setTotalInstalls(classEle.text());
                        break;

                    case "fileSize":
                        // fileSize
                        info.setSize(classEle.text());
                        break;

                    case "softwareVersion":
                        // version of the app
                        info.setCurrentVersion(classEle.text());
                        break;

                    case "operatingSystems":
                        // operating System
                        info.setRequiresAndroid(classEle.text());
                        break;

                    case "contentRating":
                        // content rating
                        info.setContentRating(classEle.text());

                        break;

                    default:
                        break;
                }
            }

            // score
            info.setScore(getScore(doc));

            // parses the votes
            info.setVotes(getRating(doc));

            // parses the dev
            info.setDeveloper(getDeveloper(doc));

            // whats new
            info.setWhatsNew(getWhatsnew(doc));

            // text
            info.setDescription(getDescription(doc));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    private static String getDescription(Document doc) {
        return doc
                .getElementsByAttributeValue("itemprop", "description")
                .get(1).text();
    }

    private static String getWhatsnew(Document doc) {
        return doc.getElementsByClass("recent-change").text();
    }

    private static String getDeveloper(Document doc) {
        return doc
                .getElementsByAttributeValue("itemprop", "author").first()
                .getElementsByAttributeValue("itemprop", "name").text();
    }

    private static String getRating(Document doc) {
        return doc.getElementsByClass("reviews-num").text();
    }

    private static String getScore(Document doc) {
        return doc.getElementsByClass("score").text();
    }

    private static String getPrice(Document doc) {
        String price = doc.getElementsByAttributeValue("itemprop", "price")
                .first().attr("content");

        if (price.equals("0")) {
            price = "Free";
        }
        return price;
    }

    private static String getCategory(Document doc) {
        return doc
                .getElementsByAttributeValue("itemprop", "genre").first()
                .text();
    }

    private static String getTitle(Document doc) {
        return doc.getElementsByClass("document-title").first()
                .getAllElements().first().text();
    }

    private static String doGetRequest(String packagename)
            throws MalformedURLException, IOException, ProtocolException {
        URL obj = new URL(BASE_URL + packagename);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("accept-language", "en-GB,en;q=0.8,de;q=0.6");

        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // return result
        return response.toString();
    }

}
