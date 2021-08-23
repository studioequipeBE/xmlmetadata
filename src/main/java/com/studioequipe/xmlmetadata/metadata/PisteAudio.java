package com.studioequipe.xmlmetadata.metadata;

import com.studioequipe.xmlmetadata.StructureXML;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Les pistes audios dans la partie audio.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
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

  /**
   * Construit une piste audio sur base du noeud reçu.
   *
   * @param piste_audio Le noeud avec la piste audio.
   */
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

  /**
   * Définit une piste audio selon les informations indiquées.
   *
   * @param numero Numéro de piste.
   * @param version Version : VO, VF, ...
   * @param mixe Mixe : BR, TV, ...
   * @param systeme_reproduction Système de reproduction : 2.0, 5.1, ...
   * @param canal Canal audio : L, R, C, ...
   * @param loudness Loudness en dBFs.
   */
  public PisteAudio(int numero, String version, String mixe, String systeme_reproduction, String canal, String loudness) {
    this.numero = numero;
    this.version = version;
    this.mixe = mixe;
    this.systeme_reproduction = systeme_reproduction;
    this.canal = canal;
    this.loudness = loudness;
  }

  /**
   * Récupère le canal de la piste.
   *
   * @return Canal.
   */
  public String getCanal() {
    return this.canal;
  }

  /**
   * Récupère le loudness de la piste.
   *
   * @return Loudness.
   */
  public String getLoudness() {
    return this.loudness;
  }

  /**
   * Récupère le mix.
   *
   * @return Mixe.
   */
  public String getMixe() {
    return this.mixe;
  }

  /**
   * Récupère le numéro de piste.
   *
   * @return Numéro de piste.
   */
  public int getNumero() {
    return this.numero;
  }

  /**
   * Récupère le système de reproduction.
   *
   * @return Système de production.
   */
  public String getSystemeReproduction() {
    return this.systeme_reproduction;
  }

  /**
   * Récupère la version audio.
   *
   * @return Version.
   */
  public String getVersion() {
    return this.version;
  }
}
