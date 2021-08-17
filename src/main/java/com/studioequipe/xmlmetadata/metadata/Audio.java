package com.studioequipe.xmlmetadata.metadata;

import com.studioequipe.xmlmetadata.StructureXML;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * L'audio du fichier.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class Audio {

  /**
   * Les pistes audios du fichier.
   */
  private ArrayList<PisteAudio> liste_piste_audio;

  /**
   * Codec audio.
   */
  private String codec;

  /**
   * Fréquence d'échantillonnage audio.
   */
  private int frequence;

  /**
   * Profondeur (en bit) de l'audio.
   */
  private int profondeur;

  /**
   * Pour écrire les informations.
   */
  public Audio() {
    this.liste_piste_audio = new ArrayList<PisteAudio>();
  }

  /**
   * Récupère les informations de l'XML.
   *
   * @param audio L'XML avec les informations audios.
   */
  public Audio(NodeList audio) {
    this.liste_piste_audio = new ArrayList<PisteAudio>();

    for (int i = 0; i < audio.getLength(); i++) {
      if (audio.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (audio.item(i).getNodeName()) {
          case StructureXML.AUDIO_CODEC:
            this.codec = audio.item(i).getTextContent();
            break;

          case StructureXML.AUDIO_FREQUENCE:
            this.frequence = Integer.parseInt(audio.item(i).getTextContent());
            break;

          case StructureXML.AUDIO_PROFONDEUR:
            this.profondeur = Integer.parseInt(audio.item(i).getTextContent());
            break;

          case StructureXML.AUDIO_LISTE_PISTE_AUDIO:
            NodeList liste = audio.item(i).getChildNodes();
            for (int j = 0; j < liste.getLength(); j++) {
              if (liste.item(j).getNodeType() == Node.ELEMENT_NODE) {
                switch (liste.item(j).getNodeName()) {
                  case StructureXML.AUDIO_PISTE_AUDIO:
                    this.liste_piste_audio.add(new PisteAudio(liste.item(j).getChildNodes()));
                    break;
                }
              }
            }
            break;
        }
      }
    }

  }

  /**
   * Ajoute une piste audio.
   *
   * @param piste_audio
   */
  public void addPisteAudio(PisteAudio piste_audio) {
    this.liste_piste_audio.add(piste_audio);
  }

  /**
   * Récupère sous forme d'XML les informations de l'audio.
   *
   * @param document
   * @return
   * @throws ParserConfigurationException
   */
  public Element getXML(Document document) throws ParserConfigurationException {
    Element node = document.createElement(StructureXML.NODE_AUDIO);

    Element codec = document.createElement(StructureXML.AUDIO_CODEC);
    codec.setTextContent(this.codec);
    node.appendChild(codec);

    Element profondeur = document.createElement(StructureXML.AUDIO_PROFONDEUR);
    profondeur.setTextContent(this.profondeur + "");
    node.appendChild(profondeur);

    Element frequence = document.createElement(StructureXML.AUDIO_FREQUENCE);
    frequence.setTextContent(this.frequence + "");
    node.appendChild(frequence);

    Element piste_audio = document.createElement(StructureXML.AUDIO_LISTE_PISTE_AUDIO);

    // AJoute toutes les pistes audios :
    for (int i = 0; i < this.liste_piste_audio.size(); i++) {
      Element piste_audio_courante = document.createElement(StructureXML.AUDIO_PISTE_AUDIO);

      Element numero = document.createElement(StructureXML.AUDIO_PISTE_AUDIO_NUMERO);
      numero.setTextContent(this.liste_piste_audio.get(i).getNumero() + "");
      piste_audio_courante.appendChild(numero);

      Element version = document.createElement(StructureXML.AUDIO_PISTE_AUDIO_VERSION);
      version.setTextContent(this.liste_piste_audio.get(i).getVersion());
      piste_audio_courante.appendChild(version);

      Element mixe = document.createElement(StructureXML.AUDIO_PISTE_AUDIO_MIXE);
      mixe.setTextContent(this.liste_piste_audio.get(i).getMixe());
      piste_audio_courante.appendChild(mixe);

      Element loudness = document.createElement(StructureXML.AUDIO_PISTE_AUDIO_LOUDNESS);
      loudness.setTextContent(this.liste_piste_audio.get(i).getLoudness());
      piste_audio_courante.appendChild(loudness);

      Element systeme_reproduction = document.createElement(StructureXML.AUDIO_PISTE_AUDIO_SYSTEME_REPRODUCTION);
      systeme_reproduction.setTextContent(this.liste_piste_audio.get(i).getSystemeReproduction());
      piste_audio_courante.appendChild(systeme_reproduction);

      Element canal = document.createElement(StructureXML.AUDIO_PISTE_AUDIO_CANAL);
      canal.setTextContent(this.liste_piste_audio.get(i).getCanal());
      piste_audio_courante.appendChild(canal);

      piste_audio.appendChild(piste_audio_courante);
    }

    node.appendChild(piste_audio);

    return node;
  }

  /**
   * Définit le codec audio.
   *
   * @param codec
   */
  public void setCodec(String codec) {
    this.codec = codec;
  }

  /**
   * Définit la fréquence d'échantillonnage de l'audio (en Hz ou kHz).
   *
   * @param frequence
   */
  public void setFrequence(int frequence) {
    this.frequence = frequence;
  }

  /**
   * Définit la profondeur (en bit) de l'audio.
   *
   * @param profondeur
   */
  public void setProfondeur(int profondeur) {
    this.profondeur = profondeur;
  }
}
