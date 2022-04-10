class unique_morse_code_words {

    public static final String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                                      "....", "..", ".---", "-.-", ".-..", "--", "-.",
                                      "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                                      "...-", ".--", "-..-", "-.--", "--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> res = new HashSet<String>();
        for(String word : words){
            StringBuilder code = new StringBuilder();
            for(int i = 0;i < word.length();i++){
                char letter = word.charAt(i);
                code.append(MORSE[letter - 'a']);
            }
            res.add(code.toString());
        }
        return res.size();
    }
}
