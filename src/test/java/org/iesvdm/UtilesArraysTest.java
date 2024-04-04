package org.iesvdm;

import org.junit.jupiter.api.Test;

import javax.swing.text.Utilities;

import static org.iesvdm.UtilesArrays.limpiar;
import static org.iesvdm.UtilesArrays.rellenar;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class UtilesArraysTest {
    /* en este método limpia el array que controla el cartón, lo hace machacando el array con el que devuelve el método*/
    /* voy a validar: 1.- que el array está vacio. 2.- que el tamaño sea =0*/
    @Test
    void limpiarDebedevuelvearrayVacioTest(){

        int[] arraycarton={-1,-1,6,12,14,-1};
        //1.-
        int []arraySalida=limpiar();
        arraycarton=arraySalida;
        assertThat(arraycarton).isEmpty();

        //2.-
        assertThat(arraycarton).hasSize(0);

    }
    /* En este método rellena a ceros un array que dimensiona con el numeroElementos que recibe y lo llena a ceros*/
    /* No utiliza el array de entrada y no se le llama a este método desde ningún sitio*/
    /* Como no utiliza el array de entrada no se puede probar si el nnumeroElementos es mayor que el array de entrada,
    * ni nada relacionado con él*/
    /*Validaré que redimensione correctamente y que todos los valores devueltos sean ceros*/
    @Test
    void rellenarACerosTest(){
        int [] arraySinUso={1,2,3,4};
        int numElem=5;
        int ceros=0;
        int[] arraySalida=rellenar(arraySinUso,numElem);

        assertThat(arraySalida).hasSize(numElem);

        assertThat(arraySalida).containsOnly(ceros);


    }
    //sobrecarga de rellenar a ceros
    /*Lo mismo que en rellenar() este, no utiliza el array de entrada y sí el numElem y el valor con el que inicializa
     *el array que devuelve*/
    /* De nuevo solo valido Size y que esté inicializada al valor de entrada*/
    @Test
    void rellenarConValoresTest(){
        int [] arraySinUso={1,2,3,4};
        int numElem=5;
        int valor=-1;
        int[] arraySalida=rellenar(arraySinUso,numElem,valor);

        assertThat(arraySalida).hasSize(numElem);

        assertThat(arraySalida).containsOnly(valor);

    }
    /* Este método está tambíen en Bingo, copio la prueba test*/
    @Test
    void insertarAlFinalTest(){
        int[] prueba ={3,6,8,10};
        int[] resultado=new int[0];

        resultado=Bingo.insertarAlFinal(prueba,55);
        //1.-
        assertThat(resultado[4]).isEqualTo(55);
        //2.-
        assertThat(prueba.length).isEqualTo(resultado.length-1);
    }
    /*Hay que probar que el elemento que inserta lo introduce en el índice 0  */
    @Test
    void insertarAlPrincipioTest(){
        int[] prueba ={3,6,8,10};
        int[] resultado=new int[0];

        resultado= UtilesArrays.insertarAlPrincipio(prueba,55);
        //1.-
        assertThat(resultado[0]).isEqualTo(55);
        //2.-
        assertThat(prueba.length).isEqualTo(resultado.length-1);

    }
    @Test
    void insertarEnPosicionTest(){

    }
    @Test
    void insertarOrdenado(){

    }

    @Test
    void eliminarUltimo(){

    }
    @Test
    void eliminarPrimero(){

    }
    @Test
    void eliminarPosicion(){

    }
    //elimina un elemento concreto buscandolo por el valor
    @Test
    void  eliminar(){

    }


}