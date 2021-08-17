package com.studioequipe.xmlmetadata.metadata;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Définit les informations de sous-titre.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
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
   * @param sous_titre
   */
  public SousTitre(NodeList sous_titre) {
    for (int i = 0; i < sous_titre.getLength(); i++) {
      if (sous_titre.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (sous_titre.item(i).getNodeName()) {
          case "present":
            this.present = sous_titre.item(i).getTextContent().equals("oui");
            break;

          case "langue":
            this.langue = sous_titre.item(i).getTextContent();
            break;

          case "partiel":
            this.partiel = sous_titre.item(i).getTextContent().equals("oui");
            break;

          case "sme":
            this.sme = sous_titre.item(i).getTextContent().equals("oui");
            break;
        }
      }
    }
  }

  /**
   * Génère un XML avec les informations de sous-titre.
   *
   * @param document
   * @return
   * @throws ParserConfigurationException
   */
  public Element getXML(Document document) throws ParserConfigurationException {
    Element node = document.createElement("soustitre");

    Element present = document.createElement("present");
    present.setTextContent((this.present ? "oui" : "non"));
    node.appendChild(present);

    Element langue = document.createElement("langue");
    langue.setTextContent(this.langue);
    node.appendChild(langue);

    Element partiel = document.createElement("partiel");
    partiel.setTextContent((this.partiel ? "oui" : "non"));
    node.appendChild(partiel);

    Element sme = document.createElement("sme");
    sme.setTextContent((this.sme ? "oui" : "non"));
    node.appendChild(sme);

    return node;
  }
}
