package Model;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Peter-Pim
 */
public class CreateAndReadXML {
    Document xmlDoc;
    NodeList mapList;
    String map[] = new String[100];
    
    public CreateAndReadXML() {
        buildAndReadMaps();
    }
    
    private boolean buildAndReadMaps() {
        /*
         * Try-catch block with an attempt to create a new .XML file.
         * The .XML file will be parsed and map data will be inserted.
         * 
         * Create a NodeList and fill it with elements from the .XML file.
         * Where there are elements in the NodeList to be iterated, fill the
         * map array with String elements for each level.
         */
        try {
            System.out.println("Creating .xml file to write to...");
            File mapStruct = new File("C:\\ProgramData\\Sokoban\\mapstructure.xml");
            System.out.println("Creating document builder...");
            DocumentBuilderFactory bldInstance = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = bldInstance.newDocumentBuilder();
            System.out.println("Parsing .xml file...");
            xmlDoc = docBuilder.parse(mapStruct);
            
            System.out.println("Root element: " + xmlDoc.getDocumentElement().getNodeName());
            mapList = xmlDoc.getElementsByTagName("map");
            System.out.println("--------------------");
        } catch(Exception e) { e.printStackTrace(); return false; }
        try {
            for(int i = 0; i < mapList.getLength(); i++) {
                Node nNode = mapList.item(i);
                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element mapElement = (Element) nNode;
                    map[i] = getTagValue("col1", mapElement) + "\n" + getTagValue("col2", mapElement) + 
                        "\n" + getTagValue("col3", mapElement) + "\n" + getTagValue("col4", mapElement) + 
                        "\n" + getTagValue("col5", mapElement) + "\n" + getTagValue("col6", mapElement) + 
                        "\n" + getTagValue("col7", mapElement) + "\n" + getTagValue("col8", mapElement) +
                        "\n" + getTagValue("col9", mapElement) + "\n" + getTagValue("col10", mapElement) +
                        "\n" + getTagValue("col11", mapElement) + "\n" + getTagValue("col12", mapElement) + 
                        "\n" + getTagValue("col13", mapElement) + "\n" + getTagValue("col14", mapElement) +
                        "\n" + getTagValue("col15", mapElement);
                }
            }
        } catch(Exception e) { e.printStackTrace(); return false; }
        return true;
    }
    
    /*
     * @param colNumber The column number used to retrieve Stringvalues from.
     * @param mapElement The element of the map we are retrieving from.
     * Create a NodeList of nodes that are found under the mapElement.
     * Create a Node that is the be the first item in the list of NodeList.
     * @return the NodeValue, a String.
     * 
     */
    private String getTagValue(String colNumber, Element mapElement) {
        try {
            NodeList colList = mapElement.getElementsByTagName(colNumber).item(0).getChildNodes();
            Node colValue = (Node) colList.item(0);
            return colValue.getNodeValue();
        } catch(Exception e) { e.printStackTrace(); }
        return "";
    }
    
    public String getMap(int currentLevel) {
        return map[currentLevel];
    }
}