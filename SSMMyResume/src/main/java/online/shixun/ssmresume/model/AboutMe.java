package online.shixun.ssmresume.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class AboutMe implements Serializable {

    private Long id;


    private Date createtime=new Date();


    private String language="zh_CN";

    private String name;

    private String gender="Male";

    private Date birthday;


    private String motto;

    private String residence;

    private String email;

    private String mobile;

    private String workingyears;


    private Long educationDegreeId;

    //学历
    private EducationDegree educationDegree;

    //工作状态
    private WorkingStatus workingStatus;


    private Long workingStatusId;

    private String resumefile;


    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }


    public Date getBirthday() {
        return birthday;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto == null ? null : motto.trim();
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence == null ? null : residence.trim();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getWorkingyears() {
        return workingyears;
    }

    public void setWorkingyears(String workingyears) {
        this.workingyears = workingyears == null ? null : workingyears.trim();
    }


    public Long getEducationDegreeId() {
        return educationDegreeId;
    }


    public void setEducationDegreeId(Long educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }



    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public WorkingStatus getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(WorkingStatus workingStatus) {
        this.workingStatus = workingStatus;
    }



    public Long getWorkingStatusId() {
        return workingStatusId;
  }


    public void setWorkingStatusId(Long workingStatusId) {
        this.workingStatusId = workingStatusId;
    }

    public String getResumefile() {
        return resumefile;
    }


    public void setResumefile(String resumefile) {
        this.resumefile = resumefile == null ? null : resumefile.trim();
    }

    public AboutMe() {
    }

    public AboutMe(Long id) {
        this.id = id;
    }

    public AboutMe(String name, String gender, String motto, String residence, String email, String mobile, String workingyears, EducationDegree educationDegree, WorkingStatus workingStatus) {

        this.name = name;
        this.gender = gender;
        this.motto = motto;
        this.residence = residence;
        this.email = email;
        this.mobile = mobile;
        this.workingyears = workingyears;
        this.educationDegree = educationDegree;
        this.workingStatus = workingStatus;
    }

    public AboutMe(String name, String gender, String motto, String residence, String email, String mobile, String workingyears) {

        this.name = name;
        this.gender = gender;
        this.motto = motto;
        this.residence = residence;
        this.email = email;
        this.mobile = mobile;
        this.workingyears = workingyears;
    }

    @Override
    public String toString() {
        return "AboutMe{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", motto='" + motto + '\'' +
                ", residence='" + residence + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", workingyears='" + workingyears + '\'' +

                ", educationDegree=" + educationDegree.getId()+
                ", educationDegree=" + educationDegree.getName() +
                ", workingStatus=" + workingStatus.getId() +
                ", workingStatus=" + workingStatus.getName() +
                ", resumefile='" + resumefile + '\'' +
                '}';
    }
}