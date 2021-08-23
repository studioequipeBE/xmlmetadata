package com.studioequipe.xmlmetadata.metadata;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Définit ce qui doit se trouver dans les fichiers métadonnées.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
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
   * @param node Le noeud avec les informations à extraire.
   */
  public Metadata(NodeList node) {
    set(node);
  }

  /**
   * Définit les informations de la classe sur base du node reçu en paramètre.
   *
   * @param node Le noeud avec les informations à extraire.
   */
  public abstract void set(NodeList node);

  /**
   * Récupère le contenu sous forme de document XML.
   *
   * @param document Fichier XML à générer.
   *
   * @return Document XML.
   *
   * @throws ParserConfigurationException Erreur d'analyse de la configuration.
   */
  public abstract Element getXML(Document document) throws ParserConfigurationException;
}
