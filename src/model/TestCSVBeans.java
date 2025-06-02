package model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;

public class TestCSVBeans extends CsvToBean {
    @CsvBindByName
    private String track_name;
    @CsvBindByName
    private String track_id;

    public String getTrack_name() {
        return track_name;
    }

    public void setTrack_name(String track_name) {
        this.track_name = track_name;
    }

    public String getTrack_id() {
        return track_id;
    }

    public void setTrack_id(String track_id) {
        this.track_id = track_id;
    }
}
