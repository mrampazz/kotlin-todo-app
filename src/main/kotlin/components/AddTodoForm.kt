package components

import actions.AddTodo
import kotlinx.html.ButtonType
import kotlinx.html.InputType
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.RProps
import react.child
import react.createRef
import react.dom.button
import react.dom.div
import react.dom.form
import react.dom.input
import react.functionalComponent
import store

external interface ButtonProps: RProps {
    var txt: String
}

val Button = functionalComponent<ButtonProps> { props ->
    button(type = ButtonType.submit) {
        +props.txt
    }
}

val AddTodoForm = functionalComponent<RProps> { _ ->

    val inputRef = createRef<HTMLInputElement>()

    val submitHandler: (Event) -> Unit = {
        it.preventDefault()
        inputRef.current!!.let { input ->
            if (input.value.trim().isNotEmpty()) {
                store.dispatch(AddTodo(input.value))
                input.value = ""
            }
        }
    }

    div {
        form {
            attrs.onSubmitFunction = { event -> submitHandler(event) }

            input(type = InputType.text) {
                ref = inputRef
            }

            child(Button) {
                attrs.txt = "Add a todo"
            }
        }
    }
}