package exec

interface CipherMachine {
    /**
     * Encrypt the plaintext
     */
    fun Encrypt(plaintext: String) : String

    /**
     * Decrypt the ciphertext
     */
    fun Decrypt(ciphertext: String) : String

    /**
     * Rotate the alphabet to the left
     */
    fun RotateLeft(amount: Int)

    /**
     * Rotate the alphabet to the right
     */
    fun RotateRight(amount: Int)
}