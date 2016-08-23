package com.cronosgroup.tinkerlink.model.dataacess.database.entities;

import com.cronosgroup.tinkerlink.model.dataacess.database.TLDataBase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jorgesanmartin on 8/22/16.
 */

@ModelContainer
@Table(databaseName = TLDataBase.NAME)
public class TLCard extends BaseModel implements Serializable {

    public static final String COLUMN_ID_CARD = "id_card";
    public static final String COLUMN_ID_USER = "id_user";

    @PrimaryKey
    @Column(name = COLUMN_ID_CARD)
    public String id;

    @Column
    public String type;

    public TLUser user;

    @Column
    @ForeignKey(references = {@ForeignKeyReference(columnName = COLUMN_ID_USER, columnType = String.class, foreignColumnName = TLUser.COLUMN_ID_USER)}, saveForeignKeyModel = false)
    public ForeignKeyContainer<TLUser> userForeignKeyContainer;

    @Column
    public String category;

    @Column
    public String description;

    @Column
    public String budget;

    @Column
    public String paymentMethod;

    @Column
    public String profession;

    @Column
    public String country;

    @Column
    public String city;

    @Column
    public double latitude;

    @Column
    public double longitude;

    @Column
    public String skills;

    @Column
    public String timeByProject;

    @Column
    public String experience;

    @Column
    public Date date;

    @Column
    public String recommendations;

    @Column
    public String images;

    public TLCard() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getTimeByProject() {
        return timeByProject;
    }

    public void setTimeByProject(String timeByProject) {
        this.timeByProject = timeByProject;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public TLUser getUser() {
        if (user == null) {
            user = new Select()
                    .from(TLUser.class)
                    .where(Condition.column(TLUser.COLUMN_ID_USER).eq(userForeignKeyContainer.getValue(TLUser$Table.ID_USER))).querySingle();
        }
        return user;
    }

    public void setUserForeignKeyContainer(TLUser user) {
        this.userForeignKeyContainer = new ForeignKeyContainer<>(TLUser.class);
        userForeignKeyContainer.put(TLUser$Table.ID_USER, user.idUser);
    }
}
