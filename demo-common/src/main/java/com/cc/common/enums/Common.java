package com.cc.common.enums;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/18 15:59
 * Description:
 */
public class Common {

    public enum Status{
        YES((short)1),
        NO((short)0);

        private Short val;

        Status(Short val) {
            this.val = val;
        }

        public Short getVal() {
            return val;
        }
    }
}
