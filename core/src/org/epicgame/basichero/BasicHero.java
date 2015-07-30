package org.epicgame.basichero;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class BasicHero extends Actor {

	public enum Action {
		MOVEMENT, REST, NEAR_ATACK, FAR_ATACK, MAGICK_ATACK, SPECIAL_SKILS, DAMAGE, DIE
	}
	
    private Integer health; // ������� ��������
    private Integer mana; // ������� ���� (��� ������ �������)
    private Integer nearArmor; // ������� ����� �� �������� ���
    private Integer magicArmor; // ������� ����� �� �����
    private Integer rangeArmor; // ������� ����� �� ���� � ������ �����������
    private Integer nearDamage; // ���� �� �������� ���
    private Integer magicDamage; // ���� �� ����������� ���
    private Integer rangeDamage; // ���� �� ����, ����������� ����� � ������.
    private Integer nearPower; // ���� �������� ���
    private Integer magicPower; // ���� �����(��������� ����������)
    private Integer rangePower; // ���� ������������ ������
    private Integer money; // ���������� ����� �����
    private Integer sizeX;
    private Integer sizeY;
    private Double criticalHit; // ������� ������������ �����
    private Double distanceAtack; // ���������, ������� � ������� ����� ����� ���������(�������� ��������: ��� ������ ���������� ����� ���������)
    private Double distanceMove ; // ���������, �� ������� ����� ������������ ����� (���� �����-�� ������ ����� ������ �� �������, ������ �� distanceMove, �� ���� ������ ������������)
    private Action action;  // ������� ��������� � ������ ������
    private Integer numberSpecialSkils; // ����� ��������� ������� ������
    
        
    public Integer getSizeY() {
		return sizeY;
	}
	public void setSizeY(Integer sizeY) {
		this.sizeY = sizeY;
	}
	public Integer getSizeX() {
		return sizeX;
	}
	public void setSizeX(Integer sizeX) {
		this.sizeX = sizeX;
	}
	// ������� � ������� ��� �������� ������������� ���������.
    public void setAction(Action action) {
    	this.action = action;
    }
    public Action getAction() {
    	return action;
    }
    public void setNumberSpecialSkils(Integer numberSpecialSkils) {
    	this.numberSpecialSkils = numberSpecialSkils;
    }
    public Integer getNumberSpecialSkils() {
    	return numberSpecialSkils;
    }
    public void setHealth(Integer health) {
        this.health = health;
    }
    public Integer getHealth() {
        return health;
    }
    public void setMana(Integer mana) {
        this.mana = mana;
    }
    public Integer getMana() {
        return mana;
    }
    public void setNearArmor(Integer nearArmor) {
        this.nearArmor = nearArmor;
    }
    public Integer getNearArmor() {
        return nearArmor;
    }
    public void setMagicArmor(Integer magicArmor) {
        this.magicArmor = magicArmor;
    }
    public Integer getMagicArmor() {
        return magicArmor;
    }
    public void setRangeArmor(Integer rangeArmor) {
        this.rangeArmor = rangeArmor;
    }
    public Integer getRangeArmor() {
        return rangeArmor;
    }
    public void setNearDamage(Integer nearDamage) {
        this.nearDamage = nearDamage;
    }
    public Integer getNearDamage() {
        return nearDamage;
    }
    public void setMagicDamage(Integer magicDamage) {
        this.magicDamage = magicDamage;
    }
    public Integer getMagicDamage() {
        return magicDamage;
    }
    public void setRangeDamage(Integer rangeDamage) {
        this.rangeDamage = rangeDamage;
    }
    public Integer getRangeDamage() {
        return rangeDamage;
    }
    public void setNearPower(Integer nearPower) {
        this.nearPower = nearPower;
    }
    public Integer getNearPower() {
        return nearPower;
    }
    public void setRangePower(Integer rangePower) {
        this.rangePower = rangePower;
    }
    public Integer getRangePower() {
        return rangePower;
    }
    public void setMagicPower(Integer magicPower) {
        this.magicPower = magicPower;
    }
    public Integer getMagicPower() {
        return magicPower;
    }
    public void setMoney(Integer money) {
        this.money = money;
    }
    public Integer getMoney() {
        return money;
    }
    public void setCriticalHit(Double criticalHit) {
        this.criticalHit = criticalHit;
    }
    public Double getCriticalHit() {
        return criticalHit;
    }
    public void setDistanceAtack(Double distanceAtack) {
        this.distanceAtack = distanceAtack;
    }
    public Double getDistanceAtack() {
        return distanceAtack;
    }
    public void setDistanceMove(Double distanceMove) {
        this.distanceMove = distanceMove;
    }
    public Double getDistanceMove() {
        return distanceMove;
    }


}
