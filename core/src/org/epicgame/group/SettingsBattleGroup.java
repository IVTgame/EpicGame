package org.epicgame.group;

import org.json.JSONArray;
import org.json.JSONObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SettingsBattleGroup {
	
	public JSONObject featuresUnits; // json � ��������� ������
	public Texture atlasAnimation; // ����� ������� � ��������� ������
	public JSONObject featuresAtlas; // json � ��������� ������
	public JSONArray featuresHero; // ���������� � ������� �����(����� ����� � �����)
	public JSONArray featuresBattleField; // �������� ���� ���(�����)
	public int sizeBattleFieldX; //� �������
	public int sizeBattleFieldY; //� �������
	public TextureRegion  backgroundBattleField; // ��� ���� ���
	public TextureRegion  cellNotActiv; // ������� �� �������� ������
	public TextureRegion  cellActiv; // �������� ������(������������ ���� ����� �����)
	public Float speedAnimation; // �������� ��������(����� �� ������� ������� ����� ����)
	public Long speedMovement; // �������� �������� �� ���� ���(���������� �� 1 ���)
	public Integer sizeCell; // ������ ������ �� ���� ��� � ��������
}
