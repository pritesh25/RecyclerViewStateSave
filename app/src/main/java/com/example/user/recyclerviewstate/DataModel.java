package com.example.user.recyclerviewstate;

class DataModel {

    private String  name;
    private int     Percentage;
    private boolean isChecked;

    public DataModel(String name, int percentage, boolean isChecked) {
        this.name = name;
        Percentage = percentage;
        this.isChecked = isChecked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getPercentage() {
        return Percentage;
    }

    public void setPercentage(int percentage) {
        Percentage = percentage;
    }
}