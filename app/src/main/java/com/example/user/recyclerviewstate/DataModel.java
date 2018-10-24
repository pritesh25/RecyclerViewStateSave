package com.example.user.recyclerviewstate;

class DataModel {

    String name;
    private boolean isChecked;

    public DataModel(String name, boolean isChecked) {
        this.name = name;
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

}