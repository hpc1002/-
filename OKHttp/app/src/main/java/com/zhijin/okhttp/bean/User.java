package com.zhijin.okhttp.bean;

import java.util.List;

/**
 * Created by hpc on 2017/1/4.
 */

public class User {
    public int code;
    public Msg msg;
    public String name;
    public String type;
    public List<Course> course;

    public class Msg {
        public String id;
        public String first_name;
        public String last_name;
        public String login;
        public String email;
        public String is_activated;
        public String activated_at;
        public String last_login;
        public String created_at;
        public String updated_at;
        public String is_superuser;
    }

    public class Course {
        public String name;
        public int id;
        public List<Period> period;

        public class Period {
            public int id;
            public int type;
            public int parent_id;
            public int sequence;
            public int course_id;
            public String created_at;
            public String name;
            public String updated_at;
            public int status;
            public Push push;

            public class Push {
                public String url;
                public String secretKey;
            }
        }
    }

}
