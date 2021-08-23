package com.studioequipe.xmlmetadata;

import com.studioequipe.xmlmetadata.metadata.Audio;
import com.studioequipe.xmlmetadata.metadata.Contenu;
import com.studioequipe.xmlmetadata.metadata.ContenuElement;
import com.studioequipe.xmlmetadata.metadata.Generale;
import com.studioequipe.xmlmetadata.metadata.Image;
import com.studioequipe.xmlmetadata.metadata.PisteAudio;
import com.studioequipe.xmlmetadata.metadata.Timecode;
import java.io.File;
import java.util.ArrayList;

/**
 * Main pour les tests.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public class Main {

  public static void main(String[] args) {
    try {
      XMLMetadata metadata_write = new XMLMetadata(new File("/Users/mp-dailies/Desktop/metadata.xml"), XMLMetadata.WRITE);
      Image image = new Image();

      image.setCodec("Apple Pro Res 422 HQ");
      image.setHauteur(1080);
      image.setLargeur(1920);
      image.setBalayage("p");

      metadata_write.setImage(image);

      Timecode timecode = new Timecode();
      timecode.setTimecodeDebut("09:59:50:00");
      timecode.setFramerate("24");
      timecode.setDuree("01:50:00:00");

      Audio audio = new Audio();
      audio.setCodec("PCM");
      audio.setFrequence(48000);
      audio.setProfondeur(24);

      audio.addPisteAudio(new PisteAudio(1, "VO", "BR", "LtRt", "L", "-23dbFs"));
      audio.addPisteAudio(new PisteAudio(2, "VO", "BR", "LtRt", "R", "-23dbFs"));

      audio.addPisteAudio(new PisteAudio(3, "VI", "BR", "LtRt", "L", "-23dbFs"));
      audio.addPisteAudio(new PisteAudio(4, "VI", "BR", "LtRt", "R", "-23dbFs"));

      metadata_write.setAudio(audio);

      metadata_write.setTimecode(timecode);

      Generale general = new Generale();
      general.setChecksum("145245214521478521");
      general.setFichierLie("fichier.mov");
      general.setPoids("198 Go");
      general.setTypeFichier("video");
      general.setTitre("Meilleur film");
      metadata_write.setGeneral(general);

      Contenu contenu = new Contenu();

      contenu.addContenu(new ContenuElement("10:00:00:00", "11:00:00:00", "Film"));
      contenu.addContenu(new ContenuElement("11:00:01:00", "11:00:05:00", "Fond neutre"));

      metadata_write.setContenu(contenu);

      metadata_write.close();

      XMLMetadata metadata_read = new XMLMetadata(new File("/Users/mp-dailies/Desktop/metadata.xml"), XMLMetadata.READ);
      System.out.println("Framerate : " + metadata_read.getTimecode().getFramerate());
      System.out.println("Codec image: " + metadata_read.getImage().getCodec());
      System.out.println("Résolution : " + metadata_read.getImage().getResolution());
      System.out.println("Timecode début : " + metadata_read.getTimecode().getTimecodeDebut());

      ArrayList<ContenuElement> liste_contenu = metadata_read.getContenu().getListe();

      for (int i = 0; i < liste_contenu.size(); i++) {
        System.out.println("* C" + i + " : " + liste_contenu.get(i).getTimecodeDebut() + " - " + liste_contenu.get(i).getTimecodeFin() + " / " + liste_contenu.get(i).getDescription());
      }

    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}
