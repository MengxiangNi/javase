package edu.itstudy.model;

import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Movie {
    private int mid;
    private String name;
    private String type;
    private String performer; //电影主演
    private Date date; //上映日期
    private String guider; //导演
    private int clickRate;//点击率(观影后+1)
    private int recommendRate;//推荐率(推荐后+1)
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Movie() {
    }

    public Movie(int mid, String name, String type, String performer, Date date, String guider, int clickRate, int recommendRate) {
        this.mid = mid;
        this.name = name;
        this.type = type;
        this.performer = performer;
        this.date = date;
        this.guider = guider;
        this.clickRate = clickRate;
        this.recommendRate = recommendRate;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public Date getDate() {
        return date;
    }
public String getDateStr(){
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
        return sdf.format(date);
}

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGuider() {
        return guider;
    }

    public void setGuider(String guider) {
        this.guider = guider;
    }

    public int getClickRate() {
        return clickRate;
    }

    public void setClickRate(int clickRate) {
        this.clickRate = clickRate;
    }

    public int getRecommendRate() {
        return recommendRate;
    }

    public void setRecommendRate(int recommendRate) {
        this.recommendRate = recommendRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return mid == movie.mid && clickRate == movie.clickRate && recommendRate == movie.recommendRate && Objects.equals(name, movie.name) && Objects.equals(type, movie.type) && Objects.equals(performer, movie.performer) && Objects.equals(date, movie.date) && Objects.equals(guider, movie.guider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mid, name, type, performer, date, guider, clickRate, recommendRate);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
        return  mid +
                "\t" + name  +
                "\t" + type  +
                "\t" + performer +
                "\t" + guider +
                "\t" +  getDateStr() +
                "\t" + clickRate +
                "\t\t" + recommendRate ;
    }
}
