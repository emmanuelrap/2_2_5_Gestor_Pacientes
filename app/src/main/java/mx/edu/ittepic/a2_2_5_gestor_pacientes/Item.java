package mx.edu.ittepic.a2_2_5_gestor_pacientes;

public class Item {

    private int id;
    private String lastname;
    private String firstname;
    private String middlename;
    private String contact;
    private String fecha;

    public Item(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {this.contact = contact;}

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {this.fecha = fecha;}
}
