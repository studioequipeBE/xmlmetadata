package com.studioequipe.xmlmetadata.metadata;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Définit ce qui doit se trouver dans les fichiers métadonnées.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public abstract class Metadata {

  /**
   * Constructeur vide pour définir les informations.
   */
  public Metadata() {
  }

  /**
   * Récupères les informations depuis l'XML.
   *
   * @param node
   */
  public Metadata(NodeList node) {
    set(node);
  }

  /**
   * Définit les informations de la classe sur base du node reçu en paramètre.
   *
   * @param node
   * @return
   */
  public abstract void set(NodeList node);

  /**
   * Récupère le contenu sous forme de document XML.
   *
   * @param document
   * @return Document XML.
   * @throws javax.xml.parsers.ParserConfigurationException
   */
  public abstract Element getXML(Document document) throws ParserConfigurationException;
}
