package com.android.server.discoveryetc;

public interface ETCTags {

    class OBUTags {
        public static final int ETC_READ_OBU_NUMBER = 0x01;//OBU号
        public static final int ETC_READ_OBU_STATUS = 0x02;//OBU状态
        public static final int ETC_READ_OBU_DATA = 0x03;//OBU有效期
        public static final int ETC_READ_OBU_REMOVE = 0x04;//OBU防拆信息
        public static final int ETC_READ_OBU_VERSION = 0x05;//读取OBU版本
        public static final int ETC_READ_OBU_RAND_SYS = 0x06;//读取写OBU系统信息随机数
        public static final int ETC_READ_OBU_RAND_VEH = 0x07;//读取写OBU车辆信息随机数
        public static final int ETC_READ_OBU_VEH = 0x08;//读取OBU车辆密文信息
        public static final int ETC_WRITE_OBU_SYSINFO = 0x09;//写OBU系统信息
        public static final int ETC_WRITE_OBU_VEHINFO = 0x0A;//写OBU车辆信息
        public static final int ETC_READ_CAT_NUMBER = 0x0B;//读取车牌号
    }

    class CARDTags {
        public static final int ETC_READ_CARD_NUMBER = 0x20;//读取卡号
        public static final int ETC_READ_CARD_TYPE = 0x21;//读取卡片类型
        public static final int ETC_READ_CARD_VERSION = 0x22;//卡片版本号
        public static final int ETC_READ_CARD_STATUS = 0x23;//卡片状态
        public static final int ETC_READ_CARD_MONEY = 0x24;//读取卡片余额
        public static final int ETC_READ_CARD_RAND_SYS = 0x25;//读取写卡片系统信息随机数
        public static final int ETC_READ_CARD_RAND_PERSONAL = 0x26;//读取写卡片个人信息随机数
        public static final int ETC_WRITE_CARD_SYSINFO = 0x27;//写卡片系统信息
        public static final int ETC_WRITE_CARD_PERSONALINFO = 0x28;//写卡片个人信息
    }

    class CREDITTags {
        public static final int ETC_CREDIT_QUERY = 0x40;//圈存查询
        public static final int ETC_CREDIT_INIT = 0x41;//圈存初始化
        public static final int ETC_CREDIT = 0x42;//圈存
    }

}
