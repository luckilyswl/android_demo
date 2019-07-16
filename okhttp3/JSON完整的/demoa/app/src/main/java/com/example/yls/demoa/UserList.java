package com.example.yls.demoa;

import java.util.List;

/**
 * Created by yls on 2018/4/11.
 */

public class UserList {

    private List<UserBean> user;

    public List<UserBean> getUser() {
        return user;
    }

    public void setUser(List<UserBean> user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * name : alex
         * age : 18
         * is_man : true
         */

        private String name;
        private String age;
        private boolean is_man;

        public UserBean(String name, String age, boolean is_man) {
            this.name = name;
            this.age = age;
            this.is_man = is_man;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public boolean isIs_man() {
            return is_man;
        }

        public void setIs_man(boolean is_man) {
            this.is_man = is_man;
        }

        @Override
        public String toString() {
            return "姓名"+name+" 年龄"+age + " 是否男" + is_man;
        }
    }
}
