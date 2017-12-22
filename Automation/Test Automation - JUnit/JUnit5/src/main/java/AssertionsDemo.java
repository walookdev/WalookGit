import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertionsDemo {

    private Person person = new Person();

    @Test
    @DisplayName("Standar assertions")
    public void standardAssertions() {
        assertEquals(2, 2);
        assertEquals(4, 4, "The optional assertion message is now the last parameter.");
        assertTrue(2 == 2, () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
    }

    @Test
    @DisplayName("Group assertions")
    public void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and any
        // failures will be reported together.
        assertAll("person",
                () -> assertEquals("John", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName())
        );
    }

    @Test
    @DisplayName("Dependent assertions")
    public void dependentAssertions() {
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);

                    // Executed only if the previous assertion is valid.
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("n"))
                    );
                },
                () -> {
                    // Grouped assertion, so processed independently
                    // of results of first name assertions.
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    // Executed only if the previous assertion is valid.
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }

    @Test
    @DisplayName("Exception testing")
    public void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }

    @Test
    @DisplayName("Timeout not exceeded")
    public void timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
        });
    }

    @Test
    @DisplayName("Timeout not exceeded with result")
    public void timeoutNotExceededWithResult() {
        // The following assertion succeeds, and returns the supplied object.
        String actualResult = assertTimeout(ofMinutes(2), () -> {
            return "a result";
        });
        assertEquals("a result", actualResult);
    }

    @Test
    @DisplayName("Timeout not exceeded with method")
    public void timeoutNotExceededWithMethod() {
        // The following assertion invokes a method reference and returns an object.
        String actualGreeting = assertTimeout(ofMinutes(2), AssertionsDemo::greeting);
        assertEquals("hello world!", actualGreeting);
    }

    @Test
    @DisplayName("Timeout exceeded")
    public void timeoutExceeded() {
        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100);
        });
    }

    @Test
    @DisplayName("Timeout exceeded with preemtive termination")
    public void timeoutExceededWithPreemptiveTermination() {
        // The following assertion fails with an error message similar to:
        // execution timed out after 10 ms
        assertTimeoutPreemptively(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100);
        });
    }

    private static String greeting() {
        return "hello world!";
    }

    @Test
    @DisplayName("Test will fail")
    public void failTestDemo() {
        fail("Failed test");
    }

    @Test
    @DisplayName("Assert true test")
    public void assertTrueDemo() {
        String nombre = "walook";

        assertTrue(nombre.startsWith("w"));
    }

    @Test
    @DisplayName("Assert false test")
    public void assertFalseDemo() {
        String nombre = "walook";

        assertFalse(nombre.startsWith("r"));
    }

    @Test
    @DisplayName("Assert equals test")
    public void assertEqualsDemo() {
        int valor1 = 5, valor2 = 10, resultado = 15;

        assertEquals(resultado, valor1 + valor2, "Resultado: " + resultado);
    }

    @Test
    @DisplayName("Assert null test")
    public void assertNullDemo() {
        Person person = null;

        assertNull(person);
    }

    @Test
    @DisplayName("Assert not null test")
    public void assertNotNullDemo() {
        Person person = new Person();

        assertNotNull(person);
    }

    @Test
    @DisplayName("Assert same test")
    public void assertSameDemo() {
        Person original = new Person();
        Person prepoceso = original;
        Person postproceso = original;

        assertSame(prepoceso, postproceso);
    }

    @Test
    @DisplayName("Assert not same test")
    public void assertNotSameDemo() {
        Person prepoceso = new Person();
        Person postproceso = new Person();

        assertNotSame(prepoceso, postproceso);
    }

    @Test
    @DisplayName("Assert all test")
    public void assertAllDemo() {
        Person person = new Person("John", "Doe");

        assertAll("person",
                () -> assertNotNull(person),
                () -> assertEquals("John", person.getFirstName())
        );
    }

    @Test
    @DisplayName("Assert array equals test")
    public void assertArrayEqualsDemo() {
        char[] array1= {'H', 'E', 'L', 'L', 'O'};
        char[] array2= {'H', 'E', 'L', 'L', 'O'};

        assertArrayEquals(array1, array2, "Arreglos iguales.");
    }

    @Test
    @DisplayName("Assert throw excepcion test")
    public void assertThrowsException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }

    @Test
    @DisplayName("Assert timeout test")
    public void assertTimeoutDemo() {
        assertTimeout(ofMinutes(2), () -> {
            //Tarea a ejecutar de duración menor a 2 minutos.
            Person person = new Person();
            System.out.print("Helo ");
            System.out.println(person.getFirstName() + " " + person.getLastName());
        });
    }

    @Test
    @DisplayName("Assert tiemeout preemtively test")
    public void assertTimeoutPreemtivelyDemo() {
        assertTimeoutPreemptively(ofMillis(10), () -> {
            // Simula una tarea que dura más de 10 milisegundos.
            Thread.sleep(100);
        });
    }

}
