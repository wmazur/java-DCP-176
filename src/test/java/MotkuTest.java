import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class MotkuTest {

    @Before
    public void setUp() throws Exception {
    }

    Motku motku;

    @Test
    public void minimal_working_input(){
        int[][] input = new int[2][];
        input[0] = new int[]{1};
        input[1] = new int[]{1};
        motku = new Motku(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorWorks_only_on_input_with_content(){
        int[][] input = new int[0][];
        motku = new Motku(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void empty_graph_throws_illegalArgumentException(){
        int[][] input = new int[1][];
        input[0] = new int[]{0};
        motku = new Motku(input);
    }

    @Test
    public void NumberOfRows_defined_in_first_row_matches_number_of_rows_defined_one(){
        int[][] input = new int[2][];
        input[0] = new int[]{1};
        input[1] = new int[]{1};
        motku = new Motku(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_does_not_Work_WithZeroNodes(){
        int[][] input = new int[1][1];
        input[0][0] = 0;
        motku = new Motku(input);
    }

    @Test
    public void constructorWorksWithOneNode(){
        int[][] input = new int[2][];

        input[0] = new int[]{1};
        input[1] = new int[]{1};

        motku = new Motku(input);
    }

    @Test
    public void constructorWorksWithTwoNodes(){
        int[][] input = new int[3][];

        input[0] = new int[]{2};
        input[1] = new int[]{1, 2};
        input[2] = new int[]{1, 2};

        motku = new Motku(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Invalid_inputsample(){
        int[][] input = new int[2][];

        input[0] = new int[]{2};
        input[1] = new int[]{1, 2};

        motku = new Motku(input);
    }

    @Test
    public void There_is_no_connection_between_nodes_then_result_is_minus_one(){
        int[][] input = new int[5][];

        input[0] = new int[]{4};
        input[1] = new int[]{1, 2, 3, 50};
        input[2] = new int[]{1, 2};
        input[3] = new int[]{2, 3};
        input[4] = new int[]{1, 3};

        motku = new Motku(input);
        assertEquals(-1, motku.result(4,1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalid_input_number_of_edges_must_be_equalTo_number_of_nodes_minus_1(){
        int[][] input = new int[2][];

        input[0] = new int[]{2};
        input[1] = new int[]{1, 2};

        motku = new Motku(input);
    }

    @Test
    public void There_is_a_connection_between_nodes_then_result_is_3(){
        int[][] input = new int[3][];

        input[0] = new int[]{2};
        input[1] = new int[]{1, 2};
        input[2] = new int[]{1, 2};

        motku = new Motku(input);
        assertEquals(3, motku.result(1,1));
    }

    @Test
    public void Four_elements_and_distance_2(){
        int[][] input = new int[5][];

        input[0] = new int[]{4};
        input[1] = new int[]{1, 5, 13, 50};
        input[2] = new int[]{1, 2};
        input[3] = new int[]{2, 3};
        input[4] = new int[]{1, 3};

        motku = new Motku(input);
        assertEquals(19, motku.result(1,2));
    }

    @Test
    public void Four_elements_and_distance_2_easy(){
        int[][] input = new int[5][];

        input[0] = new int[]{4};
        input[1] = new int[]{1, 5, 13, 50};
        input[2] = new int[]{1, 2};
        input[3] = new int[]{2, 3};
        input[4] = new int[]{4, 3};

        motku = new Motku(input);
        assertEquals(19, motku.result(1,2));
    }

    @Test
    public void Four_elements_and_distance_1(){
        int[][] input = new int[5][];

        input[0] = new int[]{4};
        input[1] = new int[]{1, 7, 3, 50};
        input[2] = new int[]{1, 2};
        input[3] = new int[]{2, 3};
        input[4] = new int[]{1, 3};

        motku = new Motku(input);
        assertEquals(4, motku.result(1,1));
    }




}