package mx.edu.ittepic.a2_2_5_gestor_pacientes;


public class Paciente {

    /**
     * Define el nombre de la tabla
     */
    public static final String TABLE_PERSON = "paciente";


    /**
     * Define los campos de la tabla
     */
    public static final String ID = "id";
    public static final String LASTNAME = "nombre";
    public static final String FIRSTNAME = "direccion";
    public static final String MIDDLENAME = "telefono";
    public static final String CONTACT = "email";
    public static final String FECHA = "fecha";

    /**
     * Define la cadena SQL para la creación de la tabla
     * ->agregar aquí la otra tabla, Para la version 006
     *
     */
    public static final String CREATE_TABLE_PERSON = "CREATE TABLE " + TABLE_PERSON + "("
            + ID + " INTEGER PRIMARY KEY,"
            + LASTNAME + " TEXT,"
            + FIRSTNAME + " TEXT,"
            + MIDDLENAME + " TEXT,"
            + CONTACT + " TEXT,"
            + FECHA + " TEXT" + ")";
}
