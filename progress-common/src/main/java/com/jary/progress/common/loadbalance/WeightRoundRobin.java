package com.jary.progress.common.loadbalance;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author fanzhengjie
 * @create 2019/1/28 下午7:32
 * @description 加权轮询法
 */
public class WeightRoundRobin {

    private static Integer pos = 0;

    public static String getServer(){
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = Maps.newHashMap();
        serverMap.putAll(IpMap.serverWeightMap);

        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();

        List<String> serverList = Lists.newArrayList();
        while(iterator.hasNext()){
            String server = iterator.next();
            int weight = serverMap.get(server);
            for(int i=0;i<weight;i++){
                serverList.add(server);
            }
        }

        String server = null;
        synchronized (pos){
            if(pos > keySet.size()){
                pos = 0;
            }

            server = serverList.get(pos);
            pos ++;
        }
        return server;

    }

}
