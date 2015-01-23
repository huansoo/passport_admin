package com.wugu.condition;

import java.io.Serializable;

/**
 * @ClassName: ConditionModel
 * @Description: 查询基类
 * @author yangch
 * @date 2014-12-8 
 *
 */
public class BaseCondition implements Serializable{

    private static final long serialVersionUID = 1L;
    //id
    protected String id;
    
    //当前页
    protected Integer page;
    
    //每页记录数
    protected Integer page_size;
    
    //是否有效
    protected Integer type;
    
    //状态
    protected Integer status;
    
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getPage_size() {
        return page_size;
    }
    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }
}
