package com.liao.util.enums;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public enum LetterTemplateEnum implements TitleEnum {
    /**签约催告函（适用于认购后不网签的情形）*/
    SIGN_URGE_LETTER("签约催告函"),

    /**签约告知函（适用于限签解除后通知签约的情形）*/
    SIGN_INFORM_LETTER("签约告知函"),

    /**解约告知函（适用于认购后不签约没收定金的情形）*/
    UNWIND_INFORM_LETTER("解约告知函"),

    /**办理按揭催告函（适用于逾期办理按揭手续的情形）*/
    MORTGAGE_URGE_LETTER("办理按揭催告函"),

    /**办理按揭的第二封催告函（适用于逾期办理按揭手续的情形）*/
    MORTGAGE_URGE_LETTER_2("办理按揭的第二封催告函"),

    /**付款催告函（适用于分期付款业主欠款的情形）*/
    PAY_URGE_LETTER("付款催告函");

    /**
     * 展示中文表述
     */

    private String title;

    private LetterTemplateEnum(String title) {
        this.title = title;
    }

    /**
     * 根据枚举名称获取枚举
     *
     * @param enumName 枚举名称
     * @return PictureFolderTypeEnum        对应的枚举值
     */
    public static LetterTemplateEnum getByEnumName(final String enumName) {
        for (LetterTemplateEnum element : values()) {
            if (element.name().equals(enumName)) {
                return element;
            }
        }
        return null;
    }
    public static LetterTemplateEnum getByTitle(final String enumName) {
        for (LetterTemplateEnum element : values()) {
            if (element.getTitle().equals(enumName)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    /**
     * 获取枚举名称和title所有的映射
     *
     * @return
     */
    public static Map<String, String> getName2TitleMap() {

        Map<String, String> name2TitleMap = new LinkedHashMap<>();

        for (LetterTemplateEnum element : values()) {
            name2TitleMap.put(element.name(), element.title);
        }

        return name2TitleMap;
    }
}
