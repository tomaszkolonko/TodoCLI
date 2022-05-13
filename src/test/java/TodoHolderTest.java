import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoHolderTest {

    private final static TodoItem ITEM_ONE = new TodoItem("Call Peter", 0);
    private final static TodoItem ITEM_TWO = new TodoItem("Buy some fruits", 1);
    private final static TodoItem ITEM_THREE = new TodoItem("Pay the bills", 2);


    private final static TodoHolder todoHolder = new TodoHolder();

    @BeforeEach
    void init() {
        ITEM_ONE.uncheck();
        ITEM_TWO.uncheck();
        ITEM_THREE.uncheck();
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
    void testRetrievingAnItem() {
        TodoItem todoItem = todoHolder.retrieveItem(1);
        assertEquals(new TodoItem("Buy some fruits",1), todoItem);
    }

    @Test
    void testDeletingItems() {
        assertEquals(2, todoHolder.getTodoSize());
        todoHolder.delete(1);
        assertEquals(1, todoHolder.getTodoSize());
    }

    @Test
    void testCheckAndUncheckItems() {
        assertEquals(false, todoHolder.retrieveItem(0).isChecked());
        todoHolder.checkItem(0);
        assertEquals(true, todoHolder.retrieveItem(0).isChecked());
        todoHolder.uncheckItem(0);
        assertEquals(false, todoHolder.retrieveItem(0).isChecked());
    }

    @Test
    void testEditItem() {
        TodoItem newItem = new TodoItem("Call Janet", 1);
        newItem.check();
        // newItem.setUniqueId(1);
        todoHolder.replaceItem(0, newItem);

        TodoItem retrievedItem = todoHolder.retrieveItem(1);
        assertEquals(newItem, retrievedItem);
    }

    @Test
    void testClearingCheckedItems() {
        todoHolder.add(ITEM_THREE);
        assertEquals(3, todoHolder.getTodoSize());
        todoHolder.checkItem(1);
        assertEquals(3, todoHolder.getTodoSize());
        todoHolder.clearCheckedTodos();
        assertEquals(2, todoHolder.getTodoSize());
        todoHolder.checkItem(0);
        todoHolder.checkItem(2);
        todoHolder.clearCheckedTodos();
        assertEquals(0, todoHolder.getTodoSize());
    }


}