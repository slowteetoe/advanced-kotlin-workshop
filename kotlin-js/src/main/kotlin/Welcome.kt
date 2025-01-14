import csstype.px
import csstype.rgb
import react.FC
import react.Props
import react.State
import react.create
import react.css.css
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.useState

external interface WelcomeProps : Props {
    var name: String
}

data class WelcomeState(
    val title: String,
    val input: String = "",
    val languages: List<String> = emptyList()
) : State

val Welcome = FC<WelcomeProps> { props ->

    var state by useState(
        initialValue = WelcomeState(
            title = props.name,
            languages = listOf("kotlin", "go")
        )
    )

    // header
    div {
        css {
            padding = 5.px
            backgroundColor = rgb(8, 97, 22)
            color = rgb(56, 246, 137)
        }
        + state.title
    }

    // input field
    input {
        css {
            marginTop = 5.px
            marginBottom = 5.px
            fontSize = 14.px
        }
        type = InputType.text
        value = state.input
        onChange = { event ->
            state = state.copy(input = event.target.value)
        }
    }

    // add button
    button{
        onClick = {
            state = state.copy(languages = state.languages + state.input, input = "")
        }
        +"Add Programming Language"
    }

    div {
        child(ProgrammingLanguagesList.create{
            languages = state.languages
        })
    }
}
