package online.shixun.ssmresume.model;

import java.util.Date;


public class SendEmail {

    private Long id;

    private String lookerName;

    private String lookerEmail;

    private String lookerPhone;

    private String lookerMessage;

    private Date sendTime = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLookerName() {
        return lookerName;
    }

    public void setLookerName(String lookerName) {
        this.lookerName = lookerName;
    }

    public String getLookerEmail() {
        return lookerEmail;
    }

    public void setLookerEmail(String lookerEmail) {
        this.lookerEmail = lookerEmail;
    }

    public String getLookerPhone() {
        return lookerPhone;
    }

    public void setLookerPhone(String lookerPhone) {
        this.lookerPhone = lookerPhone;
    }

    public String getLookerMessage() {
        return lookerMessage;
    }

    public void setLookerMessage(String lookerMessage) {
        this.lookerMessage = lookerMessage;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public SendEmail(Long id, String lookerName, String lookerEmail, String lookerPhone, String lookerMessage, Date sendTime) {
        this.id = id;
        this.lookerName = lookerName;
        this.lookerEmail = lookerEmail;
        this.lookerPhone = lookerPhone;
        this.lookerMessage = lookerMessage;
        this.sendTime = sendTime;
    }

    public SendEmail(String lookerName, String lookerEmail, String lookerPhone, String lookerMessage, Date sendTime) {
        this.lookerName = lookerName;
        this.lookerEmail = lookerEmail;
        this.lookerPhone = lookerPhone;
        this.lookerMessage = lookerMessage;
        this.sendTime = sendTime;
    }

    public SendEmail(String lookerName, String lookerEmail, String lookerPhone, String lookerMessage) {
        this.lookerName = lookerName;
        this.lookerEmail = lookerEmail;
        this.lookerPhone = lookerPhone;
        this.lookerMessage = lookerMessage;
    }


    public SendEmail(String lookerName, String lookerEmail, String lookerPhone) {
        this.lookerName = lookerName;
        this.lookerEmail = lookerEmail;
        this.lookerPhone = lookerPhone;
    }
    public SendEmail() {
    }

    public SendEmail(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SendEmail{" +
                "id=" + id +
                ", lookerName='" + lookerName + '\'' +
                ", lookerEmail='" + lookerEmail + '\'' +
                ", lookerPhone='" + lookerPhone + '\'' +
                ", lookerMessage='" + lookerMessage + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
