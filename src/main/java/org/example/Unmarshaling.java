package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;

public class Unmarshaling {
    public void unmarshal() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = documentBuilder.newDocument();
        Element rootElement = document.createElement("humans");
        document.appendChild(rootElement);
        CreateHuman createHuman = new CreateHuman();
        ArrayList<Human> humans = createHuman.getHumans();
        for (Human human : humans) {
            Element humanElement = createHumanElements(document, human);
            rootElement.appendChild(humanElement);
        }
        StreamResult streamResult = new StreamResult("my.xml");
        vritingXMLFele("my.xml", document);
    }


    private void vritingXMLFele(String fileName, Document document) {
        Transformer transformer = null;
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }

        DOMSource source = new DOMSource(document);
        StreamResult streamResult = new StreamResult("my.xml");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        try {
            transformer.transform(source, streamResult);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    private Element createHumanElements(Document document, Human human) {
        Element humanElement = document.createElement("human");
        Element nameElement = document.createElement("name");
        nameElement.setTextContent(human.getName());
        Element surnameElement = document.createElement("surname");
        surnameElement.setTextContent(human.getSurname());
        Element ageElement = document.createElement("age");
        ageElement.setTextContent(String.valueOf(human.getAge()));

        humanElement.appendChild(nameElement);
        humanElement.appendChild(surnameElement);
        humanElement.appendChild(ageElement);

        Element addressElement = document.createElement("address");

        Element cityElement = document.createElement("city");
        cityElement.setTextContent(human.getAddress().getCity());
        Element streetElement = document.createElement("street");
        streetElement.setTextContent(human.getAddress().getStreet());
        Element houseElement = document.createElement("house");
        houseElement.setTextContent(human.getAddress().getHouseNumber());

        addressElement.appendChild(cityElement);
        addressElement.appendChild(houseElement);
        addressElement.appendChild(streetElement);
        humanElement.appendChild(addressElement);
        return humanElement;
    }
}
