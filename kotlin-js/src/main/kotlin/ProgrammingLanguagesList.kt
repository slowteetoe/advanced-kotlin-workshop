
import kotlinx.browser.window
import react.FC
import react.Props
import react.dom.html.ReactHTML.p
import react.key

external interface LanguageListProps : Props {
    var languages: List<String>
}

val ProgrammingLanguagesList = FC<LanguageListProps> { props ->
    props.languages.forEach { language ->
        p {
            onClick = {
                window.alert("Clicked $language")
            }
            key = language
            +language
        }
    }
}
