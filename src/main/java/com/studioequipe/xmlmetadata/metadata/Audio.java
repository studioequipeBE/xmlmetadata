package com.studioequipe.xmlmetadata.metadata;

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
  private int echantillonnage;

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
          case "codec":
            this.codec = audio.item(i).getTextContent();
            break;

          case "echantillonnage":
            this.echantillonnage = Integer.parseInt(audio.item(i).getTextContent());
            break;

          case "profondeur":
            this.profondeur = Integer.parseInt(audio.item(i).getTextContent());
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
    Element node = document.createElement("audio");

    Element codec = document.createElement("codec");
    codec.setTextContent(this.codec);
    node.appendChild(codec);

    Element profondeur = document.createElement("profondeur");
    profondeur.setTextContent(this.profondeur + "");
    node.appendChild(profondeur);

    Element echantillonnage = document.createElement("echantillonnage");
    echantillonnage.setTextContent(this.echantillonnage + "");
    node.appendChild(echantillonnage);

    Element piste_audio = document.createElement("liste_piste_audio");

    // AJoute toutes les pistes audios :
    for (int i = 0; i < this.liste_piste_audio.size(); i++) {
      Element piste_audio_courante = document.createElement("piste_audio");

      Element numero = document.createElement("numero");
      numero.setTextContent(this.liste_piste_audio.get(i).getNumero() + "");
      piste_audio_courante.appendChild(numero);

      Element version = document.createElement("version");
      version.setTextContent(this.liste_piste_audio.get(i).getVersion());
      piste_audio_courante.appendChild(version);

      Element mix = document.createElement("mix");
      mix.setTextContent(this.liste_piste_audio.get(i).getMix());
      piste_audio_courante.appendChild(mix);

      Element loudness = document.createElement("loudness");
      loudness.setTextContent(this.liste_piste_audio.get(i).getLoudness());
      piste_audio_courante.appendChild(loudness);

      Element systeme_reproduction = document.createElement("systeme_reproduction");
      systeme_reproduction.setTextContent(this.liste_piste_audio.get(i).getSystemeReproduction());
      piste_audio_courante.appendChild(systeme_reproduction);

      Element canal = document.createElement("canal");
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
   * @param echantillonnage
   */
  public void setEchantillonnage(int echantillonnage) {
    this.echantillonnage = echantillonnage;
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
