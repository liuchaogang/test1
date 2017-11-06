package com.yonyou.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenpana@yonyou.com
 * @ClassName: Constant
 * @Description: 常量类
 * @date 2017/6/28 14:44
 */
@Configuration
@ConfigurationProperties(prefix = "dict")
@PropertySource("classpath:constant_dict.properties")
public class Constant {

    private static String orgCode;

    private static String orgName;

    private static String groupCode;

    private static String groupName;

    private static String otherCardTypeCode;

    private static String otherCardTypeName;

    public static String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public static String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public static String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public static String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public static String getOtherCardTypeCode() {
        return otherCardTypeCode;
    }

    public void setOtherCardTypeCode(String otherCardTypeCode) {
        this.otherCardTypeCode = otherCardTypeCode;
    }

    public static String getOtherCardTypeName() {
        return otherCardTypeName;
    }

    public void setOtherCardTypeName(String otherCardTypeName) {
        this.otherCardTypeName = otherCardTypeName;
    }

    private static Map<String, String> transTypes = new HashMap<String, String>();

    public Map<String, String> getTransTypes() {
        return transTypes;
    }

    public void setTransTypes(Map<String, String> transTypes) {
        Constant.transTypes = transTypes;
    }

    public static String getTransTypeName(String typeCode) {
        if (transTypes.containsKey(typeCode)) {
            return transTypes.get(typeCode);
        }
        return null;
    }

    private static Map<String, String> addrTypes = new HashMap<String, String>();

    public Map<String, String> getAddrTypes() {
        return addrTypes;
    }

    public void setAddrTypes(Map<String, String> addrTypes) {
        this.addrTypes = addrTypes;
    }

    public static String getAddrTypeName(String typeCode) {
        if (addrTypes.containsKey(typeCode)) {
            return addrTypes.get(typeCode);
        }
        return null;
    }

    private static String msgActionAdd;

    private static String msgActionUpdate;

    private static String msgActionCancel;

    private static String msgActionDel;

    public static String getMsgActionAdd() {
        return msgActionAdd;
    }

    public void setMsgActionAdd(String msgActionAdd) {
        Constant.msgActionAdd = msgActionAdd;
    }

    public static String getMsgActionUpdate() {
        return msgActionUpdate;
    }

    public void setMsgActionUpdate(String msgActionUpdate) {
        Constant.msgActionUpdate = msgActionUpdate;
    }

    public static String getMsgActionCancel() {
        return msgActionCancel;
    }

    public void setMsgActionCancel(String msgActionCancel) {
        Constant.msgActionCancel = msgActionCancel;
    }

    public static String getMsgActionDel() {
        return msgActionDel;
    }

    public void setMsgActionDel(String msgActionDel) {
        Constant.msgActionDel = msgActionDel;
    }

    private static String CDAVersionAdd;

    private static String CDAVersionModify;

    public static String getCDAVersionAdd() {
        return CDAVersionAdd;
    }

    public void setCDAVersionAdd(String CDAVersionAdd) {
        Constant.CDAVersionAdd = CDAVersionAdd;
    }

    public static String getCDAVersionModify() {
        return CDAVersionModify;
    }

    public void setCDAVersionModify(String CDAVersionModify) {
        Constant.CDAVersionModify = CDAVersionModify;
    }
    
   private static String  presTypeD;
 
   private static String  presNameD;
   
   private static String presTypeZ;
  
   private static String presNameZ;

public static String getPresTypeD() {
	return presTypeD;
}

public static void setPresTypeD(String presTypeD) {
	Constant.presTypeD = presTypeD;
}

public static String getPresNameD() {
	return presNameD;
}

public static void setPresNameD(String presNameD) {
	Constant.presNameD = presNameD;
}

public static String getPresTypeZ() {
	return presTypeZ;
}

public static void setPresTypeZ(String presTypeZ) {
	Constant.presTypeZ = presTypeZ;
}

public static String getPresNameZ() {
	return presNameZ;
}

public static void setPresNameZ(String presNameZ) {
	Constant.presNameZ = presNameZ;
}


private static String ordTypeCodeS;
private static String ordTypeNameS;
private static String ordTypeCodeR;
private static String ordTypeNameR;

public static String getOrdTypeCodeS() {
	return ordTypeCodeS;
}

public static void setOrdTypeCodeS(String ordTypeCodeS) {
	Constant.ordTypeCodeS = ordTypeCodeS;
}

public static String getOrdTypeNameS() {
	 
	
	return ordTypeNameS;
}

public static void setOrdTypeNameS(String ordTypeNameS) {
	Constant.ordTypeNameS = ordTypeNameS;
}

public static String getOrdTypeCodeR() {
	return ordTypeCodeR;
}

public static void setOrdTypeCodeR(String ordTypeCodeR) {
	Constant.ordTypeCodeR = ordTypeCodeR;
}

public static String getOrdTypeNameR() {
	return ordTypeNameR;
}

public static void setOrdTypeNameR(String ordTypeNameR) {
	Constant.ordTypeNameR = ordTypeNameR;
}
   
}
