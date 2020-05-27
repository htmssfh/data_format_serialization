package com.fangye.serialization.entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description: TODO 。
 *
 * @ProjectName: LibraryCollection
 * @Package: com.ekwing.librarycollection
 * @Author: shijiaxiong@moyi365.com
 * @UpdateDate: 2020/1/3 12:36
 */
public class NullEntity {
    public String key;
    public String value;
    public boolean cover = true;
    public boolean persistent = false;
    public byte testByte;
    public Short testShort;
    public int testInt;
    public long testLong;
    public float testFloat;
    public double testDouble;
    public String testString;
    public boolean testBoolean;
    public HashMap<String,String> maps;
    public GetDataReq dataReq;
    public ArrayList<GetDataReq> dataReqs;
    public GetDataReq dataReqRight;

    public static class GetDataReq {
        public String key;
        public String callBack;
        public String testNull;
    }
}
