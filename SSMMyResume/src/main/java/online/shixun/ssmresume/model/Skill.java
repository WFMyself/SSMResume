package online.shixun.ssmresume.model;

import java.util.Date;


public class Skill {
    private Long id;


    private Date createtime=new Date();


    private String language="zh_CN";

    private String name;

    private Integer level;

    private Integer indexNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public Skill(Long id, Date createtime, String language, String name, Integer level, Integer indexNo) {
        this.id = id;
        this.createtime = createtime;
        this.language = language;
        this.name = name;
        this.level = level;
        this.indexNo = indexNo;
    }

    public Skill(Long id) {
        this.id = id;
    }

    public Skill(Date createtime, String language, String name, Integer level, Integer indexNo) {
        this.createtime = createtime;
        this.language = language;
        this.name = name;
        this.level = level;
        this.indexNo = indexNo;
    }

    public Skill() {
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", createtime=" + createtime +
                ", language='" + language + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", indexNo=" + indexNo +
                '}';
    }
}
