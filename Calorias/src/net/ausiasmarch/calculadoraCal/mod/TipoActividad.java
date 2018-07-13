/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.calculadoracal.mod;

/**
 *
 * @author carmendw
 */
public enum TipoActividad {

    SEDENTARIO, LIGERA, MODERADA, INTENSA, MUY_INTENSA;

    @Override
    public String toString() {
        String cad = "";

        switch (this) {
            case SEDENTARIO:
                cad = "Sedentario";
                break;
            case LIGERA:
                cad = "Ligera";
                break;
            case MODERADA:
                cad = "Moderada";
                break;
            case INTENSA:
                cad = "Intensa";
                break;
            case MUY_INTENSA:
                cad = "Muy intensa";
                break;
        }
        return cad;

    }
}

