class LeetSpeaker {
    companion object {
        fun leetify(str: String): String {
            var toLeet = ""
            for (char in str) {
                toLeet += leetifyChar(char)
            }
            return toLeet
        }

        private fun leetifyChar(toLeet: Char): Char {
            val original = toLeet
            var toLeet = toLeet.lowercaseChar()
            when (toLeet) {
                'a' -> toLeet = '@'
                'b' -> toLeet = 'ß'
                'c' -> toLeet = '¢'
                'd' -> toLeet = original
                'e' -> toLeet = '3'
                'f' -> toLeet = 'ƒ'
                'g' -> toLeet = original
                'h' -> toLeet = '#'
                'i' -> toLeet = '!'
                'j' -> toLeet = original
                'k' -> toLeet = original
                'l' -> toLeet = '1'
                'm' -> toLeet = original
                'n' -> toLeet = original
                'o' -> toLeet = '0'
                'p' -> toLeet = original
                'q' -> toLeet = 'Q'
                'r' -> toLeet = '®'
                's' -> toLeet = '$'
                't' -> toLeet = '7'
                'u' -> toLeet = 'µ'
                'v' -> toLeet = original
                'w' -> toLeet = 'Ш'
                'x' -> toLeet = '×'
                'y' -> toLeet = original
                'z' -> toLeet = original
                else -> return original
            }
            return toLeet
        }
    }

}