package com.studioequipe.xmlmetadata.metadata;

import com.studioequipe.xmlmetadata.StructureXML;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Informations générale sur le fichier.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
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
   * @param generale Noeud "générale" venant du fichier XML.
   */
  public Generale(NodeList generale) {
    for (int i = 0; i < generale.getLength(); i++) {
      if (generale.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (generale.item(i).getNodeName()) {
          case StructureXML.GENERALE_FICHIER_LIER:
            this.fichier_lie = generale.item(i).getTextContent();
            break;

          case StructureXML.GENERALE_TYPE:
            this.type_fichier = generale.item(i).getTextContent();
            break;

          case StructureXML.GENERALE_POIDS:
            this.poids = generale.item(i).getTextContent();
            break;

          case StructureXML.GENERALE_TITRE:
            this.titre = generale.item(i).getTextContent();
            break;

          case StructureXML.GENERALE_CHECKSUM:
            this.checksum = generale.item(i).getTextContent();
            break;
        }
      }
    }
  }

  /**
   * Récupère le checksum du fichier;
   *
   * @return Checksum.
   */
  public String getChecksum() {
    return this.checksum;
  }

  /**
   * Récupère le fichier lié aux métadonnées
   *
   * @return Fichier lié.
   */
  public String getFichierLier() {
    return this.fichier_lie;
  }

  /**
   * Récupère le titre du projet.
   *
   * @return Titre.
   */
  public String getTitre() {
    return this.titre;
  }

  /**
   * Génère un XML avec les informations générales.
   *
   * @param document Fichier XML à générer.
   *
   * @return Noeud à ajouter au fichier XML à générer.
   *
   * @throws ParserConfigurationException Erreur d'analyse de la configuration.
   */
  public Element getXML(Document document) throws ParserConfigurationException {
    Element node = document.createElement(StructureXML.NODE_GENERALE);

    Element titre = document.createElement(StructureXML.GENERALE_TITRE);
    titre.setTextContent(this.titre);
    node.appendChild(titre);

    Element fichier_lie = document.createElement(StructureXML.GENERALE_FICHIER_LIER);
    fichier_lie.setTextContent(this.fichier_lie);
    node.appendChild(fichier_lie);

    Element type_fichier = document.createElement(StructureXML.GENERALE_TYPE);
    type_fichier.setTextContent(this.type_fichier);
    node.appendChild(type_fichier);

    Element poids = document.createElement(StructureXML.GENERALE_POIDS);
    poids.setTextContent(this.poids);
    node.appendChild(poids);

    Element checksum = document.createElement(StructureXML.GENERALE_CHECKSUM);
    checksum.setTextContent(this.checksum);
    node.appendChild(checksum);

    return node;
  }

  /**
   * Définit le checksum.
   *
   * @param checksum Checksum.
   */
  public void setChecksum(String checksum) {
    this.checksum = checksum;
  }

  /**
   * Définit le fichier lié.
   *
   * @param fichier_lie Nom du fichier lié.
   */
  public void setFichierLie(String fichier_lie) {
    this.fichier_lie = fichier_lie;
  }

  /**
   * Définit le poids.
   *
   * @param poids Poids.
   */
  public void setPoids(String poids) {
    this.poids = poids;
  }

  /**
   * Définit le titre.
   *
   * @param titre Titre.
   */
  public void setTitre(String titre) {
    this.titre = titre;
  }

  /**
   * Définit le type de fichier.
   *
   * @param type_fichier Type de fichier.
   */
  public void setTypeFichier(String type_fichier) {
    this.type_fichier = type_fichier;
  }

}
