package com.studioequipe.xmlmetadata.metadata;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Informations générale sur le fichier.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class Generale {

  // private String version; // Version s'il y a avec et sans haïku par exemple.
  // private ArrayList<String> liste_titre; //Liste des différents nom du film.
  // private String nom_projet;
  // private int id_projet;
  // private String production;
  // private int id_production;
  // private String date_creation_fichier; // Quand le fichier a été créé.
  // private String mode_checksum; // SI MD5 ou autre.
  /**
   * Indique le fichier lié aux métadonnées.
   */
  private String fichier_lie;

  /**
   * Indique le type de fichier que c'est : vidéo, audio, image, ...
   */
  private String type_fichier;

  /**
   * Poids du fichier (n'importe quel format.).
   */
  private String poids;

  /**
   * Cela peut être le titre du projet mais dans le cas d'une série c'est aussi
   * le numéro d'épisode.
   */
  private String titre;

  /**
   * MD5 du fichier.
   */
  private String checksum;

  /**
   * Pour écrire les informations.
   */
  public Generale() {
  }

  /**
   * Récupère les informations de l'XML.
   *
   * @param general
   */
  public Generale(NodeList general) {
    for (int i = 0; i < general.getLength(); i++) {
      if (general.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (general.item(i).getNodeName()) {
          case "fichier_lie":
            this.fichier_lie = general.item(i).getTextContent();
            break;

          case "type":
            this.type_fichier = general.item(i).getTextContent();
            break;

          case "poids":
            this.poids = general.item(i).getTextContent();
            break;

          case "titre":
            this.titre = general.item(i).getTextContent();
            break;

          case "checksum":
            this.checksum = general.item(i).getTextContent();
            break;
        }
      }
    }
  }

  /**
   * Génère un XML avec les informations générales.
   *
   * @param document
   * @return
   *
   * @throws ParserConfigurationException
   */
  public Element getXML(Document document) throws ParserConfigurationException {
    Element node = document.createElement("general");

    Element titre = document.createElement("titre");
    titre.setTextContent(this.titre);
    node.appendChild(titre);

    Element fichier_lie = document.createElement("fichier_lie");
    fichier_lie.setTextContent(this.fichier_lie);
    node.appendChild(fichier_lie);

    Element type_fichier = document.createElement("type_fichier");
    type_fichier.setTextContent(this.type_fichier);
    node.appendChild(type_fichier);

    Element poids = document.createElement("poids");
    poids.setTextContent(this.poids);
    node.appendChild(poids);

    Element checksum = document.createElement("checksum");
    checksum.setTextContent(this.checksum);
    node.appendChild(checksum);

    return node;
  }

  /**
   *
   * @param fichier_lie
   */
  public void setFichierLie(String fichier_lie) {
    this.fichier_lie = fichier_lie;
  }

  /**
   *
   * @param type_fichier
   */
  public void setTypeFichier(String type_fichier) {
    this.type_fichier = type_fichier;
  }

  /**
   *
   * @param poids
   */
  public void setPoids(String poids) {
    this.poids = poids;
  }

  /**
   *
   * @param titre
   */
  public void setTitre(String titre) {
    this.titre = titre;
  }

  /**
   *
   * @param checksum
   */
  public void setChecksum(String checksum) {
    this.checksum = checksum;
  }

}
