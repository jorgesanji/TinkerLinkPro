package com.cronosgroup.tinkerlink.model.dataacess.database.entities;

import com.cronosgroup.tinkerlink.model.dataacess.database.TLDataBase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;

import java.io.Serializable;

/**
 * Created by jorgesanmartin on 24/10/15.
 */

@ModelContainer
@Table(databaseName = TLDataBase.NAME)
public class TLUser extends BaseModel implements Serializable {

    public static final String COLUMN_ID_CONVERSATION = "id_conversation";
    public static final String COLUMN_ID_USER = "id_user";
    public static final String COLUMN_JOB_DESCRIPTION = "jobDescription";

    @PrimaryKey
    @Column(name = COLUMN_ID_USER)
    public String idUser;

    @Column
    public String name;

    @Column
    public String birthday;

    @Column
    public String gender;

    @Column
    public String email;

    @Column
    public String phone;

    @Column
    public String photo;

    @Column
    public boolean loged;

    @Column
    public String visibility;

    @Column
    public String status;

    @Column
    public String skills;

    @Column
    public String education;

    @Column
    public String ocupation;

    @Column
    public String category;

    @Column(name = COLUMN_JOB_DESCRIPTION)
    public String jobDescription;

    @Column
    @ForeignKey(references = {@ForeignKeyReference(columnName = COLUMN_ID_CONVERSATION, columnType = String.class, foreignColumnName = TLConversation.COLUMN_ID)}, saveForeignKeyModel = false)
    ForeignKeyContainer<TLConversation> conversationForeignKeyContainer;

    public TLUser() {
        super();
    }

    public TLUser(String idUser, String name, String birthday, String gender, String email, String phone, String photo, boolean loged, String visibility, String status, String skills, String education, String ocupation, String category, String jobDescription) {
        this.idUser = idUser;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
        this.loged = loged;
        this.visibility = visibility;
        this.status = status;
        this.skills = skills;
        this.education = education;
        this.ocupation = ocupation;
        this.category = category;
        this.jobDescription = jobDescription;
    }

    public boolean getLoged() {
        return loged;
    }

    public void setLoged(boolean loged) {
        this.loged = loged;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public void setConversation(TLConversation conversation) {
        this.conversationForeignKeyContainer = new ForeignKeyContainer<>(TLConversation.class);
        conversationForeignKeyContainer.put(TLConversation$Table.ID, conversation.id);
    }

}
