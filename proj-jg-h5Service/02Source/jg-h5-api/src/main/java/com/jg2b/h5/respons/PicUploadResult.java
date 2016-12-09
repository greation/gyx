package com.jg2b.h5.respons;

/**
 * @author gongjp
 * @date 2016-07-05 下午 14:18:21
 */
public class PicUploadResult {
    //错误信息
    private Integer error;
    //url
    private String url;
    //宽度
    private String width;
    //高度
    private String height;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
    
    

}
