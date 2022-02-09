package com.hm223.md.model;

/**
 * <p>
 * Item
 * </p>
 *
 * @author huwenfeng
 * @date 2022/02/09
 */
public class Item {

    protected String code;
    protected String name;
    protected String body;
    protected Item parentItem;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Item getParentItem() {
        return parentItem;
    }

    public void setParentItem(Item parentItem) {
        this.parentItem = parentItem;
    }

    public Item() {
    }

    public Item(String code, String name, String body) {
        this.code = code;
        this.name = name;
        this.body = body;
    }

    public Item(String code, String name, String body, Item parentItem) {
        this.code = code;
        this.name = name;
        this.body = body;
        this.parentItem = parentItem;
    }
}
