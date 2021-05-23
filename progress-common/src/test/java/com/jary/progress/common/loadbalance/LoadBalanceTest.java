package com.jary.progress.common.loadbalance;

import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/6/3 5:58 下午
 */
public class LoadBalanceTest {

    @Test
    public void testHash(){
        System.out.println(Hash.getServer());
    }

    @Test
    public void testRandom() {
        System.out.println(Random.getServer());
    }

    @Test
    public void testRoundRobin() {
        System.out.println(RoundRobin.getServer());
    }

    @Test
    public void testWeightRandom() {
        System.out.println(WeightRandom.getServer());
    }

    @Test
    public void testWeightRandomRobin() {
        System.out.println(WeightRoundRobin.getServer());
    }

}
