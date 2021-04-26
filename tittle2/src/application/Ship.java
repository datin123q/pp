package application;

import javafx.scene.Parent;

public class Ship extends Parent {
    public int type;
    public boolean vertical = true;
    public int point;
    private int health;

    public Ship(int type, boolean vertical) {
        this.type = type;
        this.vertical = vertical;
        health = type;
        if(type==5) {
        	point=5;
        }else {
        	if(type==4) {
        		point=6;
        	}else {
        		if(type==3) {
        			point=7;
        		}else {
        			if(type==2) {
        				point=9;
        			}else {
        				point=12;
        			}
        		}
        	}
        }

        /*VBox vbox = new VBox();
        for (int i = 0; i < type; i++) {
            Rectangle square = new Rectangle(30, 30);
            square.setFill(null);
            square.setStroke(Color.BLACK);
            vbox.getChildren().add(square);
        }

        getChildren().add(vbox);*/
    }

    public void hit() {
        health--;
    }

    public boolean isAlive() {
        return health > 0;
    }
}