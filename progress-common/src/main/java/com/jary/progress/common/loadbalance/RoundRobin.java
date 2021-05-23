package com.jary.progress.common.loadbalance;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author fanzhengjie
 * @create 2019/1/28 下午5:40
 * @description 轮询法
 */
public class RoundRobin {

    private static Integer pos = 0;

    public static String getServer(){
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String,Integer> serverMap = Maps.newHashMap();
        serverMap.putAll(IpMap.serverWeightMap);

        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        List<String> keyList = Lists.newArrayList();
        keyList.addAll(keySet);

        String server = null;
        synchronized (pos){
            if(pos > keySet.size()){
                pos = 0;
            }
            server = keyList.get(pos);
            pos ++;
        }
        return server;
    }

}
