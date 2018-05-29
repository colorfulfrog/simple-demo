package com.yxcoach.common.base.util;



import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.MDC;
import org.slf4j.spi.MDCAdapter;

import com.google.common.base.Joiner;

import cn.jpush.api.utils.Nullable;

public class PayUtil {

	static MDCAdapter mdcAdapter;
	
	private static final String BIZPARAM = "payParam";
    /**
     * 设置日志中的业务参数
     *
     * @param payId
     */
    public static void setPayId(String... bizId) {
        String bizParam = MDC.get(BIZPARAM);
        if (StringUtils.isBlank(bizParam)) {
            bizParam = Joiner.on(",").skipNulls().join(bizId);
            MDC.put(BIZPARAM, bizParam);
        } else {
            StringBuilder sbd = new StringBuilder()
                    .append(bizParam)
                    .append(",").append(Joiner.on(",").skipNulls().join(bizId));

            MDC.put(BIZPARAM, sbd.toString());
        }
    }
    
    public static String get(String key) throws IllegalArgumentException {
        if(key == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        } else if(mdcAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else {
            return mdcAdapter.get(key);
        }
    }
    
    public static <T> T checkNotNull(T reference, @Nullable Object errorMessage) {
        if (reference == null) {
          throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
      }
    
    
    public static boolean isNoneBlank(CharSequence... css) {
        return !isAnyBlank(css);
    }
    
    public static boolean isAnyBlank(CharSequence... css) {
        if(ArrayUtils.isEmpty(css)) {
            return true;
        } else {
            CharSequence[] arr$ = css;
            int len$ = css.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                CharSequence cs = arr$[i$];
                if(isBlank(cs)) {
                    return true;
                }
            }

            return false;
        }
    }
    
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if(cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if(!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }
    
}
