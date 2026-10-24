package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);
        assertFalse(result);
    }
    @Test
    void returnsTrueForPrimeNumber() {
        assertTrue(CourseToolkit.isPrime(7));
    }

    @Test
    void returnsFalseForCompositeNumber() {
        assertFalse(CourseToolkit.isPrime(8));
    }

    @Test
    void returnsFalseForOne() {
         assertFalse(CourseToolkit.isPrime(1));
    }

    @Test
    void returnsTrueForTwo() {
         assertTrue(CourseToolkit.isPrime(2));
    }
    @Test
    void returnsTrueForPalindrome() {
         assertTrue(CourseToolkit.isPalindrome("топот"));
    }

    @Test
    void returnsFalseForNonPalindrome() {
        assertFalse(CourseToolkit.isPalindrome("привет"));
    }

    @Test
    void returnsTrueForSingleCharacter() {
        assertTrue(CourseToolkit.isPalindrome("а")); 
    }
    @Test
    void throwsExceptionForNullText() {
        assertThrows(
            IllegalArgumentException.class,
             () -> CourseToolkit.isPalindrome(null)
        );
    }
    
    @Test   
    void returnsAverageForPositiveNumbers() {
         assertEquals(4.0, CourseToolkit.average(new int[]{2, 4, 6}));
    }

    @Test
    void returnsAverageForNegativeNumbers() {
        assertEquals(-4.0, CourseToolkit.average(new int[]{-2, -4, -6}));
    }

    @Test
    void returnsFractionalAverage() {
        assertEquals(2.5, CourseToolkit.average(new int[]{2, 3}));
    }

    @Test
    void throwsExceptionForEmptyArray() {
        assertThrows(
            IllegalArgumentException.class,
            () -> CourseToolkit.average(new int[]{})
        );
    }
    @Test
    void throwsExceptionForNullArray() {
        assertThrows(
            IllegalArgumentException.class,
            () -> CourseToolkit.average(null)
        );
    }
}





