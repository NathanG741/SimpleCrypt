
public class ROT13  {

    ROT13(Character cs, Character cf) {
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {

        return decrypt(encrypt(text));
    }

    public String encrypt(String text) {
        return rotate(text, 'n');
    }

    public String decrypt(String text) {
        return rotate(text, 'n');
    }

    public static String rotate(String s, Character ch) {
        StringBuilder result = new StringBuilder();
        int shift = getShift(ch);

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            boolean isLower = Character.isLowerCase(c);

            if (Character.isLetter(c) & isLower) {
                c = (char) ('a' + (c - 'a' + shift) % 26);
            } else if (Character.isLetter(c) & !isLower) {
                c = (char) ('A' + (c - 'A' + shift) % 26);
            }

            result.append(c);

        }

        return result.toString();
    }

    private static int getShift(Character c) {
        int shift;
        if (Character.isLowerCase(c)) {
            shift = c - 'a';
        } else {
            shift = c - 'A';
        }
        return shift;
    }

}