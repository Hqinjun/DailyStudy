package com.hqinjun.Objectclone.DTO;


public class Outputdata implements Cloneable {
    private String cin;
    private String key;
    private String value;
    private String teamKey;
    private String columnName;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(String teamKey) {
        this.teamKey = teamKey;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    @Override
    public Outputdata clone() throws CloneNotSupportedException {
        return (Outputdata) super.clone();
    }
}
