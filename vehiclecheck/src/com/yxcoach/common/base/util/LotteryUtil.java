package com.yxcoach.common.base.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.yxcoach.common.entity.Prize;

/**
 * 不同概率抽奖工具包
 */
public class LotteryUtil {
	/**
     * 抽奖
     *
     * @param prizes
     *            待抽奖物品列表
     * @return
     *         抽中的奖品
     */
    public static Prize lottery(List<Prize> prizes) {
		List<Double> orignalRates = new ArrayList<Double>(prizes.size());
        for (Prize prize : prizes) {
            double probability = prize.getProbability();
            if (probability < 0) {
                probability = 0;
            }
            orignalRates.add(probability);
        }
        int index = getPrizeIndex(orignalRates);;
        return prizes.get(index);
    }
	
    /**
     * 获得抽中奖品索引
     *
     * @param orignalRates
     *            原始的概率列表
     * @return
     *         物品的索引
     */
    public static int getPrizeIndex(List<Double> orignalRates) {
        if (orignalRates == null || orignalRates.isEmpty()) {
            return -1;
        }

        int size = orignalRates.size();

        // 计算总概率，这样可以保证不一定总概率是1
        double sumRate = 0d;
        for (double rate : orignalRates) {
            sumRate += rate;
        }

        // 计算每个物品在总概率的基础下的概率情况
        List<Double> sortOrignalRates = new ArrayList<Double>(size);
        Double tempSumRate = 0d;
        for (double rate : orignalRates) {
            tempSumRate += rate;
            sortOrignalRates.add(tempSumRate / sumRate);
        }

        // 根据区块值来获取抽取到的物品索引
        double nextDouble = Math.random();
        sortOrignalRates.add(nextDouble);
        Collections.sort(sortOrignalRates);

        return sortOrignalRates.indexOf(nextDouble);
    }
    
    public static void main(String[] args) {
        List<Prize> prizes = new ArrayList<Prize>();
        // 序号==物品Id==物品名称==概率
        prizes.add(new Prize(1, 1L, "物品1", 0.2d));
        prizes.add(new Prize(2, 2L, "物品2", 0.2d));
        prizes.add(new Prize(3, 3L, "物品3", 0.4d));
        prizes.add(new Prize(4, 4L, "物品4", 0.3d));
        prizes.add(new Prize(5, 5L, "物品5", 0d));
        prizes.add(new Prize(6, 6L, "物品6", -0.1d));
        prizes.add(new Prize(7, 7L, "物品7", 0.008d));

        List<Double> orignalRates = new ArrayList<Double>(prizes.size());
        for (Prize gift : prizes) {
            double probability = gift.getProbability();
            if (probability < 0) {
                probability = 0;
            }
            orignalRates.add(probability);
        }

        // statistics
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        double num = 1000000;
        for (int i = 0; i < num; i++) {
            int orignalIndex = LotteryUtil.getPrizeIndex(orignalRates);

            Integer value = count.get(orignalIndex);
            count.put(orignalIndex, value == null ? 1 : value + 1);
        }

        for (Entry<Integer, Integer> entry : count.entrySet()) {
            System.out.println(prizes.get(entry.getKey()) + ", count=" + entry.getValue() + ", probability=" + entry.getValue() / num);
        }
    }
}
