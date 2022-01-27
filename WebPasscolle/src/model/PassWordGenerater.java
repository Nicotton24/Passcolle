package model;

import java.util.Random;

public class PassWordGenerater {

	public String Generater(int length, boolean low, boolean upp, boolean num, boolean sign){

		//生成処理
        StringBuilder result = new StringBuilder();
        //パスワードに使用する文字を格納
        StringBuilder source = new StringBuilder();

        try {
        //アルファベット小文字
		if(low) {
			for (int i = 0x61; i < 0x7b; i++) {
                source.append((char) i);
            }
		}

		//アルファベット大文字
		if(upp) {
			for (int i = 0x41; i < 0x5b; i++) {
                source.append((char) i);
            }
		}

		//数字
		if(num) {
	        for (int i = 0x30; i < 0x3A; i++) {
	            source.append((char) i);
	        }
		}

        //記号(#,$,%,&)
        if (sign) {
            for (int i = 0x23; i < 0x27; i++) {
                source.append((char) i);
            }
        }

        int sourceLength = source.length();
        Random random = new Random();
        while (result.length() < length) {
            result.append(source.charAt(Math.abs(random.nextInt()) % sourceLength));
        }

		}catch(ArithmeticException e) {      //sourceLength	に何も入ってないとき
			return "文字が選択されていない";
		}

        //出力
        return result.toString();

	}

}
