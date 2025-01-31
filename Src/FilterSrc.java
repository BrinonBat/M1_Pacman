import java.io.File;
import java.io.FilenameFilter;


public class FilterSrc implements FilenameFilter {
        /**
         * Refuse les noms qui ne se terminent pas par .lay
         * @param dir dossier à tester
         * @param name nom du fichier à filtrer
         * @return booléen valant true si le fichier est accepté, false sinon
         */
        @Override
        public boolean accept(File dir, String name) {
            if (name.endsWith(".lay"))  return true;
            return false;
        }
}

