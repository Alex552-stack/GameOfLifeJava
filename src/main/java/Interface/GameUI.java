package Interface;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

public class GameUI extends GameApplication {
    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(800);
        gameSettings.setHeight(600);
        gameSettings.setTitle("Game of life");
    }
    @Override
    protected void initGame() {
        int cellSize = 20;
        int rows = FXGL.getAppHeight() / cellSize;
        int cols = FXGL.getAppWidth() / cellSize;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Entity cell = FXGL.entityBuilder()
                        .at(j * cellSize, i * cellSize)
                        //.view(new Rectangle(cellSize, cellSize, Color.BLACK))
                        .buildAndAttach();
            }
        }
    }
}