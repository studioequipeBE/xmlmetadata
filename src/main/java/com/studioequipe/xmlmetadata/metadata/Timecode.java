package com.studioequipe.xmlmetadata.metadata;

import com.studioequipe.xmlmetadata.StructureXML;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Informations timecode sur le projet.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class Timecode {

  /**
   * Framerate du fichier.
   */
  private String framerate;

  /**
   * Si le timecode en 29,976 est en dropframe ou non.
   */
  private boolean dropframe;

  /**
   * Timecode début.
   */
  private String timecode_debut;

  /**
   * Durée en timecode SMTPE.
   */
  private String duree;

  /**
   * Pour écrire les informations.
   */
  public Timecode() {
  }

  /**
   * Récupère les informations de l'XML.
   *
   * @param timecode
   */
  public Timecode(NodeList timecode) {
    for (int i = 0; i < timecode.getLength(); i++) {
      if (timecode.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (timecode.item(i).getNodeName()) {
          case StructureXML.TIMECODE_TIMECODE_DEBUT:
            this.timecode_debut = timecode.item(i).getTextContent();
            break;

          case StructureXML.TIMECODE_FRAMERATE:
            this.framerate = timecode.item(i).getTextContent();
            break;

          case StructureXML.TIMECODE_DUREE:
            this.duree = timecode.item(i).getTextContent();
            break;

          case StructureXML.TIMECODE_DROPFRAME:
            this.dropframe = timecode.item(i).getTextContent().equals(StructureXML.OUI);
            break;
        }
      }
    }
  }

  /**
   * Génère un XML des informations de timecode.
   *
   * @param document XML à se baser.
   * @return XML.
   *
   * @throws ParserConfigurationException
   */
  public Element getXML(Document document) throws ParserConfigurationException {
    Element node = document.createElement(StructureXML.NODE_TIMECODE);

    Element timecode_debut = document.createElement(StructureXML.TIMECODE_TIMECODE_DEBUT);
    timecode_debut.setTextContent(this.timecode_debut);
    node.appendChild(timecode_debut);

    Element framerate = document.createElement(StructureXML.TIMECODE_FRAMERATE);
    framerate.setTextContent(this.framerate);
    node.appendChild(framerate);

    Element dropframe = document.createElement(StructureXML.TIMECODE_DROPFRAME);
    dropframe.setTextContent((this.dropframe ? StructureXML.OUI : StructureXML.NON));
    node.appendChild(dropframe);

    Element duree = document.createElement(StructureXML.TIMECODE_DUREE);
    duree.setTextContent(this.duree);
    node.appendChild(duree);

    return node;
  }

  /**
   * Définit le timecode début.
   *
   * @param timecode_debut Timecode début.
   */
  public void setTimecodeDebut(String timecode_debut) {
    this.timecode_debut = timecode_debut;
  }

  /**
   * Définit la durée.
   *
   * @param duree
   */
  public void setDuree(String duree) {
    this.duree = duree;
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
   * Durée du fichier.
   *
   * @return
   */
  public String getDuree() {
    return this.duree;
  }

  /**
   * Définit le framerate.
   *
   * @param framerate Framerate.
   */
  public void setFramerate(String framerate) {
    this.framerate = framerate;
  }

  /**
   * Récupère le framerate.
   *
   * @return Framerate.
   */
  public String getFramerate() {
    return this.framerate;
  }
}
