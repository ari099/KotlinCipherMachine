package exec

import java.util.*

class EnigmaCipherMachine : CipherMachine {
    var alphabet:CharArray // Array of alphabetic characters
    var key:String // Key used for encryption

    constructor(key:String, alphabet:String = "abcdefghijklmnopqrstuvwxyz") {
        this.key = key
        this.alphabet = alphabet.toCharArray()
    }

    /**
     * Encrypt plaintext according to the Enigma cipher
     * @param plaintext
     * @return ciphertext
     */
    override fun Encrypt(plaintext: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Decrypt ciphertext according to the Enigma cipher
     * @param ciphertext
     * @return plaintext
     */
    override fun Decrypt(ciphertext: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Rotate alphabet to the left by "amount"
     * @param amount
     */
    override fun RotateLeft(amount: Int) {
        val elements: Queue<Char> = LinkedList<Char>(alphabet.toMutableList())
        for(i in 1..amount)
            elements.add(elements.remove())
        this.alphabet = elements.toCharArray()
    }

    /**
     * Rotate alphabet to the right by "amount"
     * @param amount
     */
    override fun RotateRight(amount: Int) {
        this.alphabet.reverse()
        this.RotateLeft(amount)
        this.alphabet.reverse()
    }
}