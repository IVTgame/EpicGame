package org.epicgame.heroesinterfaces;

import java.awt.Point;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface BasicAction {
    public TextureRegion drawAction();
    public void heroMove(Point[] point);
    public void nearAtack(Point point);
    public void magicAtack(Point point);
    public void rangeAtack(Point point);
    
}
