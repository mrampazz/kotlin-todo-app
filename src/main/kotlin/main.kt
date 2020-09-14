import kotlinx.browser.document
import react.child
import react.dom.render
import react.redux.provider
import reducers.State
import reducers.combinedReducers
import redux.RAction
import redux.compose
import redux.createStore
import redux.rEnhancer

val store = createStore<State, RAction, dynamic>(
    combinedReducers(), State(), compose(
        rEnhancer(),
        js("if(window.__REDUX_DEVTOOLS_EXTENSION__ )window.__REDUX_DEVTOOLS_EXTENSION__ ();else(function(f){return f;});")
    )
)

fun main() {
    render(document.getElementById("root")) {
        provider(store) {
            app()
        }
    }
}