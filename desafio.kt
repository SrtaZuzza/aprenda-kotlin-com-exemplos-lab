enum class Nivel {INTRODUCAO, BASICO, INTERMEDIARIO, AVANCADO}

data class Usuario(val id: Int, var nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

val contentDict = hashMapOf(
    "Fundamentos de Kotlin" to 5, 
    "Kotlin na prática" to 10,
    "Kotlin para o mercado de trabalho" to 25,
    "Seja o mestre de Kotlin" to 50
)

val userDict = hashMapOf(
	56286 to "José das Couves",
    1 to "Fulano de Tal"
)

fun setLevel(duracao: Int): Int{
    val durations = arrayOf(5, 10, 25, 50)
    return durations.indexOf(duracao)
}

fun main() {
    val listaCursos = mutableListOf<ConteudoEducacional>()
    
    for (entry in contentDict){
        listaCursos.add(ConteudoEducacional(entry.key, entry.value, Nivel.values()[setLevel(entry.value)]))
    }
    
    val formacao = Formacao("Curso de kotlin definitivo", listaCursos)
    
    for (entry in userDict){
        formacao.matricular(Usuario(entry.key, entry.value))
    }
    
    println(formacao)
    println(formacao.inscritos)
}
