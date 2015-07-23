package org.epicgame.basichero;

public class BasicHero {

    private Integer health; // уровень здоровья
    private Integer mana; // уровень маны (или другой энергии)
    private Integer nearArmor; // уровень брони от Ближнего боя
    private Integer magicArmor; // уровень брони от Магии
    private Integer rangeArmor; // уровень брони от лука и прочих метательных
    private Integer nearDamage; // урон от ближнего боя
    private Integer magicDamage; // урон от магического боя
    private Integer rangeDamage; // урон от лука, метательных ножей и прочее.
    private Integer nearPower; // сила ближнего боя
    private Integer magicPower; // сила магии(наподрбие интеллекта)
    private Integer rangePower; // сила метательного оружия
    private Integer money; // количество денег героя
    private Double criticalHit; // процент критического урона
    private Double distanceAtack; // дистанция, начиная с которой герой может атаковать(возможна поправка: для кажого заклинания будет отдельной)
    private Double distanceMove ; // дистанция, на которую может перемещаться герой (если какая-то клетка стоит дальше от текущей, больше на distanceMove, то туда нельзя перемещаться)

    // сеттеры и геттеры для основных характеристик персонажа. 
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
