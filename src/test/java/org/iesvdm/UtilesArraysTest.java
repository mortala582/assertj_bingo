package org.iesvdm;

import org.junit.jupiter.api.Test;

import javax.swing.text.Utilities;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.iesvdm.UtilesArrays.*;
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
    /* ESTE MÉTODO NO FUNCIONA, YA QUE NO SOLO DEBE DEJAR INSERTAR AL INICIO EN EL MEDIO SI NO QUE TAMBIÉN DEBE DEJAR
    * INSERTAR AL FINAL. SE ARREGLARIA EN LIGAR DE MIRAR SI LA POSICIÓN ES MAYOR QUE LA DEL ARRAY QUE RECIBE, COMPROBARA
    * SOBRE EL NUEVO QUE REDIMENSIONA PARA INSERTAR EL ELEMENTO*/
    /* Y OTRA COSA, NO INSERTA EN LA POSICIÓN, INSERTA EN EL ÍNDICE QUE CONCEPTUALMENTE SON DISTINTOS Y PARA LA PERSONA
    *QUE PRUEBA ES CONFUSO*/
    /* afortunadamente no se utiliza en ningún sitio, solo en el siguiente método que tampoco lo llama nadie */
    /* !! PARA CUANDO EL RECOLECTOR DE CODIGO !! */

    @Test
    void insertarEnPosicionTest(){
        int[] prueba ={3,6,8,10};
        int[] resultado=new int[5];
        //Pruebo primera posición
        resultado=UtilesArrays.insertarEnPosicion(prueba, 55, 0);
        assertThat(resultado[0]).isEqualTo(55);


       //Pruebo última posición POR EL FALLO, HE TENIDO QUE COMPARAR CON LA LONGITUD-2 EN LUGAR DE LONGITUD-1
        resultado=UtilesArrays.insertarEnPosicion(prueba, 55,3);
        assertThat(resultado[resultado.length-1]).isEqualTo(55);
        //assertThat(resultado[resultado.length-2]).isEqualTo(55);


        //Pruebo posición intermedia
        resultado=UtilesArrays.insertarEnPosicion(prueba, 55, 2);
        assertThat(resultado[2]).isEqualTo(55);

    }
    /* Puebo este método que lo que hace es insertar un nuevo elemento en la posición que le corresponda del array ,
    * según orden natural, pero utiliza el método anterior...*/
    /* NO REALIZO MÁS PRUEBAS PARA UN CÓDIGO QUE NI SE UTILIZA NI ESTÁ BIEN*/
    @Test
    void insertarOrdenadoTest(){
        int[] prueba ={3,16,28,30,40,50,60,70,80};
        int[] resultado=new int[5];
        //Pruebo última posición y falla
        resultado=UtilesArrays.insertarOrdenado(prueba, 85);
        assertThat(resultado[9]).isEqualTo(85);

    }
    /* No entiendo porqué hace tanto lío, si es eliminar el último*/
    /* pruebo :1.- que las longitudes del array final y el original-1 son iguales
    * 2.- que el array final no contiene el último número del array original*/
    @Test
    void eliminarUltimoTest(){
        int[] prueba ={3,16,28,30,40,50,60,70,80};
        int[] resultado=new int[9];
        // 1.-
        resultado=UtilesArrays.eliminarUltimo(prueba);
        assertThat(resultado.length).isEqualTo(prueba.length-1);
        // 2.-
        assertThat(resultado).doesNotContain(80);


    }
    //Elimina primera posición
    /* pruebo :1.- que las longitudes del array final y el original-1 son iguales
    * 2.- que el array final no contiene el primer número del array original*/
    @Test
    void eliminarPrimeroTest(){
        int[] prueba ={3,16,28,30,40,50,60,70,80};
        int[] resultado=new int[9];
        // 1.-
        resultado=UtilesArrays.eliminarPrimero(prueba);
        assertThat(resultado.length).isEqualTo(prueba.length-1);
        // 2.-
        assertThat(resultado).doesNotContain(3);
    }
    /* Elimina una posición dada del array*/
    /*Como siempre, testeo : 1.- elimino primera posición. 2.- elimino última posición. 3.- elimino posición intermedia
    * 4.- compruebo longitud del array */
    @Test
    void eliminarPosicionTest(){
        int[] prueba ={3,6,8,10};
        int[] resultado=new int[5];

        //1.-
        resultado=UtilesArrays.eliminarPosicion(prueba, 0);
        assertThat(resultado[0]).isEqualTo(6);

        //2.-
        resultado=UtilesArrays.eliminarPosicion(prueba, 3);
        assertThat(resultado[resultado.length-1]).isEqualTo(8);


        //3.-
        resultado=UtilesArrays.eliminarPosicion(prueba,  2);
        assertThat(resultado[2]).isEqualTo(10);

        //4.-
        assertThat(resultado.length).isEqualTo(prueba.length-1);
    }

    //elimina del array todos los elementos que contenga para un elemento dado
    /* Pruebo : 1.- que elimina todos los números 3 que he introducido en la primera, última y posición intermedia
    * 2.- que el array no contiene el número 3
    * 3.- que la longitud del array final es igual al original menos las 3 posiciones*/
    @Test
    void  eliminarTest(){
        int[] prueba ={3,6,8,3,10,3};
        int[] resultado=new int[5];

        //1.-
        resultado=UtilesArrays.eliminar(prueba, 3);
        assertThat(resultado[0]).isEqualTo(6);

        //2.-
        assertThat(resultado).doesNotContain(3);


        //3.-
         assertThat(resultado.length).isEqualTo(prueba.length-3);

    }
    // este test está probado en BingoTest, es el último
    //@Test
    //void ordenar(){

    //}
    //Utiliza Math.random para desordenar el array de entrada
    /* Valido que contiene la lista original y la de después los mismo elementos y que no se repiten*/
    @Test
    void desordenarTest(){
        int[] prueba ={3,6,8,10,15};
        int[] pruebafinal ={3,6,8,10,15};
       
        desordenar(pruebafinal);
        assertThat(pruebafinal).containsOnlyOnce(prueba);
    }
    //Da la vuelta al array, verifico que es exactamente igual al que se espera
    @Test
    void invertirTest(){
        int[] prueba ={3,6,8,10,15};
        int [] resultado=new int[5];
        int[] esperado ={15,10,8,6,3};

        resultado=UtilesArrays.invertir(prueba);
        assertThat(resultado).containsExactly(esperado);
    }
    //ESTE NO ME SALE
    @Test
    void imprimirTest(){
        int[] prueba ={3,6,8,10,15};
        String resultado= "\t[3, 6, 8, 10, 15]\n";


        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        UtilesArrays.imprimir(prueba);
        assertThat(salida.toString()).isEqualTo(resultado);

    }
    //Comprueba si está ordenado el array de entrada
    @Test
    void estaOrdenadoTest(){
        int[] prueba ={3,6,8,10,15};

        assertThat(UtilesArrays.estaOrdenado(prueba)).isTrue();
        int[] desordenado={15,6,8,3,10};

        assertThat(UtilesArrays.estaOrdenado(desordenado)).isFalse();
    }
    // busca un valor dentro del array, si lo encuentra, devuelve su posición, si no, devuelve -1
    @Test
    void buscarTest(){
        int[] prueba ={3,6,8,10,15};
        int posicion=28;

        posicion=UtilesArrays.buscar(prueba, 8);
        assertThat(posicion).isEqualTo(2);

        posicion=UtilesArrays.buscar(prueba, 88);
        assertThat(posicion).isEqualTo(-1);


    }
     /* Devuelve el array desde la posicion inicial indicada
     * hasta la de corte sin incluir esta última en el array resultante*/
    @Test
    void partirPorTest(){
        int[] prueba ={3,6,8,10,15};
        int[] esperado={3,6,8};
        int[] resultado=new int[5];

        resultado=UtilesArrays.partirPor(prueba,0,3);
        assertThat(resultado).containsExactly(esperado);

        // pruebo desde la última posicion para ver que no se modifica el array
        resultado=UtilesArrays.partirPor(prueba,4,1);
        assertThat(resultado).containsExactly(prueba);

    }

    //este no funciona, creo que es por el While, deberia llamar al método elementos iguales dentro del bucle
    @Test
    void sonIgualesTest(){
        int[] prueba ={3,6,8,10,15};
        int[] prueba1 ={3,6,8,10,15};

        assertThat(UtilesArrays.sonIguales(prueba, prueba1)).isTrue();

    }
    //compara si la posicion de dos arrays coinciden su elemento
    @Test
    void elementosIgualesTest(){
        int[] prueba ={3,6,8,10,15};
        int[] prueba1 ={15,6,8,10,3};
        assertThat(UtilesArrays.elementosIguales(prueba, prueba1, 2)).isTrue();

        assertThat(UtilesArrays.elementosIguales(prueba, prueba1, 0)).isFalse();
    }
    //Concatela el contenido de dos arrays
    @Test
    void concatenarArraysTest(){
        int[] prueba ={3,6,8,10,15};
        int[] prueba1 ={16,17,18,20};
        int[] esperado={3,6,8,10,15,16,17,18,20};

        int [] salida=UtilesArrays.concatenarArrays(prueba, prueba1);
        assertThat(salida).isEqualTo(esperado);

        assertThat(salida.length).isEqualTo((prueba.length+ prueba1.length));

    }
}