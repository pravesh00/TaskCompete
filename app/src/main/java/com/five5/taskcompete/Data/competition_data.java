package com.five5.taskcompete.Data;

import java.util.ArrayList;

public class competition_data {
    String comp_name,comp_days;
    ArrayList<User_data> participatingUsers;

    public competition_data(String comp_name, String comp_days, ArrayList<User_data> participatingUsers) {
        this.comp_name = comp_name;
        this.comp_days = comp_days;
        this.participatingUsers = participatingUsers;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getComp_days() {
        return comp_days;
    }

    public void setComp_days(String comp_days) {
        this.comp_days = comp_days;
    }

    public ArrayList<User_data> getParticipatingUsers() {
        return participatingUsers;
    }

    public void setParticipatingUsers(ArrayList<User_data> participatingUsers) {
        this.participatingUsers = participatingUsers;
    }
}
