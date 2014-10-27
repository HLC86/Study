package com.my.http;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.*;

public class HttpConn {

    public static void main(String[] args) {

        String table = "EANOrganization";
        String timestamp = "HDC_20141014_051919746";
        HttpConn conn = new HttpConn();
        int i = 0;
        do {
            conn.parseReq(table, timestamp);
        } while ((timestamp = conn.RestReqWithXml("data" + i++ + ".xml", table)) != null);
    }

    private String isEmpty(String file, String table) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            Node n = doc.getFirstChild();
            if (!n.hasChildNodes()) {
                return null;
            }

            Node tableNode = doc.getElementsByTagName(table + "Table").item(0);
            NamedNodeMap attr = tableNode.getAttributes();
            Node name = attr.getNamedItem("maxtimestamp");
            return name.getTextContent();
        } catch (Exception e) {
            return null;
        }
    }

    private void parseReq(String table, String timestamp) {
        System.out.print(table + ":" + timestamp);
        String filePath = "request.xml";
        URL url = getClass().getClassLoader().getResource(filePath);
        filePath = url.getFile();
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try (OutputStream os = new FileOutputStream("out.xml.tmp")) {
            docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filePath);
            Node tableNode = doc.getElementsByTagName("table").item(0);
            NamedNodeMap attr = tableNode.getAttributes();
            Node name = attr.getNamedItem("name");
            Node timestampNode = attr.getNamedItem("timestamp");
            if (table != null) {
                name.setTextContent(table);
            }
            timestampNode.setTextContent(timestamp);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(os);
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private String RestReqWithXml(String outFile, String table) {
        try (InputStream is = new FileInputStream("out.xml.tmp"); OutputStream os = new FileOutputStream(outFile)) {
            byte[] buffer = new byte[255];
            URL url = new URL("http://10.43.152.184/EANService/V2/EAN");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/xml");
            OutputStream oStream = conn.getOutputStream();
            int n = 0;
            while ((n = is.read(buffer)) > 0) {
                oStream.write(buffer, 0, n);
            }
            oStream.flush();
            conn.connect();
            InputStream in = conn.getInputStream();
            //System.out.println(conn.getResponseCode());
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                os.write(buffer, 0, len);
            }
        } catch (Exception e) {
            return null;
        }
        System.out.println(" has been written to file " + outFile);
        String res = isEmpty(outFile, table);
        return res;
    }

    private static void basic() {
        try {

            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.86.33.21", 8080));
            String urlStr = "http://www.baidu.com";
            // urlStr = URLEncoder.encode(urlStr);

            URL url = new URL(urlStr);
            URLConnection urlConnection = url.openConnection(proxy);
            urlConnection.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String str = br.readLine();

            System.out.println(str);

            // Proxy proxy = new Proxy(Proxy.Type.HTTP, new
            // InetSocketAddress("123.0.0.1", 8080));
            // URL url = new URL("http://www.yahoo.com");
            // HttpURLConnection uc =
            // (HttpURLConnection)url.openConnection(proxy);
            // uc.connect();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
