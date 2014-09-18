package com.my.files;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by u0149852 on 2014/8/7.
 */
public class dom {
	public static void main(String[] args) throws ParserConfigurationException {
		final String p = "D:\\work\\feeds\\rcs\\RCS v111.02 Release\\KnowledgeItems\\knowledgeitem_rcs-data-product_0_all_2014-06-09.xml";
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		DocumentBuilderFactory domFactory = DocumentBuilderFactory
				.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		try {
			Document doc = builder.parse(inputStream);
			// Element documentElement = doc.getDocumentElement();

			// NodeList nodeList = doc.getElementsByTagName("concept");
			// System.out.println(nodeList.getLength());
			// System.out.println(documentElement.getFirstChild().getNodeName());

			NodeList nodeList = doc.getElementsByTagName("itemMeta");
			System.out.println(nodeList.item(0).getChildNodes().getLength());
			for (int i = 0; i < nodeList.item(0).getChildNodes().getLength(); i++) {
				String name = nodeList.item(0).getChildNodes().item(i)
						.getLocalName();
				if (name != null && name.equals("profile")) {
					NamedNodeMap a = nodeList.item(0).getChildNodes().item(i)
							.getAttributes();
					System.out.println(a.getNamedItem("versioninfo")
							.getTextContent());
				}

			}
			// XPath xpath = XPathFactory.newInstance().newXPath();
			// XPathExpression expr =
			// xpath.compile("/knowledgeItem/itemMeta/profile");
			// Object result = expr.evaluate(doc, XPathConstants.NODESET);
			// NodeList nodes = (NodeList) result;
			// System.out.println(nodes.getLength());
			// for (int i = 0; i < nodes.getLength(); i++) {
			// System.out.println(nodes.item(i).getNodeValue());
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
