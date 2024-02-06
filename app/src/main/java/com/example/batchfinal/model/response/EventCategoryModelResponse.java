
package com.example.batchfinal.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventCategoryModelResponse {

    @SerializedName("eventCategoryID")
    @Expose
    public Integer eventCategoryID;
    @SerializedName("eventCategoryNameEnglish")
    @Expose
    public String eventCategoryNameEnglish;
    @SerializedName("eventCategoryNameArabic")
    @Expose
    public String eventCategoryNameArabic;
    @SerializedName("language")
    @Expose
    public String language;

}
