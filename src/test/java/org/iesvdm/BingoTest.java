package org.iesvdm;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BingoTest {

    @Test
    void rellenarNumerosCarton(){

    }
    @Test
    void ponerBlancos(){
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
    }