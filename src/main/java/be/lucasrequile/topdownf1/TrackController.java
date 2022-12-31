/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package be.lucasrequile.topdownf1;

import model.TrackModel;
import view.TrackView;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Lucas Requilé
 */
public class TrackController {
    private TrackModel model;
    private TrackView view;

    public TrackController(TrackModel model, TrackView view) {
        this.model = model;
        this.view = view;
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
