package com.example.dell.yikezhong3.bean;

import java.util.List;

public class CollectionBean {


    /**
     * msg : 获取收藏列表成功
     * code : 0
     * data : [{"commentNum":1,"comments":[{"cid":239,"content":"1","createTime":"2018-01-10T19:50:05","jid":null,"mvp":null,"nickname":"qqq","praiseNum":0,"uid":71,"wid":100}],"cover":"https://www.zhaoapi.cn/images/quarter/151254972908420171206164052.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":2,"latitude":"40","localUri":null,"longitude":"116","playNum":2,"praiseNum":1,"uid":114,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524014322158007.jpg","nickname":"linnnn","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549729084video_20171206_164024.mp4","wid":100,"workDesc":"发布视频"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151254973144320171206164052.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":1,"latitude":"40","localUri":null,"longitude":"116","playNum":8,"praiseNum":1,"uid":114,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524014322158007.jpg","nickname":"linnnn","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549731443video_20171206_164024.mp4","wid":101,"workDesc":"发布视频"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1525957730921croped_picture.jpeg, B612Kaji_20180509_102618_152.jpg","createTime":"2018-05-10T21:08:50","favoriteNum":1,"latitude":"40","localUri":null,"longitude":null,"playNum":0,"praiseNum":0,"uid":12509,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1523839244885crop_photo.jpg","nickname":"%E5%BC%A0%E9%9C%B2","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1525957730921recording945313512.mp4, recording494819490.mp4","wid":500,"workDesc":"弄"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1525958736834超级截屏_20180430_195808.png","createTime":"2018-05-10T21:25:36","favoriteNum":1,"latitude":"40","localUri":null,"longitude":null,"playNum":0,"praiseNum":1,"uid":12509,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1523839244885crop_photo.jpg","nickname":"%E5%BC%A0%E9%9C%B2","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1525958736834recording-222525867.mp4","wid":501,"workDesc":"王丽花  哈哈哈"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1525958756569超级截屏_20180430_195808.png","createTime":"2018-05-10T21:25:56","favoriteNum":1,"latitude":"40","localUri":null,"longitude":null,"playNum":0,"praiseNum":0,"uid":12509,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1523839244885crop_photo.jpg","nickname":"%E5%BC%A0%E9%9C%B2","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1525958756569recording-222525867.mp4","wid":502,"workDesc":"王丽花  哈哈哈"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1525959079850splash2017-10-01-733-1.jpg, 超级截屏_20180430_195808.png","createTime":"2018-05-10T21:31:19","favoriteNum":1,"latitude":"40","localUri":null,"longitude":null,"playNum":0,"praiseNum":0,"uid":12509,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1523839244885crop_photo.jpg","nickname":"%E5%BC%A0%E9%9C%B2","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1525959079850recording-222525867.mp4, recording986974331.mp4","wid":503,"workDesc":"\n1511j\n大帅哥"}]
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
         * commentNum : 1
         * comments : [{"cid":239,"content":"1","createTime":"2018-01-10T19:50:05","jid":null,"mvp":null,"nickname":"qqq","praiseNum":0,"uid":71,"wid":100}]
         * cover : https://www.zhaoapi.cn/images/quarter/151254972908420171206164052.jpg
         * createTime : 2017-12-17T19:20:44
         * favoriteNum : 2
         * latitude : 40
         * localUri : null
         * longitude : 116
         * playNum : 2
         * praiseNum : 1
         * uid : 114
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524014322158007.jpg","nickname":"linnnn","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1512549729084video_20171206_164024.mp4
         * wid : 100
         * workDesc : 发布视频
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<CommentsBean> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
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

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1524014322158007.jpg
             * nickname : linnnn
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
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

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }

        public static class CommentsBean {
            /**
             * cid : 239
             * content : 1
             * createTime : 2018-01-10T19:50:05
             * jid : null
             * mvp : null
             * nickname : qqq
             * praiseNum : 0
             * uid : 71
             * wid : 100
             */

            private int cid;
            private String content;
            private String createTime;
            private Object jid;
            private Object mvp;
            private String nickname;
            private int praiseNum;
            private int uid;
            private int wid;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
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

            public Object getJid() {
                return jid;
            }

            public void setJid(Object jid) {
                this.jid = jid;
            }

            public Object getMvp() {
                return mvp;
            }

            public void setMvp(Object mvp) {
                this.mvp = mvp;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(int praiseNum) {
                this.praiseNum = praiseNum;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getWid() {
                return wid;
            }

            public void setWid(int wid) {
                this.wid = wid;
            }
        }
    }
}
