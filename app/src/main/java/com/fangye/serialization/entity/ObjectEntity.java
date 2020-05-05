package com.fangye.serialization.entity;

/**
 * 测试服务端返回 各种数据后 app需要 object 处理的 实体类
 *
 * {"id":"111","title":"培养一种习惯","describe":"","imageUrl":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1588652393&di=798779f1fbc18ed59bca3433c57ca01a&src=http://a2.att.hudong.com/36/48/19300001357258133412489354717.jpg","data1":{"id":"234","name":""},"data2":{"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}},"data3":{"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}},"data4":{"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}},"data5":{"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}},"data6":{"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}},"data7":{"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}},"data8":{"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}},"data9":{"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}},"data10":{"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}}}
 */
public class ObjectEntity {

    /**
     * id : 111
     * title : 培养一种习惯
     * describe :
     * imageUrl : https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1588652393&di=798779f1fbc18ed59bca3433c57ca01a&src=http://a2.att.hudong.com/36/48/19300001357258133412489354717.jpg
     * data1 : {"id":"234","name":""}
     * data2 : {"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}}
     * data3 : {"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}}
     * data4 : {"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}}
     * data5 : {"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}}
     * data6 : {"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}}
     * data7 : {"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}}
     * data8 : {"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}}
     * data9 : {"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}}
     * data10 : {"url":"https://www.baidu.com/event/emlesson","intentData":{"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}}
     */

    private String id;
    private String title;
    private String describe;
    private String imageUrl;
    private Data1Bean data1;
    private Data2Bean data2;
    private Data3Bean data3;
    private Data4Bean data4;
    private Data5Bean data5;
    private Data6Bean data6;
    private Data7Bean data7;
    private Data8Bean data8;
    private Data9Bean data9;
    private Data10Bean data10;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Data1Bean getData1() {
        return data1;
    }

    public void setData1(Data1Bean data1) {
        this.data1 = data1;
    }

    public Data2Bean getData2() {
        return data2;
    }

    public void setData2(Data2Bean data2) {
        this.data2 = data2;
    }

    public Data3Bean getData3() {
        return data3;
    }

    public void setData3(Data3Bean data3) {
        this.data3 = data3;
    }

    public Data4Bean getData4() {
        return data4;
    }

    public void setData4(Data4Bean data4) {
        this.data4 = data4;
    }

    public Data5Bean getData5() {
        return data5;
    }

    public void setData5(Data5Bean data5) {
        this.data5 = data5;
    }

    public Data6Bean getData6() {
        return data6;
    }

    public void setData6(Data6Bean data6) {
        this.data6 = data6;
    }

    public Data7Bean getData7() {
        return data7;
    }

    public void setData7(Data7Bean data7) {
        this.data7 = data7;
    }

    public Data8Bean getData8() {
        return data8;
    }

    public void setData8(Data8Bean data8) {
        this.data8 = data8;
    }

    public Data9Bean getData9() {
        return data9;
    }

    public void setData9(Data9Bean data9) {
        this.data9 = data9;
    }

    public Data10Bean getData10() {
        return data10;
    }

    public void setData10(Data10Bean data10) {
        this.data10 = data10;
    }

    public static class Data1Bean {
        /**
         * id : 234
         * name :
         */

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Data2Bean {
        /**
         * url : https://www.baidu.com/event/emlesson
         * intentData : {"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}
         */

        private String url;
        private IntentDataBean intentData;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public IntentDataBean getIntentData() {
            return intentData;
        }

        public void setIntentData(IntentDataBean intentData) {
            this.intentData = intentData;
        }

        public static class IntentDataBean {
            /**
             * className_ios : WebViewBaseVC
             * className_android : com.fanye.serialization.MainActivity
             */

            private String className_ios;
            private String className_android;

            public String getClassName_ios() {
                return className_ios;
            }

            public void setClassName_ios(String className_ios) {
                this.className_ios = className_ios;
            }

            public String getClassName_android() {
                return className_android;
            }

            public void setClassName_android(String className_android) {
                this.className_android = className_android;
            }
        }
    }

    public static class Data3Bean {
        /**
         * url : https://www.baidu.com/event/emlesson
         * intentData : {"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}
         */

        private String url;
        private IntentDataBeanX intentData;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public IntentDataBeanX getIntentData() {
            return intentData;
        }

        public void setIntentData(IntentDataBeanX intentData) {
            this.intentData = intentData;
        }

        public static class IntentDataBeanX {
            /**
             * className_ios : WebViewBaseVC
             * className_android : com.fanye.serialization.MainActivity
             */

            private String className_ios;
            private String className_android;

            public String getClassName_ios() {
                return className_ios;
            }

            public void setClassName_ios(String className_ios) {
                this.className_ios = className_ios;
            }

            public String getClassName_android() {
                return className_android;
            }

            public void setClassName_android(String className_android) {
                this.className_android = className_android;
            }
        }
    }

    public static class Data4Bean {
        /**
         * url : https://www.baidu.com/event/emlesson
         * intentData : {"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}
         */

        private String url;
        private IntentDataBeanXX intentData;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public IntentDataBeanXX getIntentData() {
            return intentData;
        }

        public void setIntentData(IntentDataBeanXX intentData) {
            this.intentData = intentData;
        }

        public static class IntentDataBeanXX {
            /**
             * className_ios : WebViewBaseVC
             * className_android : com.fanye.serialization.MainActivity
             */

            private String className_ios;
            private String className_android;

            public String getClassName_ios() {
                return className_ios;
            }

            public void setClassName_ios(String className_ios) {
                this.className_ios = className_ios;
            }

            public String getClassName_android() {
                return className_android;
            }

            public void setClassName_android(String className_android) {
                this.className_android = className_android;
            }
        }
    }

    public static class Data5Bean {
        /**
         * url : https://www.baidu.com/event/emlesson
         * intentData : {"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}
         */

        private String url;
        private IntentDataBeanXXX intentData;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public IntentDataBeanXXX getIntentData() {
            return intentData;
        }

        public void setIntentData(IntentDataBeanXXX intentData) {
            this.intentData = intentData;
        }

        public static class IntentDataBeanXXX {
            /**
             * className_ios : WebViewBaseVC
             * className_android : com.fanye.serialization.MainActivity
             */

            private String className_ios;
            private String className_android;

            public String getClassName_ios() {
                return className_ios;
            }

            public void setClassName_ios(String className_ios) {
                this.className_ios = className_ios;
            }

            public String getClassName_android() {
                return className_android;
            }

            public void setClassName_android(String className_android) {
                this.className_android = className_android;
            }
        }
    }

    public static class Data6Bean {
        /**
         * url : https://www.baidu.com/event/emlesson
         * intentData : {"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}
         */

        private String url;
        private IntentDataBeanXXXX intentData;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public IntentDataBeanXXXX getIntentData() {
            return intentData;
        }

        public void setIntentData(IntentDataBeanXXXX intentData) {
            this.intentData = intentData;
        }

        public static class IntentDataBeanXXXX {
            /**
             * className_ios : WebViewBaseVC
             * className_android : com.fanye.serialization.MainActivity
             */

            private String className_ios;
            private String className_android;

            public String getClassName_ios() {
                return className_ios;
            }

            public void setClassName_ios(String className_ios) {
                this.className_ios = className_ios;
            }

            public String getClassName_android() {
                return className_android;
            }

            public void setClassName_android(String className_android) {
                this.className_android = className_android;
            }
        }
    }

    public static class Data7Bean {
        /**
         * url : https://www.baidu.com/event/emlesson
         * intentData : {"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}
         */

        private String url;
        private IntentDataBeanXXXXX intentData;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public IntentDataBeanXXXXX getIntentData() {
            return intentData;
        }

        public void setIntentData(IntentDataBeanXXXXX intentData) {
            this.intentData = intentData;
        }

        public static class IntentDataBeanXXXXX {
            /**
             * className_ios : WebViewBaseVC
             * className_android : com.fanye.serialization.MainActivity
             */

            private String className_ios;
            private String className_android;

            public String getClassName_ios() {
                return className_ios;
            }

            public void setClassName_ios(String className_ios) {
                this.className_ios = className_ios;
            }

            public String getClassName_android() {
                return className_android;
            }

            public void setClassName_android(String className_android) {
                this.className_android = className_android;
            }
        }
    }

    public static class Data8Bean {
        /**
         * url : https://www.baidu.com/event/emlesson
         * intentData : {"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}
         */

        private String url;
        private IntentDataBeanXXXXXX intentData;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public IntentDataBeanXXXXXX getIntentData() {
            return intentData;
        }

        public void setIntentData(IntentDataBeanXXXXXX intentData) {
            this.intentData = intentData;
        }

        public static class IntentDataBeanXXXXXX {
            /**
             * className_ios : WebViewBaseVC
             * className_android : com.fanye.serialization.MainActivity
             */

            private String className_ios;
            private String className_android;

            public String getClassName_ios() {
                return className_ios;
            }

            public void setClassName_ios(String className_ios) {
                this.className_ios = className_ios;
            }

            public String getClassName_android() {
                return className_android;
            }

            public void setClassName_android(String className_android) {
                this.className_android = className_android;
            }
        }
    }

    public static class Data9Bean {
        /**
         * url : https://www.baidu.com/event/emlesson
         * intentData : {"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}
         */

        private String url;
        private IntentDataBeanXXXXXXX intentData;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public IntentDataBeanXXXXXXX getIntentData() {
            return intentData;
        }

        public void setIntentData(IntentDataBeanXXXXXXX intentData) {
            this.intentData = intentData;
        }

        public static class IntentDataBeanXXXXXXX {
            /**
             * className_ios : WebViewBaseVC
             * className_android : com.fanye.serialization.MainActivity
             */

            private String className_ios;
            private String className_android;

            public String getClassName_ios() {
                return className_ios;
            }

            public void setClassName_ios(String className_ios) {
                this.className_ios = className_ios;
            }

            public String getClassName_android() {
                return className_android;
            }

            public void setClassName_android(String className_android) {
                this.className_android = className_android;
            }
        }
    }

    public static class Data10Bean {
        /**
         * url : https://www.baidu.com/event/emlesson
         * intentData : {"className_ios":"WebViewBaseVC","className_android":"com.fanye.serialization.MainActivity"}
         */

        private String url;
        private IntentDataBeanXXXXXXXX intentData;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public IntentDataBeanXXXXXXXX getIntentData() {
            return intentData;
        }

        public void setIntentData(IntentDataBeanXXXXXXXX intentData) {
            this.intentData = intentData;
        }

        public static class IntentDataBeanXXXXXXXX {
            /**
             * className_ios : WebViewBaseVC
             * className_android : com.fanye.serialization.MainActivity
             */

            private String className_ios;
            private String className_android;

            public String getClassName_ios() {
                return className_ios;
            }

            public void setClassName_ios(String className_ios) {
                this.className_ios = className_ios;
            }

            public String getClassName_android() {
                return className_android;
            }

            public void setClassName_android(String className_android) {
                this.className_android = className_android;
            }
        }
    }
}
