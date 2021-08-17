package com.studioequipe.xmlmetadata.metadata;

import com.studioequipe.xmlmetadata.StructureXML;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Les pistes audios dans la partie audio.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class PisteAudio {

  /**
   * Numéro de piste.
   */
  private int numero;

  /**
   * Version de l'audio.
   */
  private String version;

  /**
   * Mix de l'audio.
   */
  private String mixe;

  /**
   * Système de reproduction.
   */
  private String systeme_reproduction;

  /**
   * Canal concerné.
   */
  private String canal;

  /**
   * Le loudness.
   */
  private String loudness;

  public PisteAudio(NodeList piste_audio) {
    for (int i = 0; i < piste_audio.getLength(); i++) {
      if (piste_audio.item(i).getNodeType() == Node.ELEMENT_NODE) {
        switch (piste_audio.item(i).getNodeName()) {
          case StructureXML.AUDIO_PISTE_AUDIO_NUMERO:
            numero = Integer.parseInt(piste_audio.item(i).getTextContent());
            break;

          case StructureXML.AUDIO_PISTE_AUDIO_VERSION:
            version = piste_audio.item(i).getTextContent();
            break;

          case StructureXML.AUDIO_PISTE_AUDIO_MIXE:
            mixe = piste_audio.item(i).getTextContent();
            break;

          case StructureXML.AUDIO_PISTE_AUDIO_SYSTEME_REPRODUCTION:
            systeme_reproduction = piste_audio.item(i).getTextContent();
            break;

          case StructureXML.AUDIO_PISTE_AUDIO_CANAL:
            canal = piste_audio.item(i).getTextContent();
            break;

          case StructureXML.AUDIO_PISTE_AUDIO_LOUDNESS:
            loudness = piste_audio.item(i).getTextContent();
            break;
        }
      }
    }
  }

  public PisteAudio(int numero, String version, String mixe, String systeme_reproduction, String canal, String loudness) {
    this.numero = numero;
    this.version = version;
    this.mixe = mixe;
    this.systeme_reproduction = systeme_reproduction;
    this.canal = canal;
    this.loudness = loudness;
  }

  /**
   * Récupère le numéro de piste.
   *
   * @return
   */
  public int getNumero() {
    return this.numero;
  }

  /**
   * Récupère la version audio.
   *
   * @return
   */
  public String getVersion() {
    return this.version;
  }

  /**
   * Récupère le mix.
   *
   * @return
   */
  public String getMixe() {
    return this.mixe;
  }

  /**
   * Récupère le système de reproduction.
   *
   * @return
   */
  public String getSystemeReproduction() {
    return this.systeme_reproduction;
  }

  /**
   * Récupère le canal de la piste.
   *
   * @return
   */
  public String getCanal() {
    return this.canal;
  }

  /**
   * Récupère le loudness de la piste.
   *
   * @return
   */
  public String getLoudness() {
    return this.loudness;
  }
}
