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

    // Método auxiliar: pide un double y repite hasta que sea válido
    public static double leerDouble(java.util.Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } catch (java.util.InputMismatchException e) {
                sc.nextLine();
                System.out.println("   Dato no valido, ingrese un numero decimal.");
            }
        }
    }

    // Método auxiliar: pide un int y repite hasta que sea válido
    public static int leerInt(java.util.Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } catch (java.util.InputMismatchException e) {
                sc.nextLine();
                System.out.println("   Dato no valido, ingrese un numero entero.");
            }
        }
    }

    public static void main(String[] args) {

        // =============================================================
        // CÓDIGO DE EJERCICIOS ANTERIORES - COMENTADO (no se ejecuta)
        // =============================================================

//        System.out.println("=============================================================");
//        System.out.println("       SISTEMA DE GESTIÓN - CONTEXTO 1");
//        System.out.println("=============================================================");

//        // ---------------------------------------------------------------
//        // PUNTO 3: SOBREESCRITURA Y SOBRECARGA DE MÉTODOS
//        // ---------------------------------------------------------------
//        System.out.println("\n--- PUNTO 3: SOBREESCRITURA Y SOBRECARGA DE MÉTODOS ---\n");
//
//        Enfermedad enf1 = new Enfermedad("Diabetes", "Metformina", "Controlada",
//                "Hospital Central", "2023-05-10", "Dr. Pérez");
//
//        Usuario usuario1 = new Usuario("Carlos Gómez", "1001", 80.0, 1.75,
//                30, "O+", new Enfermedad[]{enf1});
//
//        Instructor instructor1 = new Instructor("Laura Martínez", "2001", 65.0,
//                1.68, 28, "A+", "CERT-001", "laura@gym.com");
//
//        System.out.println(">> SOBREESCRITURA de calcularImc():");
//        System.out.println("   Usuario (calcularImc original): "
//                + String.format("%.4f", usuario1.calcularImc()));
//        System.out.println("   Instructor (calcularImc sobreescrito *0.95): "
//                + String.format("%.4f", instructor1.calcularImc()));
//
//        System.out.println("\n>> SOBRECARGA de actualizarPerfil():");
//        double imcSobreCarga1 = usuario1.actualizarPerfil(75.0);
//        System.out.println("   actualizarPerfil(nuevoPeso=75.0) -> nuevo IMC: "
//                + String.format("%.4f", imcSobreCarga1));
//        double imcSobreCarga2 = usuario1.actualizarPerfil(70.0, 1.70);
//        System.out.println("   actualizarPerfil(nuevoPeso=70.0, nuevaAltura=1.70) -> nuevo IMC: "
//                + String.format("%.4f", imcSobreCarga2));

//        // ---------------------------------------------------------------
//        // PUNTO 4: MODIFICACIÓN DEL ATRIBUTO ESTÁTICO
//        // ---------------------------------------------------------------
//        System.out.println("\n--- PUNTO 4: ATRIBUTO ESTÁTICO EN TURNO (capacidadMaxima) ---\n");
//
//        Traje traje1 = new Traje("Licra", "T001", "disponible", "M", "Deportivo");
//        Maquina maquina1 = new Maquina("TechnoGym", "50kg", "Negro", "Bueno",
//                "Acero", "MAQ-01", "100kg", 9.8, new Traje[]{traje1});
//
//        Turno turno1 = new Turno("Turno Mañana", "TUR-01", 0, 0, 0, "N/A",
//                "Lunes", "Sala A", "Azul", "Activo", 101, maquina1, instructor1, "06:00");
//        Turno turno2 = new Turno("Turno Tarde", "TUR-02", 0, 0, 0, "N/A",
//                "Martes", "Sala B", "Verde", "Activo", 102, maquina1, instructor1, "14:00");
//        Turno turno3 = new Turno("Turno Noche", "TUR-03", 0, 0, 0, "N/A",
//                "Miércoles", "Sala C", "Rojo", "Activo", 103, maquina1, instructor1, "19:00");
//
//        System.out.println("Valor inicial capacidadMaxima (todos los turnos):");
//        System.out.println("   turno1 -> " + Turno.getCapacidadMaxima());
//        System.out.println("   turno2 -> " + Turno.getCapacidadMaxima());
//        System.out.println("   turno3 -> " + Turno.getCapacidadMaxima());
//
//        System.out.println("\nModificando capacidadMaxima a 20 usando Turno.setCapacidadMaxima(20)...");
//        Turno.setCapacidadMaxima(20);
//
//        System.out.println("\nValor DESPUÉS de modificar (todos los objetos reflejan el cambio):");
//        System.out.println("   turno1 -> " + Turno.getCapacidadMaxima());
//        System.out.println("   turno2 -> " + Turno.getCapacidadMaxima());
//        System.out.println("   turno3 -> " + Turno.getCapacidadMaxima());
//        System.out.println("   >> Todos comparten el mismo valor: "
//                + (Turno.getCapacidadMaxima() == 20 ? "CORRECTO ✔" : "ERROR ✘"));

//        // ---------------------------------------------------------------
//        // PUNTO 5: CREACIÓN Y PRESENTACIÓN POR CONSOLA DE OBJETOS
//        // ---------------------------------------------------------------
//        System.out.println("\n--- PUNTO 5: OBJETOS TIPO REGISTRO Y TURNO ---\n");
//
//        Usuario usuario2 = new Usuario("Pedro López", "3002", 75.0, 1.78, 17, "A-", null);
//        Usuario usuario3 = new Usuario("María Ruiz", "3003", 55.0, 1.58, 32, "AB+", null);
//
//        Registro registro1 = new Registro(usuario1, "ana@email.com", "Calle 10 #20-30", 3001234567, "Colombia");
//        Registro registro2 = new Registro(usuario2, "pedro@email.com", "Av. Principal #5-15", 3109876543, "Colombia");
//        Registro registro3 = new Registro(usuario3, "maria@email.com", "Carrera 7 #45-60", 3207654321, "Colombia");
//
//        System.out.println(">> Objetos tipo REGISTRO creados:");
//        System.out.println("   " + registro1);
//        System.out.println("   esMayorDeEdad: " + registro1.esMayorDeEdad("2024-01-01"));
//        System.out.println();
//        System.out.println("   " + registro2);
//        System.out.println("   esMayorDeEdad: " + registro2.esMayorDeEdad("2024-01-01"));
//        System.out.println();
//        System.out.println("   " + registro3);
//        System.out.println("   esMayorDeEdad: " + registro3.esMayorDeEdad("2024-01-01"));
//
//        System.out.println("\n>> Objetos tipo TURNO creados:");
//        System.out.println("   " + turno1);
//        System.out.println("   quedanCupos: " + turno1.quedanCupos());
//        System.out.println();
//        System.out.println("   " + turno2);
//        System.out.println("   quedanCupos: " + turno2.quedanCupos());
//        System.out.println();
//        System.out.println("   " + turno3);
//        System.out.println("   quedanCupos: " + turno3.quedanCupos());

//        // ---------------------------------------------------------------
//        // NUEVO PUNTO 1: ARREGLO DE TIPO SUPERSUPERCLASE Persona[5]
//        // ---------------------------------------------------------------
//        System.out.println("\n--- NUEVO PUNTO 1: ARREGLO Persona[5] ---\n");
//
//        Persona[] personas = new Persona[5];
//        personas[0] = new Usuario("Luis Herrera", "4001", 78.0, 1.80, 27, "O+", null);
//        personas[1] = new Instructor("Diana Suárez", "5001", 62.0, 1.65, 31, "A+", "CERT-002", "diana@gym.com");
//        personas[2] = new Usuario("Sofía Reyes", "4002", 55.0, 1.62, 22, "B+", null);
//        personas[3] = null;
//        personas[4] = null;
//
//        System.out.println("Recorriendo Persona[5] - sobreescritura de calcularImc():");
//        for (int i = 0; i < personas.length; i++) {
//            if (personas[i] != null) {
//                System.out.println("   [" + i + "] " + personas[i].getClass().getSimpleName()
//                        + " | " + personas[i].getNombre()
//                        + " | calcularImc() = " + String.format("%.4f", personas[i].calcularImc()));
//            } else {
//                System.out.println("   [" + i + "] null");
//            }
//        }

//        // ---------------------------------------------------------------
//        // NUEVO PUNTO 2: MÉTODOS POLIMÓRFICOS
//        // ---------------------------------------------------------------
//        System.out.println("\n--- NUEVO PUNTO 2: MÉTODOS POLIMÓRFICOS ---\n");
//
//        System.out.println(">> mostrarImc(Persona p):");
//        mostrarImc(personas[0]);
//        mostrarImc(personas[1]);
//        mostrarImc(personas[2]);
//
//        System.out.println("\n>> crearPersona() retorna tipo Persona, objeto real es Instructor:");
//        Persona nueva = crearPersona("Roberto Díaz", "8001", 82.0, 1.78, 36, "O-", "CERT-003", "roberto@gym.com");
//        System.out.println("   Tipo declarado : Persona");
//        System.out.println("   Tipo real      : " + nueva.getClass().getSimpleName());
//        System.out.println("   calcularImc()  : " + String.format("%.4f", nueva.calcularImc()) + " (sobreescrito *0.95)");

//        // ---------------------------------------------------------------
//        // NUEVO PUNTO 3: EVIDENCIA DE final
//        //   ATRIBUTO FINAL -> Persona.java: private final String grupoSanguineo
//        //   MÉTODO FINAL   -> Instructor.java: public final String toString()
//        //   CLASE FINAL    -> UsuarioVip.java: final class UsuarioVip
//        // ---------------------------------------------------------------
//        System.out.println("\n--- NUEVO PUNTO 3: ATRIBUTO FINAL, MÉTODO FINAL, CLASE FINAL ---\n");
//
//        System.out.println(">> Atributo final grupoSanguineo (Persona.java):");
//        System.out.println("   usuario1 grupoSanguineo = " + usuario1.getGrupoSanguineo()
//                + " (no tiene setter, no puede cambiar)");
//
//        System.out.println("\n>> Método final toString() en Instructor (Instructor.java):");
//        System.out.println("   " + instructor1);
//
//        System.out.println("\n>> Clase final UsuarioVip (UsuarioVip.java):");
//        System.out.println("   final class UsuarioVip -> no puede ser heredada");

        // ---------------------------------------------------------------
        // CRUD: OPERACIONES SOBRE ImplementacionOperacionCRUD
        // Arreglo inicial tamaño 2, crece dinámicamente si se llena.
        // Crear inserta en el primer null de izquierda a derecha.
        // Leer, modificar y eliminar operan por ID del objeto.
        // ---------------------------------------------------------------
        System.out.println("\n=============================================================");
        System.out.println("       CRUD - MENÚ INTERACTIVO");
        System.out.println("=============================================================\n");

        ImplementacionOperacionCRUD crud = new ImplementacionOperacionCRUD();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n---------------------------------------------");
            System.out.println("  1. Crear        2. Leer todos");
            System.out.println("  3. Leer por indice  4. Modificar por ID");
            System.out.println("  5. Eliminar por ID  6. Serializar");
            System.out.println("  7. Deserializar     0. Salir");
            System.out.println("---------------------------------------------");
            opcion = leerInt(sc, "Ingrese una opcion: ");

            switch (opcion) {

                case 1:
                    try {
                        System.out.println("\n-- CREAR --");
                        int tipo;
                        while (true) {
                            tipo = leerInt(sc, "Tipo (1=Usuario / 2=Instructor): ");
                            if (tipo == 1 || tipo == 2) break;
                            System.out.println("   Tipo no valido. Ingrese 1 para Usuario o 2 para Instructor.");
                        }

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        double peso     = leerDouble(sc, "Peso: ");
                        double estatura = leerDouble(sc, "Estatura: ");
                        int edad        = leerInt(sc, "Edad: ");
                        System.out.print("Grupo sanguineo: ");
                        String grupo = sc.nextLine();

                        if (tipo == 1) {
                            System.out.println(crud.crear(new Usuario(nombre, id, peso, estatura, edad, grupo, null)));
                        } else {
                            System.out.print("Certificado: ");
                            String cert = sc.nextLine();
                            System.out.print("Correo: ");
                            String correoInst = sc.nextLine();
                            System.out.println(crud.crear(new Instructor(nombre, id, peso, estatura, edad, grupo, cert, correoInst)));
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error al crear: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\n-- LEER TODOS --");
                    Persona[] todos = crud.leerTodos();
                    for (int i = 0; i < todos.length; i++) {
                        System.out.println("   [" + i + "] " + (todos[i] != null ? todos[i].obtenerInfo() : "null"));
                    }
                    break;

                case 3:
                    System.out.println("\n-- LEER POR ÍNDICE --");
                    while (true) {
                        int indice = leerInt(sc, "Ingrese el indice: ");
                        Persona leido = crud.leer(indice);
                        if (leido != null) {
                            System.out.println("   " + leido.obtenerInfo());
                            break;
                        } else {
                            System.out.println("   Indice fuera de rango o posicion vacia, intente de nuevo.");
                        }
                    }
                    break;

                case 4:
                    try {
                        System.out.println("\n-- MODIFICAR POR ID --");
                        String idMod;
                        while (true) {
                            System.out.print("ID del objeto a modificar: ");
                            idMod = sc.nextLine();
                            // Verificar que el ID existe antes de continuar
                            boolean encontrado = false;
                            for (Persona p : crud.leerTodos()) {
                                if (p != null && p.getId().equals(idMod)) {
                                    encontrado = true;
                                    break;
                                }
                            }
                            if (encontrado) break;
                            System.out.println("   No existe ningún objeto con ID " + idMod + ", intente de nuevo.");
                        }

                        int tipoMod;
                        while (true) {
                            tipoMod = leerInt(sc, "Tipo del nuevo objeto (1=Usuario / 2=Instructor): ");
                            if (tipoMod == 1 || tipoMod == 2) break;
                            System.out.println("   Tipo no valido. Ingrese 1 para Usuario o 2 para Instructor.");
                        }

                        System.out.print("Nuevo nombre: ");
                        String nomMod = sc.nextLine();
                        double pesoMod = leerDouble(sc, "Nuevo peso: ");
                        double estMod  = leerDouble(sc, "Nueva estatura: ");
                        int edadMod    = leerInt(sc, "Nueva edad: ");
                        System.out.print("Nuevo grupo sanguineo: ");
                        String grupoMod = sc.nextLine();

                        if (tipoMod == 1) {
                            System.out.println(crud.modificar(idMod, new Usuario(nomMod, idMod, pesoMod, estMod, edadMod, grupoMod, null)));
                        } else {
                            System.out.print("Certificado: ");
                            String certMod = sc.nextLine();
                            System.out.print("Correo: ");
                            String correoMod = sc.nextLine();
                            System.out.println(crud.modificar(idMod, new Instructor(nomMod, idMod, pesoMod, estMod, edadMod, grupoMod, certMod, correoMod)));
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error al modificar: " + e.getMessage());
                    } catch (IllegalStateException e) {
                        System.out.println("Error al modificar: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.println("\n-- ELIMINAR POR ID --");
                        String idElim;
                        while (true) {
                            System.out.print("ID del objeto a eliminar: ");
                            idElim = sc.nextLine();
                            boolean encontrado = false;
                            for (Persona p : crud.leerTodos()) {
                                if (p != null && p.getId().equals(idElim)) {
                                    encontrado = true;
                                    break;
                                }
                            }
                            if (encontrado) break;
                            System.out.println("   No existe ningún objeto con ID " + idElim + ", intente de nuevo.");
                        }
                        System.out.println(crud.eliminar(idElim));
                    } catch (IllegalStateException e) {
                        System.out.println("Error al eliminar: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("\n-- SERIALIZAR --");
                    System.out.println(crud.serializar());
                    break;

                case 7:
                    System.out.println("\n-- DESERIALIZAR --");
                    Persona[] deserializado = crud.deserializar();
                    for (int i = 0; i < deserializado.length; i++) {
                        System.out.println("   [" + i + "] " + (deserializado[i] != null ? deserializado[i].obtenerInfo() : "null"));
                    }
                    break;

                case 0:
                    System.out.println("\nSaliendo del menú CRUD...");
                    break;

                default:
                    System.out.println("Opcion no valida, intente de nuevo.");
            }
        }

        sc.close();

        System.out.println("\n=============================================================");
        System.out.println("       FIN DE EJECUCIÓN");
        System.out.println("=============================================================");
    }
}