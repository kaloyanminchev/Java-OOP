package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Integer[] numbers;
    private Database database;

    @Before
    public void setDatabaseField() throws OperationNotSupportedException {
        this.numbers = initNumbers(6);
        this.database = new Database(numbers);
    }

    private Integer[] initNumbers(int size) {
        Integer[] arr = new Integer[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt();
        }

        return arr;
    }

    @Test
    public void databaseCreationTestShouldCreateObjectWithValidParameters() {
        Integer[] elements = this.database.getElements();

        Assert.assertEquals(numbers.length, elements.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseCreationTestShouldThrowExceptionWithNullParameters() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseCreationTestShouldThrowExceptionWithMoreThanSixteenParameters() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        for (int i = 0; i < 17; i++) {
            numbers[i] = i;
        }
        new Database(numbers);
    }

    @Test
    public void shouldSetCorrectlyElementsUponCreation() {
        Integer[] elements = this.database.getElements();

        Assert.assertArrayEquals(numbers, elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenAddingNullElement() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void shouldAddElementCorrectly() throws OperationNotSupportedException {
        this.database.add(42);
        Integer[] elements = this.database.getElements();
        int lastElement = elements[elements.length - 1];

        Assert.assertEquals(42, lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenRemovingOnEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < this.numbers.length; i++) {
            this.database.remove();
        }

        this.database.remove();
    }

    @Test
    public void shouldRemoveElementAtLastIndex() throws OperationNotSupportedException {
        this.database.remove();
        Integer[] elements = this.database.getElements();
        Integer lastElement = elements[elements.length - 1];
        Assert.assertEquals(this.numbers[this.numbers.length - 2], lastElement);
    }

    @Test
    public void allElementsShouldBeInReverseOrderWhenRemoving() throws OperationNotSupportedException {
        for (int i = this.numbers.length - 1; i >= 0; i--) {
            int curr = this.numbers[i];
            Integer[] elements = this.database.getElements();
            int last = elements[elements.length - 1];
            Assert.assertEquals(curr, last);
            this.database.remove();
        }
    }

}