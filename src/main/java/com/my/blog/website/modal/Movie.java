package com.my.blog.website.modal;

import java.io.Serializable;
import java.util.Objects;

/**
 * @auther shijx
 * @description 类描述
 * @date 2019/5/9
 */
public class Movie implements Serializable {
    //排片占比
    private String Per_num;
    private String moviename;
    private String movieid;
    private String movienum;

    public String getPer_num() {
        return Per_num;
    }

    public void setPer_num(String per_num) {
        Per_num = per_num;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public String getMovienum() {
        return movienum;
    }

    public void setMovienum(String movienum) {
        this.movienum = movienum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(Per_num, movie.Per_num) &&
                Objects.equals(moviename, movie.moviename) &&
                Objects.equals(movieid, movie.movieid) &&
                Objects.equals(movienum, movie.movienum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Per_num, moviename, movieid, movienum);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Per_num='" + Per_num + '\'' +
                ", moviename='" + moviename + '\'' +
                ", movieid='" + movieid + '\'' +
                ", movienum='" + movienum + '\'' +
                '}';
    }
}
