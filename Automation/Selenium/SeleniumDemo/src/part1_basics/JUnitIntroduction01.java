package part1_basics;

import org.junit.*;

public class JUnitIntroduction01 {

    //Se ejecuta al inicio de la clase, antes que todos los métodos.
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Executed before class...");
    }

    //Se ejecuta al final de la clase, después de todos los métodos.
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Executed after class...");
    }

    //Se ejecuta antes de cada prueba.
    @Before
    public void setUp() throws Exception {
        System.out.println("Executed before...");
    }

    //Se ejecuta después de cada prueba.
    @After
    public void tearDown() throws Exception {
        System.out.println("Executed after...");
    }

    //Pruebas a realizar.
    @Test
    public void test1() {
        System.out.println("Executed part1_basics 1...");
    }

    @Test
    public void test2() {
        System.out.println("Executed part1_basics 2...");
    }

}
