package net.ausiasmarch.calculadoracal.mod;

/**
 *
 * @author carmendwhipoteca
 */
public class Calorias {

    // Propiedades ............................................
    private String mensaje;
    private int edad, altura;
    private double peso;
    private boolean hombre, mujer;
    private String actividad;

    private StringBuilder sb;

    // MÉTODOS set (poner) / get (obtener) para las propiedades
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Establece mensaje
     *
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Obtiene la edad
     *
     * @return la edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad
     *
     * @param edad La edadmensaje
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la altura
     *
     * @return la altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Establece la altura
     *
     * @param altura
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isHombre() {
        return hombre;
    }

    /**
     * Establece
     *
     * @param hombre
     */
    public void setHombre(boolean hombre) {
        this.hombre = hombre;
    }

    public boolean isMujer() {
        return mujer;
    }

    /**
     * Establece
     *
     * @param mujer
     */
    public void setMujer(boolean mujer) {
        this.mujer = mujer;
    }

    public String getActividad() {
        return actividad;
    }

    /**
     * Establece actividad
     *
     * @param actividad
     */
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    // Método para reglas de validación ......................................
    public boolean validate() {
        sb = new StringBuilder();

        if (edad <= 2) {
            sb.append(" - La edad debe ser mayor de 2 años.\n");
        }
        if (altura < 0) {
            sb.append(" - La altura debe ser mayor de 0 cm.\n");
        }
        if (peso < 0) {
            sb.append(" - El peso debe ser mayor de 0 kg.\n");
        }

        // devolvemos true o false
        mensaje = sb.toString();
        return mensaje.isEmpty();

       
// Metodos para cálculos ..................................................
    }

    public double metabolismoBasal() {
        double metabolismoBasal = (10 * peso) + (6.25 * altura) - (5 * edad);

        if (mujer) {
            metabolismoBasal = metabolismoBasal - 161;
        } else {
            metabolismoBasal = metabolismoBasal + 5;
        }
        return metabolismoBasal;

    }

    public double mantener() {
        double mantener = 0;

        if (actividad.equals(TipoActividad.SEDENTARIO.toString())) {
            mantener = metabolismoBasal() * 1.2;
        } else if (actividad.equals(TipoActividad.LIGERA.toString())) {
            mantener = metabolismoBasal() * 1.375;
        } else if (actividad.equals(TipoActividad.MODERADA.toString())) {
            mantener = metabolismoBasal() * 1.55;
        } else if (actividad.equals(TipoActividad.INTENSA.toString())) {
            mantener = metabolismoBasal() * 1.725;
        } else if (actividad.equals(TipoActividad.MUY_INTENSA.toString())) {
            mantener = metabolismoBasal() * 1.9;
        }

        return mantener;
    }

    public double adelgazar() {

        return mantener() * 0.8;
    }
}
