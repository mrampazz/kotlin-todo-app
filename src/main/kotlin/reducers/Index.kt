package reducers

import entities.Todo
import redux.Reducer
import redux.combineReducers
import kotlin.reflect.KProperty1


data class State (
    val todos: Array<Todo> = emptyArray()
)

fun <S, A, R> combineReducers(reducers: Map<KProperty1<S, R>, Reducer<*, A>>): Reducer<S, A> {
    return combineReducers(reducers.mapKeys { it.key.name })
}

fun combinedReducers() = combineReducers(
    mapOf(
        State::todos to ::todos
    )
)