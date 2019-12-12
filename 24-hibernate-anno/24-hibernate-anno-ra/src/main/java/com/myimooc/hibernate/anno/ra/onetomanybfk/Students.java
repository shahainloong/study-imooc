package com.myimooc.hibernate.anno.ra.onetomanybfk;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 一对多双向外键关联
 * 学生实体类（多方）
 *
 * @author ZhangCheng on 2017-07-13
 */
@Entity
public class Students {

    /**
     * 学号
     */
    @Id
    @GeneratedValue
    private Integer sid;
    /**
     * 学生姓名
     */
    private String sname;
    /**
     * 性别
     */
    private String gender;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 专业
     */
    private String major;

    /**
     * 多方持有一方的引用
     * 配置级联关系和抓取策略
     * // 指定外键
     */
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "cid")
    private ClassRoom classRoom;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Students students = (Students) o;
        return Objects.equals(sid, students.sid) &&
                Objects.equals(sname, students.sname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sid, sname);
    }

    @Override
    public String toString() {
        return "Students [sid=" + sid + ", sname=" + ", gender=" + gender + ", birthday=" + birthday
                + ", major=" + major + "]";
    }

    public Students() {
    }

    public Students(String sname, String gender, Date birthday, String major) {
        super();
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
