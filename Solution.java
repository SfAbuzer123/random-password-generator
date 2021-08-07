package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        boolean zero = false;
        boolean one = false;
        boolean two = false;
        byte[] arr = new byte[8];
        for (int i = 0; i < 8; i++) {
            int path = (int) (Math.random() * 2.99);
            if (path == 0) {
                arr[i] = (byte) (Math.random() * 90);
                while (arr[i] > 90 || arr[i] < 65)
                    arr[i] = (byte) (Math.random() * 90);
                zero = true;
            } else if (path == 1) {
                arr[i] = (byte) (Math.random() * 57);
                while (arr[i] > 57 || arr[i] < 48)
                    arr[i] = (byte) (Math.random() * 57);
                one = true;
            } else if (path == 2) {
                arr[i] = (byte) (Math.random() * 122);
                while (arr[i] > 122 || arr[i] < 97)
                    arr[i] = (byte) (Math.random() * 122);
                two = true;
            }
        }
        if (zero && one && two) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(arr);
                return byteArrayOutputStream;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getPassword();
    }
}
