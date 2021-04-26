package application;

import javafx.application.Application;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Cell extends Rectangle {
	Images img = new Images();
    public int x, y;
    public Ship ship = null;
    public boolean wasShot = false;
    public boolean headOfShip = false;
//     Image boom  = new Image("file:///C:/Users/Admin/eclipse-workspace/hhh/src/hhh/boom.jpg");
     

   
    private Board board;
    
    public Cell(int x, int y, Board board) {
        super(30, 30);
        this.x = x;
        this.y = y;
        this.board = board;
     
        setFill(new ImagePattern(img.waterorg));
 //     setFill(img1.setImage(img));
        setStroke(Color.LIGHTGREEN);
    }

    public boolean shoot() {
        wasShot = true;
        setFill(new ImagePattern(img.watermiss));

        if (ship != null) {
            ship.hit();
            setFill(new ImagePattern(img.explosion));
            if (!ship.isAlive()) {
                board.ships--;
            }
            return true;
        }

        return false;
    }
}