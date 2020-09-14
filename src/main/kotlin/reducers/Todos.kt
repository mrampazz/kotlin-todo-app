package reducers

import actions.AddTodo
import actions.ToggleTodo
import entities.Todo
import redux.RAction


// function to handle different actions

fun todos(state: Array<Todo> = emptyArray(), action: RAction): Array<Todo> = when(action) {
    is
        AddTodo -> state + Todo(action.id, action.text, false)

    is
        ToggleTodo -> state.map {
            // checks which id in the list is equal to the one in the action
            if (it.id == action.id) {
                // copies the iterator with the completed value changed
                // ** immutable change **
                it.copy(completed = !it.completed)
            } else {
                // doesn't change the completed value
                it
            }
        }.toTypedArray()

    else -> state
}