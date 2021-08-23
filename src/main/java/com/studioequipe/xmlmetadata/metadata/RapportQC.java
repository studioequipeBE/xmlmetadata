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
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
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
   * @param rapport_qc Le noeud "rapport_qc".
   */
  public RapportQC(NodeList rapport_qc) {
  }

  /**
   * Génère un XML avec le rapport QC.
   *
   * @param document XML à se baser.
   *
   * @return Noeud à ajouter au fichier XML.
   *
   * @throws ParserConfigurationException Erreur d'analyse de la configuration.
   */
  public Element getXML(Document document) throws ParserConfigurationException {
    Element node = document.createElement(StructureXML.NODE_RAPPORT_QC);

    return node;
  }
}
