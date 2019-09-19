package exec

import java.util.*

/**
 * CipherMachine object blueprint
 * for the Caesar cipher
 */
class CaesarCipherMachine : CipherMachine {

    var alphabet:CharArray // Alphabet array used for encryption
    val key:Int // Variable storing the encryption key

    constructor (key: Int, alphabet: String = "abcdefghijklmnopqrstuvwxyz") {
        this.key = key
        this.alphabet = alphabet.toCharArray()
    }

    /**
     * Encrypt plaintext according to the Caesar cipher
     */
    override fun Encrypt(plaintext: String) : String {
        if(plaintext.isEmpty())
            return plaintext

        var chars = plaintext.toMutableList()
        var ciphertext:String = plaintext

        for (i in 0 until plaintext.length) {
            if (alphabet.contains(plaintext[i])) {
                var index:Int = alphabet.indexOf(plaintext[i])
                this.RotateLeft(key)
                chars[i] = alphabet[index]
                this.RotateRight(key)
                ciphertext = chars.joinToString(separator = "")
            }
        }

        return ciphertext
    }

    /**
     * Encrypt single character according to the
     * Caesar cipher
     */
    fun EncryptCharacter(character: Char) : Char {
        if (alphabet.contains(character))
            return alphabet[alphabet.indexOf(character)]
        else return '\u0000'
    }

    /**
     * Decrypt ciphertext according to the Caesar cipher
     */
    override fun Decrypt(ciphertext: String) : String {
        // complete this method....
        if(ciphertext.isEmpty())
            return ciphertext

        var chars = ciphertext.toMutableList()
        var plaintext:String = ciphertext

        for (i in 0 until ciphertext.length) {
            if (alphabet.contains(plaintext[i])) {
                var index:Int = alphabet.indexOf(ciphertext[i])
                this.RotateRight(key)
                chars[i] = alphabet[index]
                this.RotateLeft(key)
                plaintext = chars.joinToString(separator = "")
            }
        }

        return plaintext
    }

    /**
     * Rotate array to the left by "amount"
     */
    override fun RotateLeft(amount: Int) {
        val elements:Queue<Char> = LinkedList<Char>(alphabet.toMutableList())
        for(i in 1..amount)
            elements.add(elements.remove())
        this.alphabet = elements.toCharArray()
    }

    /**
     * Rotate array to the right by "amount"
     */
    override fun RotateRight(amount: Int) {
        this.alphabet.reverse()
        this.RotateLeft(amount)
        this.alphabet.reverse()
    }
}