package com.fangye.serialization.entity;

import java.util.List;

/**
 * array的实体类
 * [{"id":"111","name":"ssss","list1":[{"cc":"1111"},{"cc":"2222"}],"list2":[{"cc":"1111"},{"cc":"2222"}],"list3":[{"cc":"1111"},{"cc":"2222"}],"list4":[["11","bb1"],["22","bb2"]],"list5":[["11","bb1"],["22","bb2"]],"list6":[[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]],"list7":[[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]],"list8":[[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]],"list9":[[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]],"list10":[[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]],"list11":[[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]],"list12":[[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]],"list13":[[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]],"list14":[[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]]}]
 *
 */
public class ArrayEntity {


    /**
     * id : 111
     * name : ssss
     * list1 : [{"cc":"1111"},{"cc":"2222"}]
     * list2 : [{"cc":"1111"},{"cc":"2222"}]
     * list3 : [{"cc":"1111"},{"cc":"2222"}]
     * list4 : [["11","bb1"],["22","bb2"]]
     * list5 : [["11","bb1"],["22","bb2"]]
     * list6 : [[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]]
     * list7 : [[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]]
     * list8 : [[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]]
     * list9 : [[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]]
     * list10 : [[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]]
     * list11 : [[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]]
     * list12 : [[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]]
     * list13 : [[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]]
     * list14 : [[{"id":"11","tab":"bb1"}],[{"id":"22","tab":"bb2"}]]
     */

    private String id;
    private String name;
    private List<List1Bean> list1;
    private List<List2Bean> list2;
    private List<List3Bean> list3;
    private List<List<String>> list4;
    private List<List<String>> list5;
    private List<List<List6Bean>> list6;
    private List<List<List7Bean>> list7;
    private List<List<List8Bean>> list8;
    private List<List<List9Bean>> list9;
    private List<List<List10Bean>> list10;
    private List<List<List11Bean>> list11;
    private List<List<List12Bean>> list12;
    private List<List<List13Bean>> list13;
    private List<List<List14Bean>> list14;

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

    public List<List1Bean> getList1() {
        return list1;
    }

    public void setList1(List<List1Bean> list1) {
        this.list1 = list1;
    }

    public List<List2Bean> getList2() {
        return list2;
    }

    public void setList2(List<List2Bean> list2) {
        this.list2 = list2;
    }

    public List<List3Bean> getList3() {
        return list3;
    }

    public void setList3(List<List3Bean> list3) {
        this.list3 = list3;
    }

    public List<List<String>> getList4() {
        return list4;
    }

    public void setList4(List<List<String>> list4) {
        this.list4 = list4;
    }

    public List<List<String>> getList5() {
        return list5;
    }

    public void setList5(List<List<String>> list5) {
        this.list5 = list5;
    }

    public List<List<List6Bean>> getList6() {
        return list6;
    }

    public void setList6(List<List<List6Bean>> list6) {
        this.list6 = list6;
    }

    public List<List<List7Bean>> getList7() {
        return list7;
    }

    public void setList7(List<List<List7Bean>> list7) {
        this.list7 = list7;
    }

    public List<List<List8Bean>> getList8() {
        return list8;
    }

    public void setList8(List<List<List8Bean>> list8) {
        this.list8 = list8;
    }

    public List<List<List9Bean>> getList9() {
        return list9;
    }

    public void setList9(List<List<List9Bean>> list9) {
        this.list9 = list9;
    }

    public List<List<List10Bean>> getList10() {
        return list10;
    }

    public void setList10(List<List<List10Bean>> list10) {
        this.list10 = list10;
    }

    public List<List<List11Bean>> getList11() {
        return list11;
    }

    public void setList11(List<List<List11Bean>> list11) {
        this.list11 = list11;
    }

    public List<List<List12Bean>> getList12() {
        return list12;
    }

    public void setList12(List<List<List12Bean>> list12) {
        this.list12 = list12;
    }

    public List<List<List13Bean>> getList13() {
        return list13;
    }

    public void setList13(List<List<List13Bean>> list13) {
        this.list13 = list13;
    }

    public List<List<List14Bean>> getList14() {
        return list14;
    }

    public void setList14(List<List<List14Bean>> list14) {
        this.list14 = list14;
    }

    public static class List1Bean {
        /**
         * cc : 1111
         */

        private String cc;

        public String getCc() {
            return cc;
        }

        public void setCc(String cc) {
            this.cc = cc;
        }
    }

    public static class List2Bean {
        /**
         * cc : 1111
         */

        private String cc;

        public String getCc() {
            return cc;
        }

        public void setCc(String cc) {
            this.cc = cc;
        }
    }

    public static class List3Bean {
        /**
         * cc : 1111
         */

        private String cc;

        public String getCc() {
            return cc;
        }

        public void setCc(String cc) {
            this.cc = cc;
        }
    }

    public static class List6Bean {
        /**
         * id : 11
         * tab : bb1
         */

        private String id;
        private String tab;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }
    }

    public static class List7Bean {
        /**
         * id : 11
         * tab : bb1
         */

        private String id;
        private String tab;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }
    }

    public static class List8Bean {
        /**
         * id : 11
         * tab : bb1
         */

        private String id;
        private String tab;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }
    }

    public static class List9Bean {
        /**
         * id : 11
         * tab : bb1
         */

        private String id;
        private String tab;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }
    }

    public static class List10Bean {
        /**
         * id : 11
         * tab : bb1
         */

        private String id;
        private String tab;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }
    }

    public static class List11Bean {
        /**
         * id : 11
         * tab : bb1
         */

        private String id;
        private String tab;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }
    }

    public static class List12Bean {
        /**
         * id : 11
         * tab : bb1
         */

        private String id;
        private String tab;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }
    }

    public static class List13Bean {
        /**
         * id : 11
         * tab : bb1
         */

        private String id;
        private String tab;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }
    }

    public static class List14Bean {
        /**
         * id : 11
         * tab : bb1
         */

        private String id;
        private String tab;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }
    }
}
