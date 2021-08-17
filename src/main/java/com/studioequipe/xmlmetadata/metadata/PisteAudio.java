package com.studioequipe.xmlmetadata.metadata;

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
  private String mix;

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

  public PisteAudio(int numero, String version, String mix, String systeme_reproduction, String canal, String loudness) {
    this.numero = numero;
    this.version = version;
    this.mix = mix;
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
  public String getMix() {
    return this.mix;
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
