package org.epicgame.group;

import org.json.JSONArray;
import org.json.JSONObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SettingsBattleGroup {
	
	public JSONObject featuresUnits; // json с описанием юнитов
	public Texture atlasAnimation; // Атлас текстур с анимацией юнитов
	public JSONObject featuresAtlas; // json с описанием атласа
	public JSONArray featuresHero; // Информация о главном герое(какие войны в армии)
	public JSONArray featuresBattleField; // Описание поля боя(враги)
	public int sizeBattleFieldX; //в клетках
	public int sizeBattleFieldY; //в клетках
	public TextureRegion  backgroundBattleField; // Фон поля боя
	public TextureRegion  cellNotActiv; // Обычная не активная клетка
	public TextureRegion  cellActiv; // Активная клетка(подсвечиваем куда можно пойти)
	public Float speedAnimation; // Скорость анимации(время за которое пройдет целый цикл)
	public Long speedMovement; // Скорость движения по полю боя(милисекунд на 1 шаг)
	public Integer sizeCell; // Размер клетки на поле боя в пикселях
}
