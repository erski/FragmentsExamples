package mmstudio.com.fragmentsexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by milanerski on 28.11.16..
 */

public class Project {

    @SerializedName("id")
    int project_id;

    @SerializedName("name")
    String project_name;

    @SerializedName("full_name")
    String full_name;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
