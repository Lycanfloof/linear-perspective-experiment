package com.floof.linear_perspective.model;

import javafx.scene.Node;

public interface SceneAdapter {
    public Node getRendering(float screenWidth, float screenHeight, float zoomCoefficient);
}
