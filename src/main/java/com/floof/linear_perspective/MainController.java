package com.floof.linear_perspective;

import com.floof.linear_perspective.model.*;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Arrays;

public class MainController {

    @FXML
    private Pane mainView;

    @FXML
    void initialize() {
        SceneAdapter sceneAdapter = new SceneAdapterI(makeSceneWithCube(), 8);
        mainView.getChildren().add(sceneAdapter.getRendering());
    }

    private Scene makeSceneWithCube() {
        Vector3D cameraPosition = new Vector3D(0, 0, 0);
        Vector3D cameraDirection = new Vector3D(0, 0 ,1);
        Camera camera = new Camera(cameraPosition, cameraDirection);

        Geometry cube = makeCube();
        ArrayList<Geometry> geometries = new ArrayList<>();
        geometries.add(cube);

        return new Scene(camera, geometries);
    }

    private Geometry makeCube() {
        return new Geometry(Arrays.asList(
                new Vector3D(1, 1, 1),
                new Vector3D(1, 1, -1),
                new Vector3D(1, -1, 1),
                new Vector3D(1, -1, -1),
                new Vector3D(-1, 1, 1),
                new Vector3D(-1, 1, -1),
                new Vector3D(-1, -1, 1),
                new Vector3D(-1, -1, -1)
        ), new ArrayList<>(Arrays.asList(
                new Pair<>(0, 1),
                new Pair<>(2, 3),
                new Pair<>(4, 5),
                new Pair<>(6, 7),
                new Pair<>(0, 4),
                new Pair<>(1, 5),
                new Pair<>(2, 6),
                new Pair<>(3, 7),
                new Pair<>(0, 2),
                new Pair<>(4, 6),
                new Pair<>(1, 3),
                new Pair<>(5, 7)
        )), new Vector3D((float) 0, (float) 0, (float) 8));
    }
}