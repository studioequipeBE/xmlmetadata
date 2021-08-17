package com.studioequipe.xmlmetadata.metadata;

import com.studioequipe.xmlmetadata.StructureXML;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Les informations lié au QC.<br>
 * Lié au rapport QC fait dans le logicel...
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class RapportQC {

  /**
   * Pour écrire les informations.
   */
  public RapportQC() {
  }

  /**
   * Récupère les informations de l'XML.
   *
   * @param rapport_qc
   */
  public RapportQC(NodeList rapport_qc) {

  }

  /**
   * Génère un XML avec le rapport QC.
   *
   * @param document XML à se baser.
   * @return XML.
   *
   * @throws ParserConfigurationException
   */
  public Element getXML(Document document) throws ParserConfigurationException {
    Element node = document.createElement(StructureXML.NODE_RAPPORT_QC);

    return node;
  }
}
