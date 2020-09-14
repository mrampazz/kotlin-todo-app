package components

import actions.AddTodo
import entities.Todo
import kotlinx.html.InputType
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.RProps
import react.child
import react.createRef
import react.dom.*
import react.functionalComponent

external interface TodoProps : RProps {
    var todo: Todo
}

external interface  TodosListProps: RProps {
    var todos: List<Todo>
}

val SingleTodo = functionalComponent<TodoProps> { props ->
    div {
        p {
            +props.todo.id.toString()
        }
        p {
            +props.todo.text
        }
        p {
            if (props.todo.completed) {
                + "Completed"
            } else {
                + "Not completed"
            }
        }
    }
}

val TodosList = functionalComponent<TodosListProps> { props ->
    div {
        for (todo in props.todos) {
            child(SingleTodo) {
                attrs.todo = todo
            }
        }
    }
}