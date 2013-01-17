package pl.grzejszczak.marcin.drools.springintegration.enums;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
public enum TypeEnum {
    MEDICAL("medical", "aaabbbccc"), ELECTRONIC("electronic", "cccbbbaaa");


    private final String type;
    private final String someOutputString;

    private TypeEnum(String type, String someOutputString) {
        this.type = type;
        this.someOutputString = someOutputString;
    }

    public String getType() {
        return type;
    }

    public String getSomeOutputString() {
        return someOutputString;
    }
}
