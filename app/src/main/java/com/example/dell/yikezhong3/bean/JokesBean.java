package com.example.dell.yikezhong3.bean;

import java.util.List;

public class JokesBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"无奈了，不会做咋整","createTime":"2018-04-23T20:01:18","imgUrls":null,"jid":2129,"praiseNum":null,"shareNum":null,"uid":10811,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1526952623567m.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"磊磊落落","createTime":"2018-04-23T19:24:13","imgUrls":null,"jid":2128,"praiseNum":null,"shareNum":null,"uid":11555,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1526802901641avatar.jpg","nickname":"肤白貌美大长腿","praiseNum":"null"}},{"commentNum":null,"content":"呵呵","createTime":"2018-04-23T19:06:09","imgUrls":null,"jid":2127,"praiseNum":null,"shareNum":null,"uid":2561,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"嗜血任心","praiseNum":"null"}},{"commentNum":null,"content":"777777","createTime":"2018-04-23T18:56:58","imgUrls":null,"jid":2126,"praiseNum":null,"shareNum":null,"uid":10851,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15269052424761526905241133.png","nickname":"1盘荣荣","praiseNum":"null"}},{"commentNum":null,"content":"。。。","createTime":"2018-04-23T18:30:59","imgUrls":null,"jid":2125,"praiseNum":null,"shareNum":null,"uid":13315,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524656999155avatar.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"穷的快要吃土了","createTime":"2018-04-23T16:34:14","imgUrls":"https://www.zhaoapi.cn/images/quarter/15244724549073ae33bd8bc3eb135f4018e32a61ea8d3ff1f445a.jpg|https://www.zhaoapi.cn/images/quarter/15244724549133c61f6e54859152.jpg","jid":2124,"praiseNum":null,"shareNum":null,"uid":10811,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1526952623567m.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"你来，我欢迎，你走，我不留","createTime":"2018-04-23T16:33:28","imgUrls":null,"jid":2123,"praiseNum":null,"shareNum":null,"uid":11186,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524970642661gaga_icon.jpg","nickname":"啦啦啦","praiseNum":"null"}},{"commentNum":null,"content":"渣渣辉","createTime":"2018-04-23T16:31:01","imgUrls":null,"jid":2122,"praiseNum":null,"shareNum":null,"uid":11186,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524970642661gaga_icon.jpg","nickname":"啦啦啦","praiseNum":"null"}},{"commentNum":null,"content":"呼叫谢帅康，看到请评论","createTime":"2018-04-23T16:19:15","imgUrls":null,"jid":2121,"praiseNum":null,"shareNum":null,"uid":11186,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524970642661gaga_icon.jpg","nickname":"啦啦啦","praiseNum":"null"}},{"commentNum":null,"content":"底线是一个问题好东西","createTime":"2018-04-23T16:18:17","imgUrls":null,"jid":2120,"praiseNum":null,"shareNum":null,"uid":11186,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524970642661gaga_icon.jpg","nickname":"啦啦啦","praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 无奈了，不会做咋整
         * createTime : 2018-04-23T20:01:18
         * imgUrls : null
         * jid : 2129
         * praiseNum : null
         * shareNum : null
         * uid : 10811
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1526952623567m.jpg","nickname":null,"praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1526952623567m.jpg
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
