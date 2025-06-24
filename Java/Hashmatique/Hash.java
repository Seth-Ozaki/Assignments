import java.util.HashMap;
import java.util.Set;
public class Hash{

    public HashMap<String, String> setMap(){
        HashMap<String, String> trackMap = new HashMap<String, String>();
        trackMap.put("Track 1", "Lyrics 1");
        trackMap.put("Track 2", "Lyrics 2");
        trackMap.put("Track 3", "Lyrics 3");
        trackMap.put("Track 4", "Lyrics 4");  
        return trackMap;
    }

    public String getTrack(String value){
        HashMap<String, String> trackMap = setMap();
        String output = trackMap.get(value);
        return output;
    }

    public void getAll(){
        HashMap<String, String> trackMap = setMap();
        Set<String> keys = trackMap.keySet();
        for(String value : keys){
        System.out.printf(value+": "+trackMap.get(value));
        }
        return;
    }
}