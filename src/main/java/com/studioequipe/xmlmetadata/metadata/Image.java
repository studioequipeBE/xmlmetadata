package com.studioequipe.xmlmetadata.metadata;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Informations sur l'image du fichier.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class Image extends Metadata {

  /**
   * Le codec image.
   */
  private String codec;

  /**
   * Hauteur de l'image.
   */
  private int hauteur;

  /**
   * Largeur de l'image.
   */
  private int largeur;

  /**
   * Type de balayage de l'image.
   */
  private String balayage;

  /**
   * Ratio de l'image.
   */
  private String ratio;

  // Informations possible à ajouter.
  // private boolean oar; // Indique si c'est le ratio original du film.
  // private boolean tci; // Indique si un timecide est brulé à l'image.
  // private boolean textless; // Indique si des fonds neutres sont présents.
  // private String watermark;
  // final Element couleur_coefficient_matriciel = document.createElement("couleurCoefficientMatriciel");
  // final Element couleur_transfert = document.createElement("couleurTransfert");
  // final Element echantillonnage_couleur = document.createElement("echantillonnageCouleur");
  // final Element espace_couleur = document.createElement("colorSpace");
  /**
   * Définir les informations image.
   */
  public Image() {
    super();
  }

  /**
   * Récupère les informations d'un document XML.
   *
   * @param image
   */
  public Image(NodeList image) {
    super(image);
  }

  /**
   * Définit un XML avec les informations images.
   *
   * @param document
   * @return
   * @throws ParserConfigurationException
   */
  @Override
  public Element getXML(Document document) throws ParserConfigurationException {
    Element node = document.createElement("image");

    Element codec = document.createElement("codec");
    codec.setTextContent(this.codec);
    node.appendChild(codec);

    Element balayage = document.createElement("balayage");
    balayage.setTextContent(this.balayage);
    node.appendChild(balayage);

    Element resolution = document.createElement("resolution");
    {
      Element largeur = document.createElement("largeur");
      largeur.setTextContent(this.largeur + "");
      resolution.appendChild(largeur);

      Element hauteur = document.createElement("hauteur");
      hauteur.setTextContent(this.hauteur + "");
      resolution.appendChild(hauteur);
    }

    node.appendChild(resolution);

    Element ratio = document.createElement("ratio");
    ratio.setTextContent(this.ratio);
    node.appendChild(ratio);

    return node;
  }

  /**
   * Récupère le codec.
   *
   * @return
   */
  public String getCodec() {
    return this.codec;
  }

  /**
   * Ratio de l'image.
   *
   * @return
   */
  public String getRatio() {
    return this.ratio;
  }

  /**
   * Résolution en largeur et hauteur.
   *
   * @return
   */
  public String getResolution() {
    return this.largeur + "x" + this.hauteur;
  }

  /**
   * Définit le codec image.
   *
   * @param codec
   */
  public void setCodec(String codec) {
    this.codec = codec;
  }

  /**
   * Définit la hauteur de l'image.
   *
   * @param hauteur
   */
  public void setHauteur(int hauteur) {
    this.hauteur = hauteur;
  }

  /**
   * Définit la largeur de l'image.
   *
   * @param largeur
   */
  public void setLargeur(int largeur) {
    this.largeur = largeur;
  }

  /**
   * Définit le balayage de l'image.
   *
   * @param balayage Le balayage.
   */
  public void setBalayage(String balayage) {
    this.balayage = balayage;
  }

  /**
   * Définit le ratio.
   *
   * @param ratio
   */
  public void setRatio(String ratio) {
    this.ratio = ratio;
  }

  @Override
  public void set(NodeList image) {
    for (int i = 0; i < image.getLength(); i++) {
      if (image.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (image.item(i).getNodeName()) {
          case "codec":
            this.codec = image.item(i).getTextContent();
            break;

          case "ratio":
            this.ratio = image.item(i).getTextContent();
            break;

          case "resolution":
            NodeList resolution = image.item(i).getChildNodes();

            for (int j = 0; j < resolution.getLength(); j++) {
              if (resolution.item(j).getNodeType() == Node.ELEMENT_NODE) {
                switch (resolution.item(j).getNodeName()) {
                  case "largeur":
                    this.largeur = Integer.parseInt(resolution.item(j).getTextContent());
                    break;
                  case "hauteur":
                    this.hauteur = Integer.parseInt(resolution.item(j).getTextContent());
                    break;
                }
              }

            }
            break;
        }
      }
    }
  }
}
