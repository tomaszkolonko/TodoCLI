import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoHolderTest {

    private final static TodoItem ITEM_ONE = new TodoItem("Call Peter");
    private final static TodoItem ITEM_TWO = new TodoItem("Buy some fruits");
    private final static TodoItem ITEM_TWO_EQUAL = new TodoItem("Buy some fruits");
    private final static TodoItem ITEM_THREE = new TodoItem("Pay the bills");


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
    void testRemovingItemsWithSameReference() {
        todoHolder.delete(ITEM_ONE);
        assertEquals(1, todoHolder.getTodoSize());
    }

    @Test
    void testRemovingEqualItem() {
        todoHolder.delete(ITEM_TWO_EQUAL);
        assertEquals(1, todoHolder.getTodoSize());
    }


}