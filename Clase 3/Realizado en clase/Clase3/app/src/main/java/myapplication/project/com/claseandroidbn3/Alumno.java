package myapplication.project.com.claseandroidbn3;

/**
 * Created by OSP on 7/06/17.
 */

public class Alumno  {

    private String name;
    private String lastName;
    private String dni;
    private int image;

    public Alumno(String name, String lastName, String dni, int image){
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
