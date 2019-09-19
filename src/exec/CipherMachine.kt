package exec

/**
 * The CipherMachine interface all other inherit from
 */
interface CipherMachine {
    /**
     * Encrypt the plaintext
     * @param plaintext
     * @return ciphertext
     */
    fun Encrypt(plaintext: String) : String

    /**
     * Decrypt the ciphertext
     * @param ciphertext
     * @return plaintext
     */
    fun Decrypt(ciphertext: String) : String

    /**
     * Rotate the alphabet to the left
     * @param amount
     */
    fun RotateLeft(amount: Int)

    /**
     * Rotate the alphabet to the right
     * @param amount
     */
    fun RotateRight(amount: Int)
}