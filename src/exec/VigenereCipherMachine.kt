package exec

import java.util.*

/**
 * CipherMachine object blueprint
 * for the VigenereCipher
 * @constructor Creates a VigiereCipherMachine
 */
class VigenereCipherMachine : CipherMachine {
    var alphabet:CharArray // Array of alphabetic characters
    var key:String // Key used for encryption

    constructor(key:String,alphabet:String = "abcdefghijklmnopqrstuvwxyz") {
        this.key = this.RemoveDuplicateCharacters(key.replace(' ','\u0000'))
        this.alphabet = alphabet.toCharArray()
    }

    /**
     * Removing duplicate characters from string
     * @param text the text to remove duplicate characters from
     * @return keystring new keystring generated without any duplicated characters
     */
    private fun RemoveDuplicateCharacters(text: String): String {
        var characters:CharArray = text.toLowerCase().toCharArray()
        return characters.distinct().joinToString("")
    }

    /**
     * Encrypt the plaintext according to the
     * Vigenere cipher
     * @param plaintext
     * @return ciphertext
     */
    override fun Encrypt(plaintext: String): String {
        // Generate the key used for encryption
        var generatedKey:String = GenerateKey(plaintext.length)

        // New ciphertext goes here....
        var ciphertext:String = ""

        // Encrypting....
        for ( i in 0 until plaintext.length ) {
            // If the plaintext character is in the alphabet, then
            if (alphabet.contains(plaintext[i])) {
                // Find the index of the character at the same index in generatedKey in the alphabet
                var keyIndex = alphabet.indexOf(generatedKey[i])
                RotateLeft(keyIndex) // Shift the alphabet by the index amount
                ciphertext += alphabet[keyIndex] // Add the plaintext character at the found index to the ciphertext string value
                RotateRight(keyIndex) // Shift the alphabet back to the way it was
            } else // Otherwise, just add the same character to the ciphertext variable
                ciphertext += plaintext[i]
        }

        return ciphertext
    }

    /**
     * Decrypt ciphertext according to the
     * Viginere cipher
     * NOT WORKING
     * @param ciphertext
     * @return plaintext
     */
    override fun Decrypt(ciphertext: String): String {
        var generatedKey:String = GenerateKey(ciphertext.length)
        var plaintext:String = ""
        for ( i in 0 until ciphertext.length ) {
            if (alphabet.contains(ciphertext[i])) {
                var keyIndex = alphabet.indexOf(generatedKey[i])
                RotateRight(keyIndex)
                plaintext += alphabet[keyIndex]
                RotateLeft(keyIndex)
            } else plaintext += ciphertext[i]
        }

        return plaintext
    }

    /**
     * Rotate alphabet to the left by "amount"
     * @param amount
     */
    override fun RotateLeft(amount: Int) {
        val elements:Queue<Char> = LinkedList<Char>(alphabet.toMutableList())
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

    /**
     * Generate key as long as "length"
     * @param length length of the key string
     * @return newKey generated key returned
     */
    private fun GenerateKey(length:Int) : String {
        var newKey:String = ""
        var ksIndex = 0
        while (newKey.length < length) {
            if (ksIndex < key.length) {
                newKey += key[ksIndex]
                ksIndex += 1
            } else ksIndex = 0
        }

        return newKey
    }
}