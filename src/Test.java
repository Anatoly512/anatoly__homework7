public class Test {
    public static void main(String[] args) {
        String key = "key";
        String text = "text";
        boolean needToChange = false;
        Encryption encryption = new Encryption(new DESAlgorithm());
        String cryptedText = encryption.crypt(text, key);


   //...
        needToChange = true;
  //...
        if (needToChange)
            encryption.setAlgorithm(new RSAAlgorithm());
  //...

        cryptedText = encryption.crypt(text, key);

    }

}

//  Strategy - набор взаимозаменяемых алгоритмов с единым интерфейсом;







