package com.yuk.yuuuk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dedi on 17/01/17.
 * That's it
 */

public class PojoEmploye {

    @SerializedName("empId")
    @Expose
    public Integer empId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("designation")
    @Expose
    public String designation;
    @SerializedName("department")
    @Expose
    public String department;
    @SerializedName("salary")
    @Expose
    public Integer salary;
}
