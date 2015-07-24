package org.drawinterfeses;

import java.awt.Point;
import java.util.ArrayList;

import org.abstractfactory.Unit;

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

	public TextureRegion drawField(); // возвраща кусок пол€ в зависимости от
										// установленых координат.

	public ArrayList<Point> creatPath(Point start, Point end,
			Boolean ignoreBarriers); // —оздает путь от точки start до точки
										// end. ignoreBarriers - определ€ет
										// игнорировать ли прип€тстви€ при
										// прокладывании пути(например летающие
										// игнорируют)

	public void touchScreen(Point touch); // ¬ызываетс€ при соприкосновении
											// пальца с экраном

	public void movementOnTheScreen(Point move); // ¬ызываетс€ при движении
													// пальца по экрану move -
													// координата движени€.
													// ƒвижение карты происходит
													// только тогда когда
													// разница между координатой
													// движени€ и соприкосновни€
													// больше половины клетки

	public void setBackground(TextureRegion background); // ”станавливает фон
															// пол€. Ћюба€
															// картинка.
}
