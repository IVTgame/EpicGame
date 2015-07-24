package org.drawinterfeses;

import java.awt.Point;
import java.util.ArrayList;

import org.abstractfactory.Unit;

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

	public TextureRegion drawField(); // �������� ����� ���� � ����������� ��
										// ������������ ���������.

	public ArrayList<Point> creatPath(Point start, Point end,
			Boolean ignoreBarriers); // ������� ���� �� ����� start �� �����
										// end. ignoreBarriers - ����������
										// ������������ �� ����������� ���
										// ������������� ����(�������� ��������
										// ����������)

	public void touchScreen(Point touch); // ���������� ��� ���������������
											// ������ � �������

	public void movementOnTheScreen(Point move); // ���������� ��� ��������
													// ������ �� ������ move -
													// ���������� ��������.
													// �������� ����� ����������
													// ������ ����� �����
													// ������� ����� �����������
													// �������� � ��������������
													// ������ �������� ������

	public void setBackground(TextureRegion background); // ������������� ���
															// ����. �����
															// ��������.
}
