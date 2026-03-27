package co.edu.poli.contexto1.vista;

import co.edu.poli.contexto1.model.*;
import co.edu.poli.contexto1.servicios.ImplementacionOperacionCRUD;

public class Principal {

    // PUNTO 2 - MÉTODO POLIMÓRFICO QUE RECIBE Persona como parámetro
    public static void mostrarImc(Persona p) {
        System.out.println("   [" + p.getClass().getSimpleName() + "] "
                + p.getNombre() + " -> IMC: " + String.format("%.4f", p.calcularImc()));
    }

    // PUNTO 2 - MÉTODO POLIMÓRFICO QUE RETORNA tipo Persona
    public static Persona crearPersona(String nombre, String id, double peso,
                                        double estatura, int edad, String grupoSanguineo,
                                        String certificado, String correo) {
        return new Instructor(nombre, id, peso, estatura, edad, grupoSanguineo, certificado, correo);
    }

    public static void main(String[] args) {

        System.out.println("=============================================================");
        System.out.println("       SISTEMA DE GESTIÓN - CONTEXTO 1");
        System.out.println("=============================================================");

        // ---------------------------------------------------------------
        // PUNTO 3: SOBREESCRITURA Y SOBRECARGA DE MÉTODOS
        // ---------------------------------------------------------------
        System.out.println("\n--- PUNTO 3: SOBREESCRITURA Y SOBRECARGA DE MÉTODOS ---\n");

        Enfermedad enf1 = new Enfermedad("Diabetes", "Metformina", "Controlada",
                "Hospital Central", "2023-05-10", "Dr. Pérez");

        Usuario usuario1 = new Usuario("Carlos Gómez", "1001", 80.0, 1.75,
                30, "O+", new Enfermedad[]{enf1});

        Instructor instructor1 = new Instructor("Laura Martínez", "2001", 65.0,
                1.68, 28, "A+", "CERT-001", "laura@gym.com");

        System.out.println(">> SOBREESCRITURA de calcularImc():");
        System.out.println("   Usuario (calcularImc original): "
                + String.format("%.4f", usuario1.calcularImc()));
        System.out.println("   Instructor (calcularImc sobreescrito *0.95): "
                + String.format("%.4f", instructor1.calcularImc()));

        System.out.println("\n>> SOBRECARGA de actualizarPerfil():");
        double imcSobreCarga1 = usuario1.actualizarPerfil(75.0);
        System.out.println("   actualizarPerfil(nuevoPeso=75.0) -> nuevo IMC: "
                + String.format("%.4f", imcSobreCarga1));
        double imcSobreCarga2 = usuario1.actualizarPerfil(70.0, 1.70);
        System.out.println("   actualizarPerfil(nuevoPeso=70.0, nuevaAltura=1.70) -> nuevo IMC: "
                + String.format("%.4f", imcSobreCarga2));

        // ---------------------------------------------------------------
        // PUNTO 4: MODIFICACIÓN DEL ATRIBUTO ESTÁTICO
        // ---------------------------------------------------------------
        System.out.println("\n--- PUNTO 4: ATRIBUTO ESTÁTICO EN TURNO (capacidadMaxima) ---\n");

        Traje traje1 = new Traje("Licra", "T001", "disponible", "M", "Deportivo");
        Maquina maquina1 = new Maquina("TechnoGym", "50kg", "Negro", "Bueno",
                "Acero", "MAQ-01", "100kg", 9.8, new Traje[]{traje1});

        Turno turno1 = new Turno("Turno Mañana", "TUR-01", 0, 0, 0, "N/A",
                "Lunes", "Sala A", "Azul", "Activo", 101, maquina1, instructor1, "06:00");
        Turno turno2 = new Turno("Turno Tarde", "TUR-02", 0, 0, 0, "N/A",
                "Martes", "Sala B", "Verde", "Activo", 102, maquina1, instructor1, "14:00");
        Turno turno3 = new Turno("Turno Noche", "TUR-03", 0, 0, 0, "N/A",
                "Miércoles", "Sala C", "Rojo", "Activo", 103, maquina1, instructor1, "19:00");

        System.out.println("Valor inicial capacidadMaxima (todos los turnos):");
        System.out.println("   turno1 -> " + Turno.getCapacidadMaxima());
        System.out.println("   turno2 -> " + Turno.getCapacidadMaxima());
        System.out.println("   turno3 -> " + Turno.getCapacidadMaxima());

        System.out.println("\nModificando capacidadMaxima a 20 usando Turno.setCapacidadMaxima(20)...");
        Turno.setCapacidadMaxima(20);

        System.out.println("\nValor DESPUÉS de modificar (todos los objetos reflejan el cambio):");
        System.out.println("   turno1 -> " + Turno.getCapacidadMaxima());
        System.out.println("   turno2 -> " + Turno.getCapacidadMaxima());
        System.out.println("   turno3 -> " + Turno.getCapacidadMaxima());
        System.out.println("   >> Todos comparten el mismo valor: "
                + (Turno.getCapacidadMaxima() == 20 ? "CORRECTO ✔" : "ERROR ✘"));

        // ---------------------------------------------------------------
        // PUNTO 5: CREACIÓN Y PRESENTACIÓN POR CONSOLA DE OBJETOS
        // ---------------------------------------------------------------
        System.out.println("\n--- PUNTO 5: OBJETOS TIPO REGISTRO Y TURNO ---\n");

        Usuario usuario2 = new Usuario("Pedro López", "3002", 75.0, 1.78, 17, "A-", null);
        Usuario usuario3 = new Usuario("María Ruiz", "3003", 55.0, 1.58, 32, "AB+", null);

        Registro registro1 = new Registro(usuario1, "ana@email.com", "Calle 10 #20-30", 300123, "Colombia");
        Registro registro2 = new Registro(usuario2, "pedro@email.com", "Av. Principal #5-15", 31098, "Colombia");
        Registro registro3 = new Registro(usuario3, "maria@email.com", "Carrera 7 #45-60", 320765, "Colombia");

        System.out.println(">> Objetos tipo REGISTRO creados:");
        System.out.println("   " + registro1);
        System.out.println("   esMayorDeEdad: " + registro1.esMayorDeEdad("2024-01-01"));
        System.out.println();
        System.out.println("   " + registro2);
        System.out.println("   esMayorDeEdad: " + registro2.esMayorDeEdad("2024-01-01"));
        System.out.println();
        System.out.println("   " + registro3);
        System.out.println("   esMayorDeEdad: " + registro3.esMayorDeEdad("2024-01-01"));

        System.out.println("\n>> Objetos tipo TURNO creados:");
        System.out.println("   " + turno1);
        System.out.println("   quedanCupos: " + turno1.quedanCupos());
        System.out.println();
        System.out.println("   " + turno2);
        System.out.println("   quedanCupos: " + turno2.quedanCupos());
        System.out.println();
        System.out.println("   " + turno3);
        System.out.println("   quedanCupos: " + turno3.quedanCupos());

        // ---------------------------------------------------------------
        // NUEVO PUNTO 1: ARREGLO DE TIPO SUPERSUPERCLASE Persona[5]
        // ---------------------------------------------------------------
        System.out.println("\n--- NUEVO PUNTO 1: ARREGLO Persona[5] ---\n");

        Persona[] personas = new Persona[5];
        personas[0] = new Usuario("Luis Herrera", "4001", 78.0, 1.80, 27, "O+", null);
        personas[1] = new Instructor("Diana Suárez", "5001", 62.0, 1.65, 31, "A+", "CERT-002", "diana@gym.com");
        personas[2] = new Usuario("Sofía Reyes", "4002", 55.0, 1.62, 22, "B+", null);
        personas[3] = null;
        personas[4] = null;

        System.out.println("Recorriendo Persona[5] - sobreescritura de calcularImc():");
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                System.out.println("   [" + i + "] " + personas[i].getClass().getSimpleName()
                        + " | " + personas[i].getNombre()
                        + " | calcularImc() = " + String.format("%.4f", personas[i].calcularImc()));
            } else {
                System.out.println("   [" + i + "] null");
            }
        }

        // ---------------------------------------------------------------
        // NUEVO PUNTO 2: MÉTODOS POLIMÓRFICOS
        // ---------------------------------------------------------------
        System.out.println("\n--- NUEVO PUNTO 2: MÉTODOS POLIMÓRFICOS ---\n");

        System.out.println(">> mostrarImc(Persona p):");
        mostrarImc(personas[0]);
        mostrarImc(personas[1]);
        mostrarImc(personas[2]);

        System.out.println("\n>> crearPersona() retorna tipo Persona, objeto real es Instructor:");
        Persona nueva = crearPersona("Roberto Díaz", "8001", 82.0, 1.78, 36, "O-", "CERT-003", "roberto@gym.com");
        System.out.println("   Tipo declarado : Persona");
        System.out.println("   Tipo real      : " + nueva.getClass().getSimpleName());
        System.out.println("   calcularImc()  : " + String.format("%.4f", nueva.calcularImc()) + " (sobreescrito *0.95)");

        // ---------------------------------------------------------------
        // NUEVO PUNTO 3: EVIDENCIA DE final
        //   ATRIBUTO FINAL -> Persona.java: private final String grupoSanguineo
        //   MÉTODO FINAL   -> Instructor.java: public final String toString()
        //   CLASE FINAL    -> UsuarioVip.java: final class UsuarioVip
        // ---------------------------------------------------------------
        System.out.println("\n--- NUEVO PUNTO 3: ATRIBUTO FINAL, MÉTODO FINAL, CLASE FINAL ---\n");

        System.out.println(">> Atributo final grupoSanguineo (Persona.java):");
        System.out.println("   usuario1 grupoSanguineo = " + usuario1.getGrupoSanguineo()
                + " (no tiene setter, no puede cambiar)");

        System.out.println("\n>> Método final toString() en Instructor (Instructor.java):");
        System.out.println("   " + instructor1);

        System.out.println("\n>> Clase final UsuarioVip (UsuarioVip.java):");
        System.out.println("   final class UsuarioVip -> no puede ser heredada");

        // ---------------------------------------------------------------
        // CRUD: OPERACIONES SOBRE ImplementacionOperacionCRUD
        // Arreglo inicial tamaño 2, crece dinámicamente si se llena.
        // Crear inserta en el primer null de izquierda a derecha.
        // Leer, modificar y eliminar operan por ID del objeto.
        // ---------------------------------------------------------------
        System.out.println("\n=============================================================");
        System.out.println("       CRUD - ImplementacionOperacionCRUD");
        System.out.println("=============================================================\n");

        ImplementacionOperacionCRUD crud = new ImplementacionOperacionCRUD();

        // --- CREAR ---
        System.out.println("--- CREAR ---\n");

        // Inserta en posicion [0]
        System.out.println(crud.crear(new Usuario("Ana Torres", "101", 60.0, 1.62, 25, "B+", null)));
        // Inserta en posicion [1]
        System.out.println(crud.crear(new Instructor("Juan Pérez", "102", 75.0, 1.78, 35, "O+", "CERT-010", "juan@gym.com")));
        // Arreglo lleno, crece y agrega en posicion [2]
        System.out.println(crud.crear(new Usuario("Lucas Mora", "103", 70.0, 1.70, 29, "A-", null)));
        // ID duplicado: debe mostrar error
        System.out.println(crud.crear(new Usuario("Copia", "101", 50.0, 1.55, 20, "AB+", null)));

        // --- LEER TODOS ---
        System.out.println("\n--- LEER TODOS ---\n");
        Persona[] todos = crud.leerTodos();
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] != null) {
                System.out.println("   [" + i + "] " + todos[i].obtenerInfo());
            } else {
                System.out.println("   [" + i + "] null");
            }
        }

        // --- LEER POR ÍNDICE ---
        System.out.println("\n--- LEER POR ÍNDICE ---\n");
        Persona leido = crud.leer(1);
        System.out.println("   leer(1) -> " + (leido != null ? leido.obtenerInfo() : "null"));
        Persona fueraRango = crud.leer(10);
        System.out.println("   leer(10) -> " + (fueraRango != null ? fueraRango.obtenerInfo() : "Indice fuera de rango"));

        // --- MODIFICAR POR ID ---
        System.out.println("\n--- MODIFICAR POR ID ---\n");
        // Modifica el objeto con ID 102
        System.out.println(crud.modificar(102, new Instructor("Juan Pérez Actualizado", "102", 78.0, 1.80, 36, "O+", "CERT-010-NEW", "juan_new@gym.com")));
        // ID que no existe
        System.out.println(crud.modificar(999, new Usuario("No existe", "999", 50.0, 1.60, 20, "A+", null)));

        // --- LEER TODOS TRAS MODIFICAR ---
        System.out.println("\n--- ESTADO TRAS MODIFICAR ---\n");
        todos = crud.leerTodos();
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] != null) {
                System.out.println("   [" + i + "] " + todos[i].obtenerInfo());
            } else {
                System.out.println("   [" + i + "] null");
            }
        }

        // --- ELIMINAR POR ID ---
        System.out.println("\n--- ELIMINAR POR ID ---\n");
        // Elimina el objeto con ID 101
        System.out.println(crud.eliminar(0, 101));
        // ID que no existe
        System.out.println(crud.eliminar(0, 999));

        // --- LEER TODOS TRAS ELIMINAR ---
        System.out.println("\n--- ESTADO TRAS ELIMINAR ---\n");
        todos = crud.leerTodos();
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] != null) {
                System.out.println("   [" + i + "] " + todos[i].obtenerInfo());
            } else {
                System.out.println("   [" + i + "] null");
            }
        }

        // --- CREAR EN EL NULL QUE DEJÓ LA ELIMINACIÓN ---
        System.out.println("\n--- CREAR TRAS ELIMINACIÓN (debe ocupar el null liberado) ---\n");
        System.out.println(crud.crear(new Usuario("Nuevo Usuario", "104", 65.0, 1.68, 27, "B-", null)));
        todos = crud.leerTodos();
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] != null) {
                System.out.println("   [" + i + "] " + todos[i].obtenerInfo());
            } else {
                System.out.println("   [" + i + "] null");
            }
        }

        System.out.println("\n=============================================================");
        System.out.println("       FIN DE EJECUCIÓN");
        System.out.println("=============================================================");
    }
}