package com.my.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Xiaoming Wang on 2014/11/28.
 */
public class CapturePdf {
    private final String MAIN_URL = "http://cdm.ccchina.gov.cn/";

    public static void main(String[] args) {
        CapturePdf cap = new CapturePdf();
        try {
            String saveDir = "\\\\oag-intfs.pointcarbon.local\\Common\\CCER\\cdm.ccchina.gov.cn\\";
            String page = cap.getMainPage();
            List<String> urls = cap.getUrls(page);
            cap.downloadPdf(urls, saveDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void downloadPdf(List<String> urls, String saveDir) throws Exception {
        Path dir = Paths.get(saveDir);
        for (String url : urls) {
            System.out.println(""+url);
            URL u = new URL(MAIN_URL + url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            try (InputStream is = conn.getInputStream()) {
                String outputFileName = conn.getURL().getFile();
                int index = outputFileName.lastIndexOf('/');
                outputFileName = outputFileName.substring(index + 1);
                OutputStream os = Files.newOutputStream(dir.resolve(outputFileName));
                byte[] buffer = new byte[2000];
                int len;
                while((len = is.read(buffer)) > -1){
                    os.write(buffer, 0, len);
                }
                os.close();
                System.out.println("Downloaded " + dir.resolve(outputFileName));
            }
        }
    }

    public String getMainPage() throws Exception {

        String url = MAIN_URL + "sdxm.aspx?clmId=163";
        URL u = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line = null;
            String res = "";
            while ((line = br.readLine()) != null) {
                res += "\r\n" + line;
            }
            return res;
        }
    }

    public List<String> getUrls(String page) {
        List<String> urls = new ArrayList<>();
        Pattern p = Pattern.compile("zyDetail.aspx\\?newsId=\\d+&TId=163");
        Matcher m = p.matcher(page);
        while (m.find()) {
            urls.add(m.group());
        }
        return urls;
    }
}
