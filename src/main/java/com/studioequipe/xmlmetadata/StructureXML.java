package com.studioequipe.xmlmetadata;

/**
 * Indique le nom des différents node dans l'XML.<br>
 * Cela simplifiera leur utilisation.
 *
 * @author Edouard JEANJEAN <edouard128@hotmail.com>
 * @version 0.1.0
 */
public abstract class StructureXML {

  // Les unités de mesure:
  public final static String[] UNITE_POIDS = new String[]{"unite", "o"};
  public final static String[] UNITE_PRODONFEUR = new String[]{"unite", "bit"};
  public final static String[] UNITE_FREQUENCE_AUDIO = new String[]{"unite", "kHz"};
  public final static String[] UNITE_FREQUENCE_IMAGE = new String[]{"unite", "i/s"};
  public final static String[] UNITE_DEBIT = new String[]{"unite", "Mo/s"};
  public final static String[] UNITE_RESOLUTION = new String[]{"unite", "px"};

  // Les formats de données:
  public final static String[] FORMAT_TEXTE = new String[]{"format", "string"};
  public final static String[] FORMAT_ENTIER = new String[]{"format", "int"};
  public final static String[] FORMAT_TEMPS = new String[]{"format", "hh:mm:ss:ii"};

  // -- Nom des nodes: --
  /**
   * Nom du noeud racine.
   */
  public final static String NODE_RACINE = "fichier";

  /**
   * Informations sur le documents XML.
   */
  public final static String NODE_DOCUMENT = "document";

  /**
   * Informations générales sur le fichier (vidéo, audio, image, ...).
   */
  public final static String NODE_GENERALE = "generale";

  /**
   * Informations relative à l'image.
   */
  public final static String NODE_IMAGE = "image";
  public final static String NODE_AUDIO = "audio";
  public final static String NODE_SOUSTITRE = "sous_titre";
  public final static String NODE_RAPPORT_QC = "rapport_qc";
  public final static String NODE_TIMECODE = "timecode";
  public final static String NODE_CONTENU = "contenu";

  // -- Valeurs des noeuds: --
  /**
   * Pour la version de l'XML.
   */
  public final static String DOCUMENT_VERSION = "version";

  // Générale :
  public final static String GENERALE_FICHIER_LIER = "fichier_lie";
  // public final static String COMMUN_PRODUCTION = "production";
  public final static String GENERALE_TITRE = "titre";
  public final static String GENERALE_TYPE = "type";
  public final static String GENERALE_POIDS = "poids";
  public final static String GENERALE_CHECKSUM = "checksum";
  // public final static String COMMUN_INFORMATION = "information";

  // Image :
  public final static String IMAGE_CODEC = "codec";

  //public final static String IMAGE_CODEC_PRORES422HQ = "Apple Pro Res 422 HQ";
  public final static String IMAGE_RESOLUTION = "resolution";

  public final static String IMAGE_RESOLUTION_HAUTEUR = "hauteur";
  public final static String IMAGE_RESOLUTION_LARGEUR = "largeur";

  public final static String IMAGE_RATIO = "ratio";
  //public final static String IMAGE_RATIO_239 = "2.39";

  public final static String IMAGE_BALAYAGE = "balayage";
  // public final static String IMAGE_BALAYAGE_PROGRESSIF = "P";
  // public final static String IMAGE_BALAYAGE_ENTRELACE = "I";
  // public final static String IMAGE_BALAYAGE_PSF = "PsF";

  // public final static String IMAGE_WATERMARK = "watermark";
  // public final static String IMAGE_INFORMATION = "information";
  // Audio :
  public final static String AUDIO_CODEC = "codec";
  public final static String AUDIO_PROFONDEUR = "profondeur";
  public final static String AUDIO_FREQUENCE = "frequence";

  public final static String AUDIO_LISTE_PISTE_AUDIO = "liste_piste_audio";
  public final static String AUDIO_PISTE_AUDIO = "piste_audio";

  // public final static String AUDIO_NOMBRE_PISTE = "numberTrack";
  public final static String AUDIO_PISTE_AUDIO_NUMERO = "numero";
  public final static String AUDIO_PISTE_AUDIO_VERSION = "version";
  public final static String AUDIO_PISTE_AUDIO_MIXE = "mix";
  // public final static String AUDIO_CANAUX = "canaux";
  public final static String AUDIO_PISTE_AUDIO_CANAL = "canal";
  public final static String AUDIO_PISTE_AUDIO_SYSTEME_REPRODUCTION = "systeme_reproduction";
  public final static String AUDIO_PISTE_AUDIO_LOUDNESS = "loudness";

  // Sous-titre :
  public final static String SOUSTITRE_PRESENT = "present";
  // public final static String SOUSTITRE_NORME = "norme";
  public final static String SOUSTITRE_LANGUE = "langue";
  //public final static String SOUSTITRE_TYPE = "type";
  public final static String SOUSTITRE_PARTIEL = "partiel";
  //public final static String SOUSTITRE_INFORMATION = "information";
  public final static String SOUSTITRE_SME = "sme";

  // QC :
  /*public final static String QC_ACCEPTE = "accepted";
  public final static String QC_DEROULEMENT = "timeline";
  public final static String QC_REMARQUE = "remarks";*/
  // Timecode:
  public final static String TIMECODE_TIMECODE_DEBUT = "timecode_debut";
  public final static String TIMECODE_DUREE = "duree";
  public final static String TIMECODE_FRAMERATE = "framerate";
  public final static String TIMECODE_DROPFRAME = "dropframe";

  // Contenu :
  public final static String CONTENU_LISTE_CONTENU = "liste_contenu";
  public final static String CONTENU_LISTE_CONTENU_ELEMENT = "element";

  public final static String CONTENU_LISTE_ELEMENT_TIMECODE_DEBUT = "timecode_debut";
  public final static String CONTENU_LISTE_ELEMENT_TIMECODE_FIN = "timecode_fin";
  public final static String CONTENU_LISTE_ELEMENT_TIMECODE_DESCRIPTION = "description";

  /**
   * Si la réponse est positive.
   */
  public final static String OUI = "oui";

  /**
   * Si la réponse est négative.
   */
  public final static String NON = "non";
}
