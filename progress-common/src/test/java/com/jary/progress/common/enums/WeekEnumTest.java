package com.jary.progress.common.enums;

import com.jary.progress.common.enmus.WeekEnum;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/6/3 10:44 上午
 */
public class WeekEnumTest {

    /**
     * 比较同类型枚举
     */
    @Test
    public void testCompareEnum() {
        //
        Assert.assertEquals(WeekEnum.Saturday, WeekEnum.Saturday);
        Assert.assertNotEquals(WeekEnum.Saturday, WeekEnum.Thursday);
        Assert.assertEquals(WeekEnum.Saturday.compareTo(WeekEnum.Saturday), 0);
        Assert.assertEquals(WeekEnum.Saturday.equals(WeekEnum.Saturday), true);
    }
}
