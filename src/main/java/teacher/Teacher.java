package teacher;

public class Teacher {
    private String nombre;
    private int tipo;
    private int salarioBaseMensual =2000;
    private int comision = 500;
    private int bonus = 100;
    static final int PROFESOR_TP = 0;
    static final int PROFESOR_TC = 1;
    static final int ADMINISTRATIVO = 2;
    public Teacher(int type, String nombre) {
        this.tipo = type;
        this.nombre = nombre;
    }

    public String getTeacherName() {
        return this.nombre;
    }

    int sueldo() throws ExceptionInInitializerError {
        switch (this.tipo) {
            case PROFESOR_TP:
                return salarioBaseMensual;
            case PROFESOR_TC:
                return salarioBaseMensual + comision;
            case ADMINISTRATIVO:
                return salarioBaseMensual + bonus;
            default:
                throw new ExceptionInInitializerError("Empleado incorrecto");
        }
    }
}
