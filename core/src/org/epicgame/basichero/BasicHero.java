package org.epicgame.basichero;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class BasicHero extends Actor {

	public enum Action {
		MOVEMENT, REST, NEAR_ATACK, FAR_ATACK, MAGICK_ATACK, SPECIAL_SKILS, DAMAGE, DIE
	}
	
    private Integer health; // уровень здоровья
    private Integer mana; // уровень маны (или другой энергии)
    private Integer nearArmor; // уровень брони от Ближнего боя
    private Integer magicArmor; // уровень брони от Магии
    private Integer rangeArmor; // уровень брони от лука и прочих метательных
    private Integer nearDamage; // урон от ближнего боя
    private Integer magicDamage; // урон от магического боя
    private Integer rangeDamage; // урон от лука, метательных ножей и прочее.
    private Integer sizeX;
    private Integer sizeY;
    private Double criticalHit; // процент критического урона
    private Double distanceAtack; // дистанция, начиная с которой герой может атаковать(возможна поправка: для кажого заклинания будет отдельной)
    private Double distanceMove ; // дистанция, на которую может перемещаться герой (если какая-то клетка стоит дальше от текущей, больше на distanceMove, то туда нельзя перемещаться)
    private Action action;  // дейсвие персонажа в данный момент
    
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
	// сеттеры и геттеры для основных характеристик персонажа.
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
