package org.epicgame.basichero;

public class ExampleHero extends BasicHero {
    public ExampleHero(Integer health, Integer mana) {
        super(health, mana);
    }

    public static void main(String[] args) {
        BasicHero hero = new ExampleHero(10, 10);
        System.out.println(hero.getMoney());
    }
}
