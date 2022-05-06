import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoHolderTest {

    private final static String ITEM_ONE = "Call Peter";
    private final static String ITEM_TWO = "Buy some fruits";
    private final static String ITEM_THREE = "Pay the bills";

    @Test
    void testAddingItem() {
        TodoHolder todoHolder = new TodoHolder();
        todoHolder.add(ITEM_ONE);
        assertEquals(1, todoHolder.getTodos().size());
        todoHolder.add(ITEM_TWO);
        assertEquals(2, todoHolder.getTodos().size());
        todoHolder.add(ITEM_THREE);
        assertEquals(3, todoHolder.getTodos().size());

    }

}