package com.studioequipe.xmlmetadata.metadata;

import com.studioequipe.xmlmetadata.StructureXML;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Contenu du fichier.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public class Contenu {

  private ArrayList<ContenuElement> liste_contenu;

  /**
   * Pour écrire les informations.
   */
  public Contenu() {
    this.liste_contenu = new ArrayList<ContenuElement>();
  }

  /**
   * Récupère les informations de l'XML.
   *
   * @param contenu Le noeud "contenu" (XML).
   */
  public Contenu(NodeList contenu) {
    this.liste_contenu = new ArrayList<ContenuElement>();

    for (int i = 0; i < contenu.getLength(); i++) {
      if (contenu.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (contenu.item(i).getNodeName()) {
          case StructureXML.CONTENU_LISTE_CONTENU:

            NodeList liste_contenu = contenu.item(i).getChildNodes();

            for (int j = 0; j < liste_contenu.getLength(); j++) {
              if (liste_contenu.item(j).getNodeType() == Node.ELEMENT_NODE) {
                switch (liste_contenu.item(j).getNodeName()) {
                  case StructureXML.CONTENU_LISTE_CONTENU_ELEMENT:
                    this.liste_contenu.add(new ContenuElement(liste_contenu.item(j).getChildNodes()));
                    break;
                }
              }
            }
        }
      }
    }
  }

  /**
   * Ajoute un contenu.
   *
   * @param contenu_element L'élément à ajouter.
   */
  public void addContenu(ContenuElement contenu_element) {
    this.liste_contenu.add(contenu_element);
  }

  /**
   * Récupère la liste du contenu.
   *
   * @return Liste de tout le contenu.
   */
  public ArrayList<ContenuElement> getListe() {
    return this.liste_contenu;
  }

  /**
   * Récupères sous forme d'XML les informations du contenu.
   *
   * @param document Le fichier XML a générer.
   *
   * @return Noeud à ajouter au fichier XML.
   *
   * @throws ParserConfigurationException Erreur d'analyse de la configuration.
   */
  public Element getXML(Document document) throws ParserConfigurationException {
    Element node = document.createElement(StructureXML.NODE_CONTENU);

    Element liste_contenu = document.createElement(StructureXML.CONTENU_LISTE_CONTENU);

    for (int i = 0; i < this.liste_contenu.size(); i++) {
      Element contenu = document.createElement(StructureXML.CONTENU_LISTE_CONTENU_ELEMENT);

      Element timecode_debut = document.createElement(StructureXML.CONTENU_LISTE_ELEMENT_TIMECODE_DEBUT);
      timecode_debut.setTextContent(this.liste_contenu.get(i).getTimecodeDebut());
      contenu.appendChild(timecode_debut);

      Element timecode_fin = document.createElement(StructureXML.CONTENU_LISTE_ELEMENT_TIMECODE_FIN);
      timecode_fin.setTextContent(this.liste_contenu.get(i).getTimecodeFin());
      contenu.appendChild(timecode_fin);

      Element description = document.createElement(StructureXML.CONTENU_LISTE_ELEMENT_TIMECODE_DESCRIPTION);
      description.setTextContent(this.liste_contenu.get(i).getDescription());
      contenu.appendChild(description);

      liste_contenu.appendChild(contenu);
    }

    node.appendChild(liste_contenu);

    return node;
  }

}
