package org.iesvdm;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BingoTest {

    /* Aquí, va rellendado las columnas y las filas con los valores corespondientes con números aleatorios.*/
    /* Voy a validar: 1.- que en cada columna ha insertado el valor de la unidad o decena correspondiente.
    * 2.- que no se repitan los números en el cartón*/
    @Test
    void rellenarNumerosCartonTest(){
        int[][] carton = new int[9][3];
        List<Integer> valoresCarton=new ArrayList<>();

        /* Tengo que rellenarlo con valores y -1 para las comprobaciones*/
        Bingo.rellenarNumerosCarton(carton);
        Bingo.ponerBlancos(carton);

        //1.-
        // Selecciono cada una de las 8 columnas
        for (int i = 0; i < carton.length; i++){
            /* Recorro las 3 posiciones de cada columna y voy guardando en un array [] los valores distintos de -1
            * para luego comprobar el punto2 */
            for (int j = 0; j < carton[0].length; j++){
                if (carton[i][j]!=-1){
                    if(i==0) {
                        assertThat(carton[0][j]).isBetween(1, 9);
                    } else if (i==1) {
                        assertThat(carton[1][j]).isBetween(10,19);
                    } else if (i==2) {
                        assertThat(carton[2][j]).isBetween(20,29);
                    } else if (i==3) {
                        assertThat(carton[3][j]).isBetween(30, 39);
                    } else if (i==4) {
                        assertThat(carton[4][j]).isBetween(40, 49);
                    } else if (i==5) {
                        assertThat(carton[5][j]).isBetween(50, 59);
                    } else if (i==6) {
                        assertThat(carton[6][j]).isBetween(60, 69);
                    } else if (i==7) {
                        assertThat(carton[7][j]).isBetween(70, 79);
                    } else if (i==8) {
                        assertThat(carton[8][j]).isBetween(80, 89);
                    }
                    valoresCarton.add(carton[i][j]);
                }

            }

        }
        //2.-
        Set<Integer> sinduplicados= new HashSet<>(valoresCarton);
        assertThat(valoresCarton.size()).isEqualTo(sinduplicados.size());


    }
    @Test
    void ponerBlancosTest(){
        // Genero los arrays columnas:
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];

        // Los paso a mi matriz o array bidimensional:
        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};
        Bingo.ponerBlancos(carton);
        for (int j = 0; j < carton[0].length; j++) {
            for( int i=0; i < carton.length; i++) {
                System.out.print((carton[i][j] == 0 ? " 0" : carton[i][j])+ " ");
            }
            System.out.println("");
        }

        int cont12Blancos=0;
        for(int[] col: carton){
            int cont=0;
            for (int celda: col){
                if(celda==-1) {
                    cont++;
                    cont12Blancos++;
                }
            assertThat(cont).isLessThan(3);
        }

    }
        assertThat(cont12Blancos).isEqualTo(12);

    }
    /* buscarFila() y buscarColumna() son parte del método ponerBlancos() que ya hemos testeado,
     *por lo que no los testeo*/

    /*  buscarValorRepetido() se utiliza tanto para no duplicar los números que saca la bola como para
    * rellenarNumerosCarton() que ya hemos testeado*/

    /* en pintarCarton() pinta el cartón y realiza esta búsqueda para tachar el número si está en el array de bolas y en el cartón:
    *boolean seTacha = buscarValorRepetido(arrayBolas, arrayBi[j][i]) volvemos a repetir el método de buscar repetido que ya hemos validado
    *y pintar el cartón, es bastante gráfico y no se me ocurre mejor manera de testearlo.*/

    /* Valida que: 1.- el elemento que pasa realmente lo introduce en la última posición
    * 2.- compruebo que el array original tiene una posición menos que el resultante*/
    @Test
    void  insertarAlFinalTest(){
        int[] prueba ={3,6,8,10};
        int[] resultado=new int[0];

        resultado=Bingo.insertarAlFinal(prueba,55);
        //1.-
        assertThat(resultado[4]).isEqualTo(55);
        //2.-
        assertThat(prueba.length).isEqualTo(resultado.length-1);

    }
    /*Hay que probar que está ordenado despues de pasar por el método */
    @Test
    void ordenarTest(){
        int[] prueba ={13,26,8,10};
        Bingo.ordenar(prueba);
        assertThat(prueba).isSorted();

    }
    }