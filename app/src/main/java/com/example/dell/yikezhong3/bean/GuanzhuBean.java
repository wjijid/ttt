package com.example.dell.yikezhong3.bean;

import java.util.List;

public class GuanzhuBean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1522676905689nicai","createTime":"2018-04-02T21:48:25","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":null,"uid":10160,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1522676905689recording1122141929.mp4","wid":283,"workDesc":"你猜"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1522676930345nicai","createTime":"2018-04-02T21:48:50","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":null,"uid":10160,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1522676930345recording1122141929.mp4","wid":284,"workDesc":"你好啊"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1522676992111nicai","createTime":"2018-04-02T21:49:52","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":null,"uid":10160,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1522676992111recording1556408929.mp4","wid":285,"workDesc":"啥都不会"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1522677119126nicai","createTime":"2018-04-02T21:51:59","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":2,"praiseNum":null,"uid":10160,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1522677119126recording-2088342775.mp4","wid":286,"workDesc":"啥都不会  这可咋办啊"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1522678265470nicai","createTime":"2018-04-02T22:11:05","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":null,"uid":10160,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1522678265470recording1717061333.mp4","wid":287,"workDesc":"好淡定啊"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1522678290861nicai","createTime":"2018-04-02T22:11:30","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":1,"praiseNum":null,"uid":10160,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1522678290861recording1717061333.mp4","wid":288,"workDesc":"好淡定啊"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1522678300767nicai","createTime":"2018-04-02T22:11:40","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":null,"uid":10160,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1522678300767recording1717061333.mp4","wid":289,"workDesc":"好淡定啊"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1522678571548nicai","createTime":"2018-04-02T22:16:11","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":1,"praiseNum":null,"uid":10160,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1522678571548recording-2116873851.mp4","wid":290,"workDesc":"你好啊"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1522680246811nicai","createTime":"2018-04-02T22:44:06","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":5,"praiseNum":null,"uid":10160,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1522680246811recording-1524479758.mp4","wid":291,"workDesc":"好帅气的小伙子！！"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1522681155279nicai","createTime":"2018-04-02T22:59:15","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":4,"praiseNum":null,"uid":10160,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1522681155279recording-860807532.mp4","wid":292,"workDesc":"吃鸡走一走！！！"}]
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
         * cover : https://www.zhaoapi.cn/images/quarter/1522676905689nicai
         * createTime : 2018-04-02T21:48:25
         * favoriteNum : null
         * latitude : 40
         * localUri : null
         * longitude : 116
         * playNum : 0
         * praiseNum : null
         * uid : 10160
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1522676905689recording1122141929.mp4
         * wid : 283
         * workDesc : 你猜
         */

        private Object commentNum;
        private String cover;
        private String createTime;
        private Object favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private Object praiseNum;
        private int uid;
        private String videoUrl;
        private int wid;
        private String workDesc;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
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

        public Object getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(Object favoriteNum) {
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

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
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
    }
}
