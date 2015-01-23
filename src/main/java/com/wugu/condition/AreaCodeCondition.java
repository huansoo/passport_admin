package com.wugu.condition;

/**
 * @ClassName: AreaCodeCondition
 * @Description: 行政区划相关插叙
 * @author yangch
 * @date 2014-12-26 
 *
 */
public class AreaCodeCondition extends BaseCondition{

    private static final long serialVersionUID = 1L;

    //行政区划码
    private String xzqh_code;
    //行政区划名称
    private String xzqh_name;
    //父级行政区划码
    private String parent_code;
    
    public String getXzqh_code() {
        return xzqh_code;
    }
    public void setXzqh_code(String xzqh_code) {
        this.xzqh_code = xzqh_code;
    }
    public String getXzqh_name() {
        return xzqh_name;
    }
    public void setXzqh_name(String xzqh_name) {
        this.xzqh_name = xzqh_name;
    }
    public String getParent_code() {
        return parent_code;
    }
    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }
}
