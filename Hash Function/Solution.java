class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        long answer = 0;
        for(int i = 0; i < key.length; i++){
            answer = (answer * 33 + key[i]) % HASH_SIZE;
        }
        return (int)(answer);
    }
};
