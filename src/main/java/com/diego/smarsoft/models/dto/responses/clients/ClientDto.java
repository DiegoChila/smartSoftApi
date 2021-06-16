package com.diego.smarsoft.models.dto.responses.clients;

import java.util.Date;

public class ClientDto {
    private Long id;
    private String completeName;
    private String address;
    private Date birthday;
    private String tel;
    private String email;
    private int invoicesNum;

    public ClientDto(Long id, String completeName, String address, Date birthday, String tel, String email, int invoicesNum) {
        this.id = id;
        this.completeName = completeName;
        this.address = address;
        this.birthday = birthday;
        this.tel = tel;
        this.email = email;
        this.invoicesNum = invoicesNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getInvoicesNum() {
        return invoicesNum;
    }

    public void setInvoicesNum(int invoicesNum) {
        this.invoicesNum = invoicesNum;
    }
}
