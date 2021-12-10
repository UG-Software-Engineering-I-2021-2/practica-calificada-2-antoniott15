package student;

public class Student {
    private String nombre;
    private int tipo;
    private int notaBase =11;
    static final int PREGRADO = 0;
    static final int MAESTRIA = 1;
    static final int DOCTORADO = 2;

    Student(int type, String nombre) {
        this.tipo = type;
        this.nombre = nombre;
    }

    String getStudentName() {
        return this.nombre;
    }

    int grado() throws ExceptionInInitializerError {
        switch (this.tipo) {
            case PREGRADO:
                return notaBase;
            case MAESTRIA:
                return notaBase + 1;
            case DOCTORADO:
                return notaBase + 2;
            default:
                throw new ExceptionInInitializerError("Empleado incorrecto");
        }
    }
}
