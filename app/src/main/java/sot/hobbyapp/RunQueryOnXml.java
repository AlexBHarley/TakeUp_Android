package sot.hobbyapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * Created by David on 09-08-2015.
 */



public class RunQueryOnXml {
    static Collection<ListingData> getListings(InputStream is) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(is);
        doc.getDocumentElement().normalize();

        System.out.println(doc.getFirstChild());

        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = "//Listing";

        NodeList nodes = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
        ArrayList<ListingData> ar = new ArrayList<ListingData>();
        for (int i = 0; i < nodes.getLength() && i < 2; i++) {
            Node node = nodes.item(i);
            ar.add(getData(node));
        }

        return ar;
    }

    static ListingData getData(Node n) {
        NodeList nodes = n.getChildNodes();
        String title = null;
        String buyNowPrice= null;
        String pictureHref = null;
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String nodeName = item.getNodeName();
            if (nodeName.equals("Title")) {
                title = item.getTextContent();
            }
            if (nodeName.equals("BuyNowPrice")) {
                buyNowPrice = item.getTextContent();
            }
            if (nodeName.equals("PictureHref")) {
                pictureHref = item.getTextContent();
            }
        }
        return new ListingData(title, buyNowPrice,pictureHref);
    }
}
