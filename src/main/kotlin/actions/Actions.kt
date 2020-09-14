package actions

import redux.RAction

// class AddTodo which has RAction as supertype
// it takes a val text: String to create

class AddTodo(val text: String): RAction {
    private companion object {
        var nextTodoId = 1
    }
    val id = nextTodoId++
}

class ToggleTodo(val id: Int): RAction {

}