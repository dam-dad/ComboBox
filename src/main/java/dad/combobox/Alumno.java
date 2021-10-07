package dad.combobox;

/**
 * Java bean para representar alumnos
 * (Clase con getters y setters para acceder a sus atributos y constructor vacío)
 * @author fvarrui
 */
public class Alumno {

	private String nombre;
	private String apellidos;
	private String cial;
	
	public Alumno() {
		super();
	}
	
	public Alumno(String nombre, String apellidos, String cial) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cial = cial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCial() {
		return cial;
	}

	public void setCial(String cial) {
		this.cial = cial;
	}

	@Override
	public String toString() {
		return apellidos + ", " + nombre;
	}

}


