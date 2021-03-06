package com.models;

import java.util.Objects;

public class ProductReview {
    private String summary;
    private String thoughts;
    private String nickname;


    public ProductReview() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }
//
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

//    public String getCriteria() {
//        return criteria;
//    }
//
//    public void setCriteria(String criteria) {
//        this.criteria = criteria;
//    }
//
//    public int getNrStars() {
//        return nrStars;
//    }
//
//    public void setNrStars(int nrStars) {
//        this.nrStars = nrStars;
//    }

//    @Override
//    public String toString() {
//        return "ProductReview{" +
//                "summary='" + summary + '\'' +
//                ", thoughts='" + thoughts + '\'' +
//                ", nickname='" + nickname + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "summary='" + summary + '\'' +
                ", thoughts='" + thoughts + '\'' +
                '}';
    }


//TODO define the rest of the fields

}
