package org.epicgame.drawinterfeses;

import java.awt.Point;
import java.util.ArrayList;

import org.epicgame.abstractfactory.Unit;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface FaitFieldAction { // ѕри инициализации в конструктор передаетс€
									// : размер клетки в пиксел€х, размер пол€ в
									// клеткач.

	public void addUnitsTheField(ArrayList<Unit> units); // ¬ызываетс€ перед
															// построением пути.
															//  аждый юнит кроме
															// летающего
															// считаетс€
															// преп€тствием.

	public void drawField(SpriteBatch spriteBatch); // возвраща кусок пол€ в зависимости от
										// установленых координат.

	public ArrayList<Point> creatPath(Point start, Point end,
			Boolean ignoreBarriers); // —оздает путь от точки start до точки
										// end. ignoreBarriers - определ€ет
										// игнорировать ли прип€тстви€ при
										// прокладывании пути(например летающие
										// игнорируют)

	public void setBackground(TextureRegion background); // ”станавливает фон
															// пол€. Ћюба€
															// картинка.
	public void setTextureCell(TextureRegion textureCell);
	
	public void setBeginFildTheUnit(Point begin);
}
