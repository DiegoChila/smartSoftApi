package com.diego.smarsoft.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Column(name = "id_client")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede ser vacío")
    @Size(min = 4, max = 50, message = "El nombre debe tener entre 4 y 50 caracteres")
    private String name;

    @NotNull(message = "El apellido no puede ser vacío")
    @Size(min = 4, max = 50, message = "El apellido debe tener entre 4 y 50 caracteres")
    private String lastname;

    @NotNull(message = "La dirección no puede ser vacío")
    @Size(min = 4, max = 50, message = "La dirección debe tener entre 4 y 50 caracteres")
    private String address;

    @NotNull(message = "La fecha de nacimiento no puede ser vacío")
    private Date birthday;

    @NotNull(message = "El teléfono no puede ser vacío")
    @Size(min = 4, max = 12, message = "El teléfono debe tener entre 4 y 12 caracteres")
    private String tel;

    @NotNull(message = "El correo electrónico no puede ser vacío")
    @Email(message = "El correo electrónico ingresado no es valido")
    @Size(min = 4, max = 50, message = "El correo electrónico debe tener entre 4 y 50 caracteres")
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Invoice> invoices;

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
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
