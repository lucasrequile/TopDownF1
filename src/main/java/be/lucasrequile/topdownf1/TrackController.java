package be.lucasrequile.topdownf1;


import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import model.TrackModel;
import view.TrackView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.layout.AnchorPane;

/**
 * src/main/resources/json/image_array.json
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
        // Create the model and view
        model = new TrackModel();
        view = new TrackView(model);
        
        // Add the view to the track pane
        trackPane.getChildren().addAll(view);
        
        // Load the track layout from the JSON file
        try {
            loadTrack("src/main/resources/bin/image_array.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Draw the track using the track layout
        int[][] trackLayout = model.getTrackLayout();
        for (int i = 0; i < trackLayout.length; i++) {
            for (int j = 0; j < trackLayout[i].length; j++) {
                if (trackLayout[i][j] == 0) {
                    view.drawGrass(i, j);
                } else if (trackLayout[i][j] == 1) {
                    view.drawRoad(i, j);
                } else if (trackLayout[i][j] == 2) {
                    view.drawBorder(i, j);
                }
            }
        }
    }

public void loadTrack(String fileName) throws IOException {
    // Initialize the track layout array
    int[][] trackLayout = null;

    // Open the binary file for reading
    try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
        // Read the number of rows and columns
        int numRows = dis.readInt();
        int numCols = dis.readInt();
        trackLayout = new int[numRows][numCols];

        // Read the data from the file, one row at a time
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                trackLayout[i][j] = dis.readUnsignedByte();
            }
        }
    }

    // Set the track layout in the model
    model.setTrackLayout(trackLayout);
}

}