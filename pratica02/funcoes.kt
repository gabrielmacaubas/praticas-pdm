package pratica02

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    val resultado = materiasENotas.put(materia, notas)
    return resultado != null
}

fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]
    if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        return true
    }
    return false
}

fun mostrarNotas(materia: String) {
    if (materiasENotas.containsKey(materia)) {
        val listaNotas = materiasENotas[materia]
        if (listaNotas != null) {
            println("Materia: $materia")
            listaNotas.forEachIndexed { index, nota ->
                println("Nota ${index + 1}: $nota")
            }
            println("\nMédia: ${calcularMedia(listaNotas)}\n")
        } else {
            println("Não foi possível mostrar as notas da matéria $materia")
        }
    } else {
        println("Materia $materia não encontrada")
    }
}

fun calcularMedia(notas: List<Double>): Double {
    return if (notas.isNotEmpty()) {
        notas.sum() / notas.size
    } else {
        0.0
    }
}

fun adicionarVariasNotas(materia: String, vararg notas: Double): Boolean {
    val notasExistentes = materiasENotas[materia]
    if (notasExistentes != null) {
        notasExistentes.addAll(notas.toList())
        return true
    }
    return false
}

fun main() {
    adicionarDisciplina("Matemática", mutableListOf(8.5, 7.0))
    adicionarDisciplina("História", mutableListOf(6.0))
    adicionarDisciplina("Física")
    adicionarNota("Matemática", 9.0)
    adicionarNota("História", 8.0)
    adicionarNota("Física", 7.5)
    mostrarNotas("Matemática")
    mostrarNotas("História")
    mostrarNotas("Física")
    adicionarDisciplina("Química")
    adicionarVariasNotas("Química", 5.0, 6.5, 8.0)
    mostrarNotas("Química")
    println("Média Matemática: ${calcularMedia(materiasENotas["Matemática"] ?: listOf())}")
    println("Média Química: ${calcularMedia(materiasENotas["Química"] ?: listOf())}")
}
