package com.studioequipe.xmlmetadata.metadata;

import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Contenu du fichier.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class Contenu {

  private ArrayList<ContenuElement> liste_contenu;

  /**
   * Pour écrire les informations.
   */
  public Contenu() {
    this.liste_contenu = new ArrayList<ContenuElement>();
  }

  public void addContenu(ContenuElement contenu_element) {
    this.liste_contenu.add(contenu_element);
  }

  /**
   * Récupère les informations de l'XML.
   *
   * @param contenu
   */
  public Contenu(NodeList contenu) {
    this.liste_contenu = new ArrayList<ContenuElement>();

    for (int i = 0; i < contenu.getLength(); i++) {
      if (contenu.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (contenu.item(i).getNodeName()) {
          case "contenu":
            this.liste_contenu.add(new ContenuElement(contenu.item(i).getChildNodes()));
            break;
        }
      }
    }
  }

  /**
   * Récupère la liste du contenu.
   *
   * @return
   */
  public ArrayList<ContenuElement> getListe() {
    return this.liste_contenu;
  }

  /**
   * Récupères sous forme d'XML les informations du contenu.
   *
   * @param document
   * @return
   * @throws ParserConfigurationException
   */
  public Element getXML(Document document) throws ParserConfigurationException {
    Element node = document.createElement("liste_contenu");

    for (int i = 0; i < this.liste_contenu.size(); i++) {
      Element contenu = document.createElement("contenu");

      Element timecode_debut = document.createElement("timecode_debut");
      timecode_debut.setTextContent(this.liste_contenu.get(i).getTimecodeDebut());
      contenu.appendChild(timecode_debut);

      Element timecode_fin = document.createElement("timecode_fin");
      timecode_fin.setTextContent(this.liste_contenu.get(i).getTimecodeFin());
      contenu.appendChild(timecode_fin);

      Element description = document.createElement("description");
      description.setTextContent(this.liste_contenu.get(i).getDescription());
      contenu.appendChild(description);

      node.appendChild(contenu);
    }

    return node;
  }

}
