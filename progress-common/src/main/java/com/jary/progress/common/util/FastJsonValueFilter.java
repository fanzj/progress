package com.jary.progress.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.jary.progress.common.util.SensitiveInfoUtils.tuomin;

/**
 * @author fanzhengjie
 * @create 2019/3/19 上午10:54
 * @description
 */
public class FastJsonValueFilter {

    static class A{
        private int length;
        private int pageNo;
        private int pageSize;
        private SubA subA;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public SubA getSubA() {
            return subA;
        }

        public void setSubA(SubA subA) {
            this.subA = subA;
        }

        static class SubA{
            private String accountName;
            private BigDecimal amount;
            private String bankAccount;
            private String idCard;
            private String phone;

            public String getAccountName() {
                return accountName;
            }

            public void setAccountName(String accountName) {
                this.accountName = accountName;
            }

            public BigDecimal getAmount() {
                return amount;
            }

            public void setAmount(BigDecimal amount) {
                this.amount = amount;
            }

            public String getBankAccount() {
                return bankAccount;
            }

            public void setBankAccount(String bankAccount) {
                this.bankAccount = bankAccount;
            }

            public String getIdCard() {
                return idCard;
            }

            public void setIdCard(String idCard) {
                this.idCard = idCard;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }
    }

    private static Map<String, List<String>> typeMap = Maps.newHashMap();

    static {
        typeMap.put("ID_CARD", Lists.newArrayList("accountNo","idCard"));
        typeMap.put("ACC_NAME", Lists.newArrayList("accountName","name"));
        typeMap.put("PHONE_NUM", Lists.newArrayList("phone"));
        typeMap.put("BANK_CARD", Lists.newArrayList("bankAccNo","bankCard","bankAccount"));
    }

    public static final ValueFilter JSON_SENSITIVE_FILTER = new ValueFilter() {
        @Override
        public Object process(Object object, String name, Object value) {
            try {
                for (Map.Entry<String, List<String>> entry : typeMap.entrySet()) {
                    if (!entry.getValue().isEmpty()) {
                        for (String filed : entry.getValue()) {
                            if (name.equals(filed)) {
                                return value != null && StringUtils.isNotBlank(String.valueOf(value)) ? tuomin(entry
                                    .getKey(), String.valueOf(value)) : value;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                return value;
            }
            return value;
        }
    };

    private static List<String> BANK_CARD_LIST = ImmutableList.of("bankAccount", "bankCard", "bankAccNo");
    private static List<String> PHONE_LIST = ImmutableList.of("phone");

    public static final ValueFilter JSON_SENSITIVE_FILTER2 = new ValueFilter() {
        @Override
        public Object process(Object object, String name, Object value) {
            try {
                if(BANK_CARD_LIST.contains(name)){
                    return value != null && StringUtils.isNotBlank(String.valueOf(value)) ?
                        SecureUtils.getBankAccout(String.valueOf(value)) : value;
                }
                if(PHONE_LIST.contains(name)){
                    return value != null && StringUtils.isNotBlank(String.valueOf(value)) ?
                        SecureUtils.getMobileMask(String.valueOf(value)) : value;
                }
            } catch (Exception e) {
                return value;
            }
            return value;
        }
    };

    public static void main(String[] args) {
        String s = "{\"length\":3,\"pageNo\":1,\"pageSize\":50,\"records\":{\"accountName\":\"徐*群\",\"amount\":16.0,\"bankAccount\":\"6212251811000125584\",\"bankName\":\"工商银行\",\"cardType\":\"储蓄卡\",\"channelCode\":\"cpcn_qk1\",\"channelName\":\"中金快捷1\",\"createAt\":1552901785000,\"entityName\":\"尚牛\",\"idCard\":\"420700****6249\",\"orderNo\":\"U320752671\",\"phone\":\"158****6890\",\"productName\":\"即刻有-分期商城\",\"retCode\":\"0000\",\"retMsg\":\"处理成功\",\"serialNo\":\"2019031811994572\",\"status\":2,\"updatedAt\":1552901786000,\"userId\":\"224424532\"}}";

        A a = new A();
        a.setPageNo(1);
        a.setPageSize(20);
        a.setLength(20);
        A.SubA subA = new A.SubA();
        subA.setAccountName("javk");
        subA.setAmount(new BigDecimal(12));
        subA.setBankAccount("6212251811000125584");
        subA.setIdCard("332131414141141");
        subA.setPhone("123354543534");
        a.setSubA(subA);

        //System.out.println(JSON.toJSONString(a, JSON_SENSITIVE_FILTER));
        System.out.println(JSON.toJSONString(a, JSON_SENSITIVE_FILTER2));

       Object obj = s;
        System.out.println(JSON.toJSONString(obj, JSON_SENSITIVE_FILTER2));
    }



}
