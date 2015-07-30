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
    private Integer sizeX;
    private Integer sizeY;
    private Double criticalHit; // ������� ������������ �����
    private Double distanceAtack; // ���������, ������� � ������� ����� ����� ���������(�������� ��������: ��� ������ ���������� ����� ���������)
    private Double distanceMove ; // ���������, �� ������� ����� ������������ ����� (���� �����-�� ������ ����� ������ �� �������, ������ �� distanceMove, �� ���� ������ ������������)
    private Action action;  // ������� ��������� � ������ ������
    
    //new
    private Integer initiative;
    private Integer capacity;
    private Integer increment;
    
    
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
	public Integer getInitiative() {
		return initiative;
	}
	public void setInitiative(Integer initiative) {
		if(this.initiative != null) return;
		this.initiative = initiative;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getIncrement() {
		return increment;
	}
	public void setIncrement(Integer increment) {
		this.increment = increment;
	}


}
