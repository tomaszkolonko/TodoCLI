import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoHolderTest {

    private final static String ITEM_ONE = "Call Peter";
    private final static String ITEM_TWO = "Buy some fruits";
    private final static String ITEM_THREE = "Pay the bills";

    private final static TodoHolder todoHolder = new TodoHolder();

    @BeforeEach
    void init() {
        todoHolder.add(ITEM_ONE);
        todoHolder.add(ITEM_TWO);
    }

    @AfterEach
    void clearTodoHolder() {
        todoHolder.clearTodos();
    }

    @Test
    void testAddingItems() {
        assertEquals(2, todoHolder.getTodoSize());
        todoHolder.add(ITEM_THREE);
        assertEquals(3, todoHolder.getTodoSize());

    }

    @Test
    void testRemovingItems() {
        todoHolder.delete(ITEM_ONE);
        assertEquals(1, todoHolder.getTodoSize());
    }


}