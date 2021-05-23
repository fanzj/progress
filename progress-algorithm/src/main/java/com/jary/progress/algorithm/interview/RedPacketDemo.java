package com.jary.progress.algorithm.interview;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author fanzhengjie
 * @create 2020/2/20 下午4:26
 * @description 随机红包算法
 * ali
 */
public class RedPacketDemo {

    public void getRedPacket(double total, int num, double min) {
        double bestMoney = 0;//最佳金额
        int bestIndex = -1;//最佳位置

        for (int i = 1; i < num; i++) {
            double safe_total = (total - (num - i) * min) / (num - i);
            //safe_total = 0.9 * total;
            double money = Math.random() * (safe_total - min) + min;//[min, safe_total)
            BigDecimal money_bd = new BigDecimal(money);
            money = money_bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            total = total - money;
            BigDecimal total_bd = new BigDecimal(total);
            total = total_bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println("第" + i + "个红包：" + money + ",余额为:" + total + "元");

            if (bestMoney < money) {
                bestMoney = money;
                bestIndex = i;
            }
        }
        System.out.println("第" + num + "个红包：" + total + ",余额为:0元");
        if (bestMoney < total) {
            bestMoney = total;
            bestIndex = num;
        }

        System.out.println("最佳手气为第" + bestIndex + "个人,金额为:" + bestMoney + "元");
    }

    public double[] getRedPacket2(double money, int num) {
        Random random = new Random();
        DecimalFormat format = new DecimalFormat(".##");

        double middle = Double.parseDouble(format.format(money / num));
        double[] dou = new double[num];
        double redMoney = 0;
        double nextMoney = money;//红包余额
        int index = 0;
        for (int i = num; i > 0; i--) {
            if(i==1){
                dou[index] = nextMoney;
            }else {
                while(true) {
                    String str = format.format(random.nextDouble() * nextMoney);
                    redMoney = Double.parseDouble(str);
                    if(redMoney > 0 && redMoney < middle) {
                        break;
                    }
                }

                nextMoney = Double.parseDouble(format.format(nextMoney - redMoney));
                dou[index] = redMoney;
                middle = Double.parseDouble(format.format(nextMoney/(i-1)));
                index ++;
            }




        }

        return dou;
    }

    public static void main(String[] args) {
        RedPacketDemo redPacketDemo = new RedPacketDemo();
        redPacketDemo.getRedPacket(100, 3, 0.01);

      //  double[] res = redPacketDemo1.getRedPacket2(100, 10);
      //  System.out.println(Arrays.toString(res));
    }
}
