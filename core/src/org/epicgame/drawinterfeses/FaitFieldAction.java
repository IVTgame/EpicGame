package org.epicgame.drawinterfeses;

import java.awt.Point;
import java.util.ArrayList;

import org.epicgame.abstractfactory.Unit;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface FaitFieldAction { // ��� ������������� � ����������� ����������
									// : ������ ������ � ��������, ������ ���� �
									// �������.

	public void addUnitsTheField(ArrayList<Unit> units); // ���������� �����
															// ����������� ����.
															// ������ ���� �����
															// ���������
															// ���������
															// ������������.

	public void drawField(SpriteBatch spriteBatch); // �������� ����� ���� � ����������� ��
										// ������������ ���������.

	public ArrayList<Point> creatPath(Point start, Point end,
			Boolean ignoreBarriers); // ������� ���� �� ����� start �� �����
										// end. ignoreBarriers - ����������
										// ������������ �� ����������� ���
										// ������������� ����(�������� ��������
										// ����������)

	public void setBackground(TextureRegion background); // ������������� ���
															// ����. �����
															// ��������.
	public void setTextureCell(TextureRegion textureCell);
	
	public void setBeginFildTheUnit(Point begin);
}
