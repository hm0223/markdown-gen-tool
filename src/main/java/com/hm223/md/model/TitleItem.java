package com.hm223.md.model;

/**
 * <p>
 * SimpleItem
 * </p>
 *
 * @author huwenfeng
 * @date 2022/02/09
 */
public class TitleItem extends Item {

    private static final String BACK_TO_TOP_TABLE_OF_CONTENTS = "\r\n[(Back to top)](#table-of-contents)";

    public TitleItem(String code, String name) {
        super(code, name, BACK_TO_TOP_TABLE_OF_CONTENTS);
    }

    @Override
    public String toString() {
        return "TitleItem{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", body='" + body + '\'' +
                ", parentItem=" + parentItem +
                ", backToTopItem='" + BACK_TO_TOP_TABLE_OF_CONTENTS + '\'' +
                '}';
    }
}
