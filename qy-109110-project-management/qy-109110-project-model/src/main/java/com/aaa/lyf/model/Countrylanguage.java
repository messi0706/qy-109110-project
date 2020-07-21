package com.aaa.lyf.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Countrylanguage {
    @Id
    @Column(name = "CountryCode")
    private String countrycode;

    @Id
    @Column(name = "Language")
    private String language;

    @Column(name = "IsOfficial")
    private String isofficial;

    @Column(name = "Percentage")
    private Float percentage;

    /**
     * @return CountryCode
     */
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * @param countrycode
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode == null ? null : countrycode.trim();
    }

    /**
     * @return Language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    /**
     * @return IsOfficial
     */
    public String getIsofficial() {
        return isofficial;
    }

    /**
     * @param isofficial
     */
    public void setIsofficial(String isofficial) {
        this.isofficial = isofficial == null ? null : isofficial.trim();
    }

    /**
     * @return Percentage
     */
    public Float getPercentage() {
        return percentage;
    }

    /**
     * @param percentage
     */
    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}