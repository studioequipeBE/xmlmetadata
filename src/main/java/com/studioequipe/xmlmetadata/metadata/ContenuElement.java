package com.studioequipe.xmlmetadata.metadata;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Un élément du fichier.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class ContenuElement {

  /**
   * Timecode début de l'élément.
   */
  private String timecode_debut;

  /**
   * Timecode de fin de l'élément.
   */
  private String timecode_fin;

  /**
   * Description de l'élément.
   */
  private String description;

  /**
   * Récupère les informations depuis l'XML.
   *
   * @param contenu_element
   */
  public ContenuElement(NodeList contenu_element) {
    for (int i = 0; i < contenu_element.getLength(); i++) {
      if (contenu_element.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (contenu_element.item(i).getNodeName()) {
          case "timecode_debut":
            this.timecode_debut = contenu_element.item(i).getTextContent();
            break;

          case "timecode_fin":
            this.timecode_fin = contenu_element.item(i).getTextContent();
            break;

          case "description":
            this.description = contenu_element.item(i).getTextContent();
            break;
        }
      }
    }
  }

  /**
   * Définit un élement depuis les informations.
   *
   * @param timecode_debut
   * @param timecode_fin
   * @param description
   */
  public ContenuElement(String timecode_debut, String timecode_fin, String description) {
    this.timecode_debut = timecode_debut;
    this.timecode_fin = timecode_fin;
    this.description = description;
  }

  /**
   * Timecode début.
   *
   * @return
   */
  public String getTimecodeDebut() {
    return this.timecode_debut;
  }

  /**
   * Timecode de fin.
   *
   * @return
   */
  public String getTimecodeFin() {
    return this.timecode_fin;
  }

  /**
   * Description de l'élément.
   *
   * @return
   */
  public String getDescription() {
    return this.description;
  }
}
