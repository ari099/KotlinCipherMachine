package exec

fun main(args: Array<String>) {
    // Program entry point....
    //println("Hello, World!")
    val key:Int = 1
    val cm = CaesarCipherMachine(key)
    println(cm.Encrypt("fresh prince"))
    println(cm.Decrypt("gsfti qsjodf"))

    val vcm = VigenereCipherMachine("castles")
    println(vcm.Encrypt("fresh prince"))
    println(vcm.Decrypt("eakmw eakmwi")) // NOT WORKING.....
}