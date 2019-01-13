package com.Exercise10.Classes;

import com.Exercise10.Annotations.Column;
import com.Exercise10.Annotations.Table;

@Table(tb_name = "Person")
public class TBL {
    @Column(cl_name = "Age")
    int age;
    @Column(cl_name = "Name")
    String name;
    @Column(cl_name = "FamilyName")
    String familyName;
    @Column(cl_name = "National_Code")
    String SSN;

    public TBL(int age, String name, String familyName, String SSN) {
        this.age = age;
        this.name = name;
        this.familyName = familyName;
        this.SSN = SSN;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
}
