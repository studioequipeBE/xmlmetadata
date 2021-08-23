package com.studioequipe.xmlmetadata.metadata;

import com.studioequipe.xmlmetadata.StructureXML;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Un élément du fichier.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
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
   * @param contenu_element Noeud "contenu_element".
   */
  public ContenuElement(NodeList contenu_element) {
    for (int i = 0; i < contenu_element.getLength(); i++) {
      if (contenu_element.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (contenu_element.item(i).getNodeName()) {
          case StructureXML.CONTENU_LISTE_ELEMENT_TIMECODE_DEBUT:
            this.timecode_debut = contenu_element.item(i).getTextContent();
            break;

          case StructureXML.CONTENU_LISTE_ELEMENT_TIMECODE_FIN:
            this.timecode_fin = contenu_element.item(i).getTextContent();
            break;

          case StructureXML.CONTENU_LISTE_ELEMENT_TIMECODE_DESCRIPTION:
            this.description = contenu_element.item(i).getTextContent();
            break;
        }
      }
    }
  }

  /**
   * Définit un élement depuis les informations.
   *
   * @param timecode_debut Timecode début.
   * @param timecode_fin Timecode de fin.
   * @param description Description du contenu.
   */
  public ContenuElement(String timecode_debut, String timecode_fin, String description) {
    this.timecode_debut = timecode_debut;
    this.timecode_fin = timecode_fin;
    this.description = description;
  }

  /**
   * Récupère le timecode début.
   *
   * @return Timecode début.
   */
  public String getTimecodeDebut() {
    return this.timecode_debut;
  }

  /**
   * Récupère le timecode de fin.
   *
   * @return Timecode de fin.
   */
  public String getTimecodeFin() {
    return this.timecode_fin;
  }

  /**
   * Récupère la description de l'élément.
   *
   * @return Description.
   */
  public String getDescription() {
    return this.description;
  }
}
