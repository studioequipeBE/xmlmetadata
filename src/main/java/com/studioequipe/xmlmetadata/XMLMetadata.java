package com.studioequipe.xmlmetadata;

import com.studioequipe.xmlmetadata.metadata.Audio;
import com.studioequipe.xmlmetadata.metadata.Contenu;
import com.studioequipe.xmlmetadata.metadata.Generale;
import com.studioequipe.xmlmetadata.metadata.Image;
import com.studioequipe.xmlmetadata.metadata.RapportQC;
import com.studioequipe.xmlmetadata.metadata.SousTitre;
import com.studioequipe.xmlmetadata.metadata.Timecode;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Ce fichier créé un XML avec les métadonnées d'un fichier vidéo (audio, ...) +
 * détail le contenu des pistes audio ainsi que le "contenu" utilisé par les
 * rapports QC.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class XMLMetadata {

  /**
   * Si on veut lire le contenu.
   */
  public final static int READ = 0;

  /**
   * Si on veut écrire un contenu.
   */
  public final static int WRITE = 1;

  /**
   * Le fichier XML qu'on traite.
   */
  private File fichier_xml;

  /**
   * Le mode qu'on traite.
   */
  private int mode;

  /**
   * La version de l'XML.
   */
  private String XMLversion;

  /**
   * Les informations générale (commune à l'image, audio et sous-titre).
   */
  private Generale general;

  /**
   * Les informations relative à l'image.
   */
  private Image image;

  /**
   * Les informations relative à l'audio.
   */
  private Audio audio;

  /**
   * Les informations relative aux sous-titres.
   */
  private SousTitre sous_titre;

  /**
   * Les informations relative au timecode.
   */
  private Timecode timecode;

  /**
   * Les informations relative au contenu du fichier.
   */
  private Contenu contenu;

  /**
   * Le rapport QC.
   */
  private RapportQC rapport_qc;

  /**
   * Construit des métadonnées.
   *
   * @param fichier_xml Le fichier à lire ou écrire.
   * @param mode Définit si on écrit ou lit le fichier.
   *
   * @throws ModeNotFoundException
   * @throws ParserConfigurationException
   * @throws SAXException
   * @throws IOException
   */
  public XMLMetadata(File fichier_xml, int mode) throws ModeNotFoundException, ParserConfigurationException, SAXException, IOException {

    this.fichier_xml = fichier_xml;

    // On lit les données :
    if (READ == mode) {
      extract();
    } // On écrit les données :
    else if (WRITE == mode) {
      this.XMLversion = "0.0.1";
      this.general = new Generale();
      this.image = new Image();
      this.audio = new Audio();
      this.sous_titre = new SousTitre();
      this.contenu = new Contenu();
      this.rapport_qc = new RapportQC();
    } // Le mode est inconnu :
    else {
      throw new ModeNotFoundException();
    }
    this.mode = mode;
  }

  /**
   * Récupère les informations sur l'audio.
   *
   * @return
   */
  public Audio getAudio() {
    return this.audio;
  }

  /**
   * Récupère les informations sur l'image.
   *
   * @return
   */
  public Image getImage() {
    return this.image;
  }

  /**
   * Récupère les informations générale.
   *
   * @return
   */
  public Generale getGeneral() {
    return this.general;
  }

  /**
   * Récupère les informations sur les sous-titres.
   *
   * @return
   */
  public SousTitre getSousTitre() {
    return this.sous_titre;
  }

  /**
   * Récupère les informations de timecode.
   *
   * @return
   */
  public Timecode getTimecode() {
    return this.timecode;
  }

  /**
   * Récupère les informations sur le contenu.
   *
   * @return
   */
  public Contenu getContenu() {
    return this.contenu;
  }

  /**
   * Récupère le rapport QC lié au fichier.
   *
   * @return
   */
  public RapportQC getRapportQC() {
    return this.rapport_qc;
  }

  /**
   * Récupère les informations de l'XML.
   */
  private void extract() throws ParserConfigurationException, SAXException, IOException {
    Element racine;
    NodeList racineNoeuds;

    this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.fichier_xml);

    racine = this.document.getDocumentElement();
    racineNoeuds = racine.getChildNodes();

    for (int i = 0; i < racineNoeuds.getLength(); i++) {
      if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (racineNoeuds.item(i).getNodeName()) {
          case "general":
            System.out.println("extract : general");
            this.general = new Generale((NodeList) racineNoeuds.item(i).getChildNodes());
            break;
          case "image":
            System.out.println("extract : image");
            this.image = new Image((NodeList) racineNoeuds.item(i).getChildNodes());
            break;
          case "audio":
            System.out.println("extract : audio");
            this.audio = new Audio((NodeList) racineNoeuds.item(i).getChildNodes());
            break;
          case "soustitre":
            System.out.println("extract : soustitre");
            this.sous_titre = new SousTitre((NodeList) racineNoeuds.item(i).getChildNodes());
            break;
          case "rapport_qc":
            System.out.println("extract : qc");
            this.rapport_qc = new RapportQC((NodeList) racineNoeuds.item(i).getChildNodes());
            break;
          case "timecode":
            System.out.println("extract : timecode");
            this.timecode = new Timecode((NodeList) racineNoeuds.item(i).getChildNodes());
            break;

          case "liste_contenu":
            System.out.println("extract : contenu");
            this.contenu = new Contenu((NodeList) racineNoeuds.item(i).getChildNodes());
            break;
          /*case "document":
            System.out.println("extract : document");
            //this.documents = (NodeList) racineNoeuds.item(i).getChildNodes();
            break;*/
        }
      }
    }

  }

  /**
   * Récupère la version de l'XML.
   *
   * @return
   */
  public String getXMLVersion() {
    return this.XMLversion;
  }

  /**
   * Permet de lire ou écrire un document XML.
   */
  private Document document;

  /**
   * Ecrit le fichier XML.
   *
   * @throws javax.xml.parsers.ParserConfigurationException
   * @throws javax.xml.transform.TransformerException
   */
  public void close() throws ParserConfigurationException, TransformerException {

    Element racine;

    // création d'un Document
    this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

    // création de l'Element racine
    racine = document.createElement("fichier");
    document.appendChild(racine);

    Element documents = document.createElement("document");

    // Ajoute tous les enfants de "commun" avec comme valeur par défaut "non renseigné".
    documents.appendChild(addChild("version", "0.9"));

    racine.appendChild(document.createComment("Information sur le document XML."));
    racine.appendChild(documents);

    racine.appendChild(this.general.getXML(document));
    racine.appendChild(this.image.getXML(document));
    racine.appendChild(this.audio.getXML(document));
    racine.appendChild(this.sous_titre.getXML(document));
    racine.appendChild(this.timecode.getXML(document));
    racine.appendChild(this.contenu.getXML(document));
    racine.appendChild(this.rapport_qc.getXML(document));

    // Ecrit l'XML.
    Transformer transformer = TransformerFactory.newInstance().newTransformer();

    //prologue
    transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

    //formatage
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

    //sortie
    transformer.transform(new DOMSource(document), new StreamResult(this.fichier_xml));
  }

  /**
   * Définit une balise enfant.
   *
   * @param nom
   * @param valeur
   * @return
   * @throws ParserConfigurationException
   */
  private Element addChild(String nom, String valeur) throws ParserConfigurationException {
    Element node = this.document.createElement(nom);
    node.appendChild(this.document.createTextNode(valeur));
    return node;
  }

  /**
   * Définit les informations de l'image.
   *
   * @param image Informations sur l'image.
   */
  public void setImage(Image image) {
    this.image = image;
  }

  /**
   * Définit les informations de timecode.
   *
   * @param timecode Les informations de timecode.
   */
  public void setTimecode(Timecode timecode) {
    this.timecode = timecode;
  }

  /**
   * Définit les informations sur l'audio.
   *
   * @param audio Les informations sur l'audio.
   */
  public void setAudio(Audio audio) {
    this.audio = audio;
  }

  /**
   * Définit les informations générales.
   *
   * @param general Les informations générale.
   */
  public void setGeneral(Generale general) {
    this.general = general;
  }

  /**
   * Définit le contenu du fichier.
   *
   * @param contenu Le contenu.
   */
  public void setContenu(Contenu contenu) {
    this.contenu = contenu;
  }

  /**
   * Définit le rapport QC.
   *
   * @param rapport_qc Le rapport.
   */
  public void setRapportQC(RapportQC rapport_qc) {
    this.rapport_qc = rapport_qc;
  }
}
