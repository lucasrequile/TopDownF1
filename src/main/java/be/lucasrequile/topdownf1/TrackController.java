package be.lucasrequile.topdownf1;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.TrackModel;
import view.TrackView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Lucas Requilé
 */
public class TrackController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane trackPane;
    
    TrackModel model;
    TrackView view;
    
    @FXML
    void initialize() {
        model = new TrackModel();
        view = new TrackView(model);
        
        trackPane.getChildren().addAll(view);
        
        //ook de volgende 5 regels komen van ChatGPT
        try{
            loadTrack("src/main/resources/json/image_array.json");
        } catch(IOException e){
            e.printStackTrace();
        }
        int[][] trackLayout = model.getTrackLayout();
        
        for(int i = 0; i < trackLayout.length; i++){
            for(int j = 0; j < trackLayout[i].length; j++){
                if(trackLayout[i][j]==0){
                    view.drawGrass(i,j);
                }
                if(trackLayout[i][j]==1){
                    view.drawRoad(i, j);
                }
                if(trackLayout[i][j]==2){
                    view.drawBorder(i,j);
                }
            }
        }
    }

    //methode loadTrack is niet zelf geschreven, maar geholpen door ChatGPT - OpenAI. Hiermee wordt een JSON file omgezet naar een 2D-Array. 
    public void loadTrack(String fileName) throws IOException {
        // Read the contents of the file into a byte array
        byte[] data = Files.readAllBytes(Paths.get(fileName));

        // Deserialize the byte array to a two-dimensional array of integers
        ObjectMapper mapper = new ObjectMapper();
        int[][] trackLayout = mapper.readValue(data, int[][].class);

        // Set the track layout in the model
        model.setTrackLayout(trackLayout);
  }
}
