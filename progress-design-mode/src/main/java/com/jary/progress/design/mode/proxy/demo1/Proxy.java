package com.jary.progress.design.mode.proxy.demo1;

/**
 * @author fanzhengjie
 * @date 2020/5/20 9:36 下午
 */
public class Proxy implements GiveGift {

    private GiveGift gg;

    public Proxy(GiveGift gg) {
        this.gg = gg;
    }

    @Override
    public void giveDolls() {
        gg.giveDolls();
    }

    @Override
    public void giveFlowers() {
        gg.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        gg.giveChocolate();
    }
}
