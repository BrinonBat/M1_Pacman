import java.io.File;
import java.util.ArrayList;

public class FReader {
    File dir;

    FReader(String dirPath){
        dir = new File(dirPath);
    }

    ///recupère la liste de fichiers dans le dossier dir
    public ArrayList<String> getTitles(){
        ArrayList<String> result = new ArrayList<String>();

        for(File file : (dir.listFiles(new FilterSrc()))){
            result.add(file.getName());
        }

        return result;
    }
}
