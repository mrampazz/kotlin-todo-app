package components

import react.RProps
import react.child
import react.dom.div
import react.functionalComponent

val App = functionalComponent<RProps> { _ ->
    div {
        child(TodosList) {

        }
        child(AddTodoForm) {

        }
    }
}