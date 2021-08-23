package com.studioequipe.xmlmetadata.metadata;

import com.studioequipe.xmlmetadata.StructureXML;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Définit les informations de sous-titre.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public class SousTitre {

  /**
   * S'il y a la présence de sous-titre.
   */
  private boolean present;

  /**
   * Langue des sous-titres.
   */
  private String langue;

  /**
   * Si ce sont des sous-titres partiels.
   */
  private boolean partiel;

  /**
   * S'il s'agit d'un SME.
   */
  private boolean sme;

  /**
   * Pour écrire les informations.
   */
  public SousTitre() {
  }

  /**
   * Récupère les informations de l'XML.
   *
   * @param sous_titre Noeud "soustitre".
   */
  public SousTitre(NodeList sous_titre) {
    for (int i = 0; i < sous_titre.getLength(); i++) {
      if (sous_titre.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (sous_titre.item(i).getNodeName()) {
          case StructureXML.SOUSTITRE_PRESENT:
            this.present = sous_titre.item(i).getTextContent().equals(StructureXML.OUI);
            break;

          case StructureXML.SOUSTITRE_LANGUE:
            this.langue = sous_titre.item(i).getTextContent();
            break;

          case StructureXML.SOUSTITRE_PARTIEL:
            this.partiel = sous_titre.item(i).getTextContent().equals(StructureXML.OUI);
            break;

          case StructureXML.SOUSTITRE_SME:
            this.sme = sous_titre.item(i).getTextContent().equals(StructureXML.OUI);
            break;
        }
      }
    }
  }

  /**
   * Génère un XML avec les informations de sous-titre.
   *
   * @param document Fichier XML à générer.
   *
   * @return Noeud à ajouter au fichier XML.
   *
   * @throws ParserConfigurationException Erreur d'analyse de la configuration.
   */
  public Element getXML(Document document) throws ParserConfigurationException {
    Element node = document.createElement(StructureXML.NODE_SOUSTITRE);

    Element present = document.createElement(StructureXML.SOUSTITRE_PRESENT);
    present.setTextContent((this.present ? StructureXML.OUI : StructureXML.NON));
    node.appendChild(present);

    Element langue = document.createElement(StructureXML.SOUSTITRE_LANGUE);
    langue.setTextContent(this.langue);
    node.appendChild(langue);

    Element partiel = document.createElement(StructureXML.SOUSTITRE_PARTIEL);
    partiel.setTextContent((this.partiel ? StructureXML.OUI : StructureXML.NON));
    node.appendChild(partiel);

    Element sme = document.createElement(StructureXML.SOUSTITRE_SME);
    sme.setTextContent((this.sme ? StructureXML.OUI : StructureXML.NON));
    node.appendChild(sme);

    return node;
  }
}
